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
import java.util.Date;


@Entity
@Table(name = "TbDocument")

public class Document {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DocId")
    private Long id;

    @Column(name = "NoKlaim", nullable = true)
    private String noKlaim;

    @Column(name = "NmPemohon" , nullable = true)
    private String nmPemohon;

    @Column(name = "Email", nullable = true)
    private String email;

    @Column(name = "HP", nullable = true)
    private String hp;

//    @Column(name = "TglKejadian", nullable = true)
//    private Date tglKejadian;

    @Column(name = "FormK1", nullable = true)
    private String k1;

    @Column(name = "FormK2", nullable = true)
    private String k2;

    @Column(name = "KTPKonsumen", nullable = true)
    private String ktpKonsumen;

    @Column(name = "KTPPengaju", nullable = true)
    private String ktpPengaju;

    @Column(name = "KK", nullable = true)
    private String kk;

    @Column(name = "ResumeMedis", nullable = true)
    private String resumeMedis;

    @Column(name = "SertifikatCP", nullable = true)
    private String sertifikatCP;

    @Column(name = "TglKeputusan", nullable = true)
    private Date tglKeputusan;

    //optional dokumen
    @Column(name = "SKPolisi", nullable = true)
    private String skPolisi;

    @Column(name = "SKTidakKerja", nullable = true)
    private String skTidakKerja;

    //yang diupload admin
    @Column(name = "SuratPengantar", nullable = true)
    private String pengantar;

    @Column (name = "LoanLedger", nullable = true)
    private String loanLedger;

    //optional jika telat lapor
    @Column (name = "TelatLapor", nullable = true)
    private String telatLapor;

    //jika ada revisi
    @Column(name = "Pesan", nullable = true)
    private String pesan;

    //default
    @Column(name = "IsProgress",nullable = false)
    private String isProgress="1";

    @Column(name = "TglTerima", nullable = true)
    private Date tglTerima=new Date();

    @Column(name = "IsActive",nullable = false)
    private Boolean isActive=true;

    @ManyToOne
    @JoinColumn(name = "IdAkun")
    private Akun akun;

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

    public String getK2() {
        return k2;
    }

    public void setK2(String k2) {
        this.k2 = k2;
    }

    public String getKtpKonsumen() {
        return ktpKonsumen;
    }

    public void setKtpKonsumen(String ktpKonsumen) {
        this.ktpKonsumen = ktpKonsumen;
    }

    public String getKtpPengaju() {
        return ktpPengaju;
    }

    public void setKtpPengaju(String ktpPengaju) {
        this.ktpPengaju = ktpPengaju;
    }

    public String getKk() {
        return kk;
    }

    public void setKk(String kk) {
        this.kk = kk;
    }

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

    public String getResumeMedis() {
        return resumeMedis;
    }

    public void setResumeMedis(String resumeMedis) {
        this.resumeMedis = resumeMedis;
    }

    public String getSkPolisi() {
        return skPolisi;
    }

    public void setSkPolisi(String skPolisi) {
        this.skPolisi = skPolisi;
    }

    public String getSertifikatCP() {
        return sertifikatCP;
    }

    public void setSertifikatCP(String sertifikatCP) {
        this.sertifikatCP = sertifikatCP;
    }

    public String getSkTidakKerja() {
        return skTidakKerja;
    }

    public void setSkTidakKerja(String skTidakKerja) {
        this.skTidakKerja = skTidakKerja;
    }

    public String getPengantar() {
        return pengantar;
    }

    public void setPengantar(String pengantar) {
        this.pengantar = pengantar;
    }

    public String getPesan() {
        return pesan;
    }

    public void setPesan(String pesan) {
        this.pesan = pesan;
    }

    public String getNmPemohon() {
        return nmPemohon;
    }

    public void setNmPemohon(String nmPemohon) {
        this.nmPemohon = nmPemohon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHp() {
        return hp;
    }

    public void setHp(String hp) {
        this.hp = hp;
    }

    public String getLoanLedger() {
        return loanLedger;
    }

    public void setLoanLedger(String loanLedger) {
        this.loanLedger = loanLedger;
    }

    public String getTelatLapor() {
        return telatLapor;
    }

    public void setTelatLapor(String telatLapor) {
        this.telatLapor = telatLapor;
    }

    public Akun getAkun() {
        return akun;
    }

    public void setAkun(Akun akun) {
        this.akun = akun;
    }

    public String getNoKlaim() {
        return noKlaim;
    }

    public void setNoKlaim(String noKlaim) {
        this.noKlaim = noKlaim;
    }

    public Date getTglKeputusan() {
        return tglKeputusan;
    }

    public void setTglKeputusan(Date tglKeputusan) {
        this.tglKeputusan = tglKeputusan;
    }

    public Date getTglTerima() {
        return tglTerima;
    }

    public void setTglTerima(Date tglTerima) {
        this.tglTerima = tglTerima;
    }
}
