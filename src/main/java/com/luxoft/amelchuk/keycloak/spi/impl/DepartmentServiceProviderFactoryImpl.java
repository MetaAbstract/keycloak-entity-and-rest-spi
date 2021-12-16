package com.luxoft.amelchuk.keycloak.spi.impl;

import com.luxoft.amelchuk.keycloak.spi.DepartmentServiceProviderFactory;
import com.luxoft.amelchuk.keycloak.spi.DepartmentService;
import org.keycloak.Config;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.KeycloakSessionFactory;

public class DepartmentServiceProviderFactoryImpl implements DepartmentServiceProviderFactory {
    @Override
    public DepartmentService create(KeycloakSession session) {

        return new DepartmentServiceImpl(session);
    }

    /**
     * Only called once when the factory is first created.  This config is pulled from keycloak_server.json
     *
     * @param config
     */
    @Override
    public void init(Config.Scope config) {

    }

    /**
     * Called after all provider factories have been initialized
     *
     * @param factory
     */
    @Override
    public void postInit(KeycloakSessionFactory factory) {

    }

    /**
     * This is called when the server shuts down.
     */
    @Override
    public void close() {

    }

    @Override
    public String getId() {
        return "departmentServiceImpl";
    }
}
