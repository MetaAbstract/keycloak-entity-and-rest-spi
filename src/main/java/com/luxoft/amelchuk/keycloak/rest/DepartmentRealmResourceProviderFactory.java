package com.luxoft.amelchuk.keycloak.rest;

import org.keycloak.Config;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.KeycloakSessionFactory;
import org.keycloak.services.resource.RealmResourceProviderFactory;

public class DepartmentRealmResourceProviderFactory implements RealmResourceProviderFactory {
    public static final String ID = "departments-realm";

    @Override
    public String getId() {
        return ID;
    }

    @Override
    public DepartmentRealmResourceProvider create(KeycloakSession session) {
        return new DepartmentRealmResourceProvider(session);
    }

    @Override
    public void init(Config.Scope config) {
    }

    @Override
    public void postInit(KeycloakSessionFactory factory) {
    }

    @Override
    public void close() {
    }
}
