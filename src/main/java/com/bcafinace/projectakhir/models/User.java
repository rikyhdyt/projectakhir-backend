package com.bcafinace.projectakhir.models;
/*
Created by IntelliJ IDEA 2022.2.3 (Community Edition)
Build #IC-222.4345.14, built on October 5, 2022
@Author Kyoto a.k.a Riky Hidayat
Java Developer
Created on 19/01/2023
@Last Modified 19/01/2023 13:42
Version 1.0
*/

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "TbUser")

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UserId")
    private Long id;

    @Column(name="NoKontrak" ,nullable = false,unique = true)
    private String noKontrak;

    @Column(name = "Email", nullable = false,unique = true)
    private String email;

    @Column(name="Nama" ,nullable = false,unique = true)
    private String nama;

    @Column(name = "IsActive",nullable = false)
    private Boolean isActive=true;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNoKontrak() {
        return noKontrak;
    }

    public void setNoKontrak(String noKontrak) {
        this.noKontrak = noKontrak;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }
}
