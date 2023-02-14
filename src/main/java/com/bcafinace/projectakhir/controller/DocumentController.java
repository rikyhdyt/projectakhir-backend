package com.bcafinace.projectakhir.controller;
/*
Created by IntelliJ IDEA 2022.2.3 (Community Edition)
Build #IC-222.4345.14, built on October 5, 2022
@Author Kyoto a.k.a Riky Hidayat
Java Developer
Created on 20/01/2023
@Last Modified 20/01/2023 09:54
Version 1.0
*/

import com.bcafinace.projectakhir.handler.ResourceNotFoundException;
import com.bcafinace.projectakhir.handler.ResponseHandler;
import com.bcafinace.projectakhir.models.Document;
import com.bcafinace.projectakhir.repos.DocumentRepo;
import com.bcafinace.projectakhir.service.DocumentService;
import com.bcafinace.projectakhir.utils.ConstantMessage;
import com.bcafinace.projectakhir.utils.FileUploadUtil;
import lombok.Getter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("api/document")
public class DocumentController {
    
    @Getter
    private DocumentService documentService;

    public DocumentController(){}

    @Autowired
    public DocumentController(DocumentService documentService){ this.documentService=documentService;}

    @Autowired
    private DocumentRepo documentRepo;

    @GetMapping("/getAll")
    public ResponseEntity<Object> findAllDocument()throws Exception{

        List<Document> lsDocument =documentService.findAllDocument();

        if (lsDocument.size() == 0) {
            throw new ResourceNotFoundException(ConstantMessage.WARNING_DATA_EMPTY);
        }

        return new ResponseHandler().
                generateResponse(ConstantMessage.SUCCESS_FIND_BY, HttpStatus.OK, lsDocument, null, null);
    }

    @PutMapping("/updateFlag")
    public ResponseEntity<Object> updateFlag(@RequestBody Document document) throws Exception{
        documentService.updateDocumentFlag(document);
        return new ResponseHandler().
                generateResponse(ConstantMessage.SUCCESS_FIND_BY, HttpStatus.OK,"",null,null);
    }

    @PostMapping("/upload")
    public String handleSubmit(
                               @RequestParam("k1")MultipartFile multipartFile
//                               @RequestParam("Pengantar")MultipartFile multipartFile2
                               ) throws Exception{

        Document document = new Document();
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
//        String suratPengantarFileName = StringUtils.cleanPath(multipartFile2.getOriginalFilename());

        document.setK1(fileName);
//        document.setPengantar(suratPengantarFileName);

        Document savedDocument = documentRepo.save(document);
        String uploadDir = "uploads/" + savedDocument.getId();

        FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
//        FileUploadUtil.saveFile(uploadDir, suratPengantarFileName, multipartFile2);

        return "message";
    }

}





