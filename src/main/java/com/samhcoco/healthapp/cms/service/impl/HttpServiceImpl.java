package com.samhcoco.healthapp.cms.service.impl;

import com.samhcoco.healthapp.cms.model.Product;
import com.samhcoco.healthapp.cms.model.Response;
import com.samhcoco.healthapp.cms.service.HttpService;
import com.samhcoco.healthapp.cms.service.KeycloakService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import static org.springframework.http.HttpMethod.POST;
import static org.springframework.http.HttpMethod.GET;

@Service
@RequiredArgsConstructor
public class HttpServiceImpl implements HttpService {

    private final RestTemplate restTemplate;
    private final KeycloakService keycloakService;

    @Override
    public <T> Response<T> post(@NonNull String url, T body) {
        val request = getAdminRequest(body);
        return execute(url, POST, request, body);
    }

    @Override
    public <T> Response<T> get(@NonNull String url, @NonNull T responseType) {
        val request = getAdminRequest(null);
        return execute(url, GET, request, responseType);
    }

    /**
     * Execute HTTP request.
     * @param url URL.
     * @param method {@link HttpMethod}.
     * @param request {@link HttpEntity}.
     * @param responseType {@link Class<T>} response type.
     * @param <T> {@link Class<T>}.
     * @return {@link Response<T>}.
     */
    private <T> Response<T> execute(@NonNull String url,
                                    @NonNull HttpMethod method,
                                    @NonNull HttpEntity request,
                                    @NonNull T responseType) {
        try {
            val response = restTemplate.exchange(url, method, request, responseType.getClass());
            val body = response.getBody();
            val status = response.getStatusCode();
            return new Response(body, status, null);
        } catch (HttpStatusCodeException e) {
            return new Response(e.getResponseBodyAsString(), e.getStatusCode(), e.getMessage());
        }
    }

    /**
     * Build an {@link HttpEntity<T>} request with admin authorization.
     * @param body Request body.
     * @param <T> Object type.
     * @return {@link HttpEntity<T>}.
     */
    private <T> HttpEntity<T> getAdminRequest(T body) {
        val headers = new HttpHeaders();
        val adminToken = keycloakService.getAdminToken();
        headers.setBearerAuth(adminToken.getAccessToken());
        return new HttpEntity<>(body, headers);
    }

}
