package com.luxoft.amelchuk.keycloak.spi;

import com.luxoft.amelchuk.keycloak.DepartmentRepresentation;
import org.keycloak.provider.Provider;

import java.util.List;

public interface DepartmentService extends Provider {
    List<DepartmentRepresentation> listDepartments();

    DepartmentRepresentation findDepartment(String id);

    DepartmentRepresentation createDepartment(DepartmentRepresentation departmentRepresentation);

    DepartmentRepresentation updateDepartment(DepartmentRepresentation departmentRepresentation);

    DepartmentRepresentation deleteDepartment(DepartmentRepresentation departmentRepresentation);
}
