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
import com.bcafinace.projectakhir.repos.AkunRepo;
import com.bcafinace.projectakhir.utils.ConstantMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AkunService {

    private AkunRepo akunRepo;

    @Autowired
    public AkunService(AkunRepo akunRepo){ this.akunRepo=akunRepo; }

    public Akun validationAkun(String noKontrak, String noPolis) throws Exception{
        return akunRepo.findByNoKontrakAndNoPolis(noKontrak, noPolis).
                orElseThrow(()-> new ResourceNotFoundException(ConstantMessage.WARNING_NOT_FOUND));
    }

}
