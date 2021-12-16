package com.luxoft.amelchuk.keycloak.rest;

import org.keycloak.models.KeycloakSession;
import org.keycloak.services.resource.RealmResourceProvider;

public class DepartmentRealmResourceProvider implements RealmResourceProvider {
    private KeycloakSession session;

    public DepartmentRealmResourceProvider(KeycloakSession session) {
        this.session = session;
    }

    @Override
    public Object getResource() {
        return new DepartmentRestResource(session);
    }

    @Override
    public void close() {
    }
}
