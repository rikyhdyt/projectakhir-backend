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
                               @RequestParam("k1")MultipartFile multipartFile1,
                               @RequestParam("pengantar")MultipartFile multipartFile2,
                               @RequestParam("k2")MultipartFile multipartFile3,
                               @RequestParam("ktpKonsumen")MultipartFile multipartFile4,
                               @RequestParam("ktpPengaju")MultipartFile multipartFile5,
                               @RequestParam("kk")MultipartFile multipartFile6,
                               @RequestParam("resumeMedis")MultipartFile multipartFile7,
                               @RequestParam(value = "skPolisi", required = false)MultipartFile multipartFile8,
                               @RequestParam("sertifikatCP")MultipartFile multipartFile9,
                               @RequestParam(value = "skTidakKerja", required = false)MultipartFile multipartFile10,
                               @RequestParam("nmPemohon")String param1,
                               @RequestParam("email")String param2,
                               @RequestParam("hp")String param3,
                               @RequestParam(value = "pesan", required = false)String param4
                               ) throws Exception{

        Document document = new Document();

        String formK1fileName = StringUtils.cleanPath(multipartFile1.getOriginalFilename());
        String suratPengantarFileName = StringUtils.cleanPath(multipartFile2.getOriginalFilename());
        String formK2fileName = StringUtils.cleanPath(multipartFile3.getOriginalFilename());
        String ktpKonsumen = StringUtils.cleanPath(multipartFile4.getOriginalFilename());
        String ktpPengaju = StringUtils.cleanPath(multipartFile5.getOriginalFilename());
        String kk = StringUtils.cleanPath(multipartFile6.getOriginalFilename());
        String resumeMedis = StringUtils.cleanPath(multipartFile7.getOriginalFilename());
        String skPolisi = StringUtils.cleanPath(multipartFile8.getOriginalFilename());
        String sertifikatCP = StringUtils.cleanPath(multipartFile9.getOriginalFilename());
        String skTidakKerja = StringUtils.cleanPath(multipartFile10.getOriginalFilename());

        document.setK1(formK1fileName);
        document.setPengantar(suratPengantarFileName);
        document.setK2(formK2fileName);
        document.setKtpKonsumen(ktpKonsumen);
        document.setKtpPengaju(ktpPengaju);
        document.setKk(kk);
        document.setResumeMedis(resumeMedis);
        document.setSkPolisi(skPolisi);
        document.setSertifikatCP(sertifikatCP);
        document.setSkTidakKerja(skTidakKerja);
        document.setNmPemohon(param1);
        document.setEmail(param2);
        document.setHp(param3);
        document.setPesan(param4);

        Document savedDocument = documentRepo.save(document); //save to db
        String uploadDir = "uploads/" + savedDocument.getId();

        FileUploadUtil.saveFile(uploadDir, formK1fileName, multipartFile1);
        FileUploadUtil.saveFile(uploadDir, suratPengantarFileName, multipartFile2);
        FileUploadUtil.saveFile(uploadDir, formK2fileName, multipartFile3);
        FileUploadUtil.saveFile(uploadDir, ktpKonsumen, multipartFile4);
        FileUploadUtil.saveFile(uploadDir, ktpPengaju, multipartFile5);
        FileUploadUtil.saveFile(uploadDir, kk, multipartFile6);
        FileUploadUtil.saveFile(uploadDir, resumeMedis, multipartFile7);
        FileUploadUtil.saveFile(uploadDir, skPolisi, multipartFile8);
        FileUploadUtil.saveFile(uploadDir, sertifikatCP, multipartFile9);
        FileUploadUtil.saveFile(uploadDir, skTidakKerja, multipartFile10);

        return "Dokumen berhasil diupload";
    }

}





