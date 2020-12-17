package com.samhcoco.healthapp.cms.service;

import com.samhcoco.healthapp.cms.model.keycloak.KeycloakToken;

public interface KeycloakService {

    KeycloakToken getAdminToken();

}
