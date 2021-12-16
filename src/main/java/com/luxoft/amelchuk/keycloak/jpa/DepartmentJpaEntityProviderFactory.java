package com.luxoft.amelchuk.keycloak.jpa;

import org.keycloak.Config;
import org.keycloak.connections.jpa.entityprovider.JpaEntityProvider;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.KeycloakSessionFactory;

public class DepartmentJpaEntityProviderFactory implements org.keycloak.connections.jpa.entityprovider.JpaEntityProviderFactory {
    public static final String ID="KEYCLOAK_AMELCHUK";
    @Override
    public JpaEntityProvider create(KeycloakSession session) {
        return new DepartmentJpaEntityProvider();
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

    @Override
    public String getId() {
        return DepartmentJpaEntityProviderFactory.ID;
    }
}
