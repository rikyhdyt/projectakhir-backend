package com.bcafinace.projectakhir.models;
/*
Created by IntelliJ IDEA 2022.2.3 (Community Edition)
Build #IC-222.4345.14, built on October 5, 2022
@Author Kyoto a.k.a Riky Hidayat
Java Developer
Created on 19/01/2023
@Last Modified 19/01/2023 13:52
Version 1.0
*/

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "TbMaskapai")

public class Maskapai {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MasId")
    private Long id;

    @Column(name = "MasUsername", nullable = false,unique = true)
    private String username;

    @Column(name = "MasPassword",nullable = false)
    private String password;

    @Column(name = "IsActive",nullable = false)
    private Boolean isActive=true;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }
}
