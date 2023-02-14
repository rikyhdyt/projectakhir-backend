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
@Table(name = "TbDocument")

public class Document {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DocId")
    private Long id;

    @Column(name = "FormK1", nullable = true)
    private String k1;

//    @Column(name = "FormK2", nullable = false)
//    private String k2;
//
//    @Column(name = "KTPKonsumen", nullable = false)
//    private String ktpKonsumen;
//
//    @Column(name = "KTPPengaju", nullable = false)
//    private String ktpPengaju;
//
//    @Column(name = "KK", nullable = false)
//    private String kk;

    @Column(name = "Pesan", nullable = true)
    private String pesan;

    @Column(name = "SuratPengantar", nullable = true)
    private String pengantar;

    @Column(name = "IsProgress",nullable = false)
    private String isProgress="1";

    @Column(name = "IsActive",nullable = false)
    private Boolean isActive=true;

//    @ManyToOne
//    @JoinColumn(name = "MaskapaiId")
//    private Maskapai maskapai;
//
//    @ManyToOne
//    @JoinColumn(name = "UserId")
//    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getK1() {
        return k1;
    }

    public void setK1(String k1) {
        this.k1 = k1;
    }

//    public String getK2() {
//        return k2;
//    }
//
//    public void setK2(String k2) {
//        this.k2 = k2;
//    }
//
//    public String getKtpKonsumen() {
//        return ktpKonsumen;
//    }
//
//    public void setKtpKonsumen(String ktpKonsumen) {
//        this.ktpKonsumen = ktpKonsumen;
//    }
//
//    public String getKtpPengaju() {
//        return ktpPengaju;
//    }
//
//    public void setKtpPengaju(String ktpPengaju) {
//        this.ktpPengaju = ktpPengaju;
//    }
//
//    public String getKk() {
//        return kk;
//    }
//
//    public void setKk(String kk) {
//        this.kk = kk;
//    }

    public String getIsProgress() {
        return isProgress;
    }

    public void setIsProgress(String isProgress) {
        this.isProgress = isProgress;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

//    public Maskapai getMaskapai() {
//        return maskapai;
//    }
//
//    public void setMaskapai(Maskapai maskapai) {
//        this.maskapai = maskapai;
//    }
//
//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
}
