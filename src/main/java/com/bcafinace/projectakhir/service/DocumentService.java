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
import com.bcafinace.projectakhir.repos.DocumentRepo;
import com.bcafinace.projectakhir.utils.ConstantMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DocumentService {

    private DocumentRepo documentRepo;

    @Autowired
    public DocumentService(DocumentRepo documentRepo){
        this.documentRepo=documentRepo;
    }

    public void updateDocumentFlag(Document d) throws Exception{
        Document document = documentRepo.findById(d.getId()).orElseThrow(()->
                new ResourceNotFoundException(ConstantMessage.WARNING_NOT_FOUND));

        document.setIsProgress(d.getIsProgress());

        document.setIsActive(d.getIsActive());
    }

    public List<Document> findAllDocument(){return documentRepo.findAll();}

}
