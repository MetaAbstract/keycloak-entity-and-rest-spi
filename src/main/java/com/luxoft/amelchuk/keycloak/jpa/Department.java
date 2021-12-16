package com.luxoft.amelchuk.keycloak.jpa;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "DEPARTMENTS")
@NamedQueries({ @NamedQuery(name = "findByRealm", query = "from Department where realmId = :realmId") })
@Getter
@Setter
public class Department {
    @Id
    @Column(name = "ID", nullable = false, length = 36)
    String id;
    @Column(name = "NAME", nullable = false)
    String Name;
    @Column(name = "DESCRIPTION")
    String Description;
    @Column(name = "DATE_CREATED")
    Timestamp DateCreated;
    @Column(name = "DATE_UPDATED")
    Timestamp DateUpdated;
    @Column(name = "REALM_ID", nullable = false, length = 36)
    private String realmId;
}
