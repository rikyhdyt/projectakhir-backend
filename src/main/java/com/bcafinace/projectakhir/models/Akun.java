package com.bcafinace.projectakhir.models;/*
Created by IntelliJ IDEA 2022.2.3 (Community Edition)
Build #IC-222.4345.14, built on October 5, 2022
@Author Kyoto a.k.a Riky Hidayat
Java Developer
Created on 06/02/2023
@Last Modified 06/02/2023 13:34
Version 1.0
*/

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;


@Entity
@Table(name = "TbAkun")

public class Akun {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AkunId")
    private Long id;

    @Column(name = "NmKonsumen", nullable = true)
    private String nmKonsumen;

    @Column(name = "NoKontrak", nullable = false, unique = true)
    private String noKontrak;

    @Column(name = "NoPolis", nullable = false, unique = true)
    private String noPolis;

    @Column(name = "Description", nullable = true)
    private String description;

    @Column(name = "TglLoan", nullable = false)
    private Date tglLoan;

    @Column(name = "IsCp", nullable = false)
    private boolean isCp;

    @Column(name = "Tenor", nullable = false)
    private Integer tenor;

    @Column(name = "IsActive")
    private boolean isActive=true;

    @ManyToOne
    @JoinColumn(name = "IdMaskapai")
    private Maskapai maskapai;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNmKonsumen() {
        return nmKonsumen;
    }

    public void setNmKonsumen(String nmKonsumen) {
        this.nmKonsumen = nmKonsumen;
    }

    public String getNoKontrak() {
        return noKontrak;
    }

    public void setNoKontrak(String noKontrak) {
        this.noKontrak = noKontrak;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getTglLoan() {
        return tglLoan;
    }

    public void setTglLoan(Date tglLoan) {
        this.tglLoan = tglLoan;
    }

    public boolean isCp() {
        return isCp;
    }

    public void setCp(boolean cp) {
        isCp = cp;
    }

    public Integer getTenor() {
        return tenor;
    }

    public void setTenor(Integer tenor) {
        this.tenor = tenor;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getNoPolis() {
        return noPolis;
    }

    public void setNoPolis(String noPolis) {
        this.noPolis = noPolis;
    }

    public Maskapai getMaskapai() {
        return maskapai;
    }

    public void setMaskapai(Maskapai maskapai) {
        this.maskapai = maskapai;
    }
}
