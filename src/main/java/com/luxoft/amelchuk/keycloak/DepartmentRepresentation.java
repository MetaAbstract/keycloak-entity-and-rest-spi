package com.luxoft.amelchuk.keycloak;

import com.luxoft.amelchuk.keycloak.jpa.Department;
import lombok.Getter;
import lombok.Setter;
@Getter @Setter
public class DepartmentRepresentation {

    private String id;

    private String name;
    public DepartmentRepresentation(Department department) {
        id = department.getId();
        name = department.getName();
    }
}
