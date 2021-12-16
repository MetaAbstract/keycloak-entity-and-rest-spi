package com.luxoft.amelchuk.keycloak.jpa;

import java.util.Collections;
import java.util.List;

public class DepartmentJpaEntityProvider implements org.keycloak.connections.jpa.entityprovider.JpaEntityProvider {
    @Override
    public List<Class<?>> getEntities() {
        return Collections.singletonList(Department.class);
    }

    @Override
    public String getChangelogLocation() {
        return "/META-INF/departments-changelog.xml";
    }

    @Override
    public String getFactoryId() {
        return DepartmentJpaEntityProviderFactory.ID;
    }

    @Override
    public void close() {

    }
}
