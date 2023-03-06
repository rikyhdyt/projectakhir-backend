package com.bcafinace.projectakhir.service;/*
Created by IntelliJ IDEA 2022.2.3 (Community Edition)
Build #IC-222.4345.14, built on October 5, 2022
@Author Kyoto a.k.a Riky Hidayat
Java Developer
Created on 20/01/2023
@Last Modified 20/01/2023 09:53
Version 1.0
*/

import com.bcafinace.projectakhir.handler.ResourceNotFoundException;
import com.bcafinace.projectakhir.models.Document;
import com.bcafinace.projectakhir.models.Maskapai;
import com.bcafinace.projectakhir.repos.DocumentRepo;
import com.bcafinace.projectakhir.repos.MaskapaiRepo;
import com.bcafinace.projectakhir.utils.ConstantMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MaskapaiService {

    private MaskapaiRepo maskapaiRepo;
    private DocumentRepo documentRepo;

    @Autowired
    public MaskapaiService(MaskapaiRepo maskapaiRepo, DocumentRepo documentRepo)
    {this.maskapaiRepo=maskapaiRepo;
    this.documentRepo=documentRepo;}


    public List<Document> getForMaskapai(Long id){
        return documentRepo.getPengajuanForMaskapai(id);
    }

    public Object maskapaiLogin(Maskapai credential) throws Exception{
        Maskapai maskapai = maskapaiRepo.findByUsername(credential.getUsername()).orElseThrow(()->
                new ResourceNotFoundException(ConstantMessage.WARNING_LOGIN_FAIL));

        if (maskapai != null){
            if (maskapai.getPassword().equals(credential.getPassword())){
                return maskapai;
            }
            else {
                throw  new ResourceNotFoundException(ConstantMessage.WARNING_LOGIN_FAIL);
            }
        }
        else {
            throw  new ResourceNotFoundException(ConstantMessage.WARNING_LOGIN_FAIL);
        }
    }

}
