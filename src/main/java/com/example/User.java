package com.example;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.inject.Inject;
import jakarta.persistence.*;


@Entity
@Table(name = "usuarios")
public class User extends PanacheEntity {

    public String name;
    public String email;
}