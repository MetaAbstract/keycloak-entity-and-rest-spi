package com.luxoft.amelchuk.keycloak.spi;

import org.keycloak.provider.Provider;
import org.keycloak.provider.ProviderFactory;
import org.keycloak.provider.Spi;

public class DepartmentSpi implements Spi {
    @Override
    public boolean isInternal() {
        return false;
    }

    @Override
    public String getName() {
        return "DepartmentsSPI";
    }

    @Override
    public Class<? extends Provider> getProviderClass() {
        return DepartmentService.class;
    }

    @Override
    public Class<? extends ProviderFactory> getProviderFactoryClass() {
        return DepartmentServiceProviderFactory.class;
    }
}
