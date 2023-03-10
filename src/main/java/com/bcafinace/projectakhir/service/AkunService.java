package com.bcafinace.projectakhir.service;/*
Created by IntelliJ IDEA 2022.2.3 (Community Edition)
Build #IC-222.4345.14, built on October 5, 2022
@Author Kyoto a.k.a Riky Hidayat
Java Developer
Created on 07/02/2023
@Last Modified 07/02/2023 09:07
Version 1.0
*/

import com.bcafinace.projectakhir.handler.ResourceNotFoundException;
import com.bcafinace.projectakhir.models.Akun;
import com.bcafinace.projectakhir.models.Document;
import com.bcafinace.projectakhir.repos.AkunRepo;
import com.bcafinace.projectakhir.repos.DocumentRepo;
import com.bcafinace.projectakhir.utils.ConstantMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AkunService {

    private AkunRepo akunRepo;
    private final DocumentRepo documentRepo;

    @Autowired
    public AkunService(AkunRepo akunRepo,
                       DocumentRepo documentRepo){ this.akunRepo=akunRepo;
        this.documentRepo = documentRepo;
    }

    public Akun validationAkun(String noKontrak, String noPolis) throws Exception{
        return akunRepo.findByNoKontrakAndNoPolis(noKontrak, noPolis).
                orElseThrow(()-> new ResourceNotFoundException(ConstantMessage.WARNING_NOT_FOUND));
    }

    public List<Document> getDataTrack(String noKontrak){
        return documentRepo.getDataTracking(noKontrak);
    }

    public void updateFlagCp(Akun d) throws Exception{
        Akun akun = akunRepo.findById(d.getId()).orElseThrow(()->
                new ResourceNotFoundException(ConstantMessage.WARNING_NOT_FOUND));

        akun.setAjukanCp(true);
        akun.setDescription("Sedang dalam pengajuan klaim CP");
    }

    public Object userLogin(Akun credential) throws Exception{
        Akun akun = akunRepo.findByNoKontrak(credential.getNoKontrak())
                .orElseThrow(()->new ResourceNotFoundException(ConstantMessage.WARNING_LOGIN_FAIL));

        if (akun != null){
            if (akun.getNoPolis().equals(credential.getNoPolis()) && akun.isAjukanCp()==true){
                return akun;
            }
            else {
                throw  new ResourceNotFoundException(ConstantMessage.WARNING_LOGIN_FAIL);
            }

        }else {
            throw  new ResourceNotFoundException(ConstantMessage.WARNING_LOGIN_FAIL);
        }
    }



}
