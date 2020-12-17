package com.samhcoco.healthapp.cms.service.impl;

import com.samhcoco.healthapp.cms.configuration.KeycloakProperties;
import com.samhcoco.healthapp.cms.model.keycloak.KeycloakToken;
import com.samhcoco.healthapp.cms.service.KeycloakService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import static org.springframework.http.HttpMethod.POST;
import static org.springframework.http.MediaType.APPLICATION_FORM_URLENCODED;

@Slf4j
@Service
@RequiredArgsConstructor
public class KeycloakServiceImpl implements KeycloakService {

    private final RestTemplate restTemplate;
    private final KeycloakProperties keycloakProperties;

    @Override
    public KeycloakToken getAdminToken() {
        val url = UriComponentsBuilder.fromHttpUrl(keycloakProperties.getBaseUrl())
                .path("realms/")
                .path(keycloakProperties.getRealm())
                .path("/protocol")
                .path("/openid-connect")
                .path("/token")
                .toUriString();

        val headers = new HttpHeaders();

        headers.setContentType(APPLICATION_FORM_URLENCODED);

        val body = new LinkedMultiValueMap<String, String>();

        body.add("client_id", "admin-cli");
        body.add("username", keycloakProperties.getUsername());
        body.add("password", keycloakProperties.getPassword());
        body.add("grant_type", keycloakProperties.getGrantType());


        val request = new HttpEntity<LinkedMultiValueMap<String, String>>(body, headers);
        val response = restTemplate.exchange(url, POST, request, KeycloakToken.class);

        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        } else {
            val error = response.getStatusCode().getReasonPhrase();
            log.error("Failed to get Keycloak Admin Access Token: " + error);
        }
        return null;
    }

}
