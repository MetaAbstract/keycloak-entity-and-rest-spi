package com.luxoft.amelchuk.keycloak.spi.impl;

import com.luxoft.amelchuk.keycloak.DepartmentRepresentation;
import com.luxoft.amelchuk.keycloak.jpa.Department;
import com.luxoft.amelchuk.keycloak.spi.DepartmentService;
import org.keycloak.connections.jpa.JpaConnectionProvider;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.RealmModel;
import org.keycloak.models.utils.KeycloakModelUtils;

import javax.persistence.EntityManager;
import java.util.LinkedList;
import java.util.List;

public class DepartmentServiceImpl implements DepartmentService {
    private final KeycloakSession session;

    public DepartmentServiceImpl(KeycloakSession session) {
        System.out.println("@ DepartmentServiceImpl constructed");
        this.session = session;
        if (getRealm() == null) {
            throw new IllegalStateException("The service cannot accept a session without a realm in its context.");
        }

    }


    EntityManager getEntityManager() {
        return session.getProvider(JpaConnectionProvider.class).getEntityManager();
    }

    protected RealmModel getRealm() {

        return session.getContext().getRealm();
    }

    @Override
    public List<DepartmentRepresentation> listDepartments() {
        List<DepartmentRepresentation> result = new LinkedList<>();
        return result;
//        try {
//            List<Department> departments = getEntityManager().createNamedQuery("findByRealm", Department.class)
//                    .setParameter("realmId", getRealm().getId())
//                    .getResultList();
//            for( Department department: departments){
//                result.add(new DepartmentRepresentation(department));
//            }
//
//        }
//        catch ( Exception e){
//            System.out.println("ERROR custom:");
//            System.out.println(e.getMessage());
//
//        }
//        return result;
    }

    @Override
    public DepartmentRepresentation findDepartment(String id) {
        Department department = getEntityManager().find(Department.class,id);
        return department==null ? null : new DepartmentRepresentation(department);
    }

    @Override
    public DepartmentRepresentation createDepartment(DepartmentRepresentation departmentRepresentation) {
        Department department = new Department();
        String id = departmentRepresentation.getId() == null ? KeycloakModelUtils.generateId() : department.getId();
        department.setId(id);
        department.setName(departmentRepresentation.getName());
        department.setRealmId(getRealm().getId());
        getEntityManager().persist(department);

        departmentRepresentation.setId(id);

        return departmentRepresentation;
    }

    @Override
    public DepartmentRepresentation updateDepartment(DepartmentRepresentation departmentRepresentation) {
        return departmentRepresentation; //TODO
    }

    @Override
    public DepartmentRepresentation deleteDepartment(DepartmentRepresentation departmentRepresentation) {
        return departmentRepresentation; //TODO
    }

    @Override
    public void close() {
        //clear
    }
}
