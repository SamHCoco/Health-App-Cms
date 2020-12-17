package com.samhcoco.healthapp.cms.service;

import com.samhcoco.healthapp.cms.model.keycloak.KeycloakToken;

public interface KeycloakService {

    /**
     * Returns an admin {@link KeycloakToken}.
     * @return An admin {@link KeycloakToken}.
     */
    KeycloakToken getAdminToken();

}
