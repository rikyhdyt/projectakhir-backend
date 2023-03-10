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
import com.bcafinace.projectakhir.models.Akun;
import com.bcafinace.projectakhir.models.Document;
import com.bcafinace.projectakhir.repos.DocumentRepo;
import com.bcafinace.projectakhir.service.DocumentService;
import com.bcafinace.projectakhir.utils.ConstantMessage;
import com.bcafinace.projectakhir.utils.FileUploadUtil;
import lombok.Getter;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
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

    @GetMapping("/progressForAdmin")
    public ResponseEntity<Object> findData()throws Exception{

        List<Document> lsDocument =documentService.findProgressForAdmin();

        if (lsDocument.size() == 0) {
            throw new ResourceNotFoundException(ConstantMessage.WARNING_DATA_EMPTY);
        }

        return new ResponseHandler().
                generateResponse(ConstantMessage.SUCCESS_FIND_BY, HttpStatus.OK, lsDocument, null, null);
    }

    @GetMapping("/historiForAdmin")
    public ResponseEntity<Object> findDataHistori()throws Exception{

        List<Document> lsDocument =documentService.findHitoriForAdmin();

        if (lsDocument.size() == 0) {
            throw new ResourceNotFoundException(ConstantMessage.WARNING_DATA_EMPTY);
        }

        return new ResponseHandler().
                generateResponse(ConstantMessage.SUCCESS_FIND_BY, HttpStatus.OK, lsDocument, null, null);
    }

    @GetMapping("/getProgress/{isProgress}")
    public ResponseEntity<Object> getDocProg(@PathVariable("isProgress")String isProgress)throws Exception{
        return new ResponseHandler().
                generateResponse(ConstantMessage.SUCCESS_FIND_BY,HttpStatus.OK,documentService.findDocumentProgress(isProgress),null,null);
    }

    @GetMapping("/getDoc/{id}")
    public ResponseEntity<Object> getDocId(@PathVariable("id")long id) throws Exception{

        Document document = documentService.findById(id);

        if (document != null) {
            return new ResponseHandler().
                    generateResponse(ConstantMessage.SUCCESS_FIND_BY, HttpStatus.OK, document, null, null);

        } else {
            throw new ResourceNotFoundException(ConstantMessage.WARNING_NOT_FOUND);
        }
    }

    @PutMapping("/updateFlag")
    public ResponseEntity<Object> updateFlag(@RequestBody Document document) throws Exception{
        documentService.updateDocumentFlag(document);
        return new ResponseHandler().
                generateResponse(ConstantMessage.SUCCESS_FIND_BY, HttpStatus.OK,"",null,null);
    }

    @PutMapping("/revisi")
    public ResponseEntity<Object> updatePesan(@RequestBody Document document) throws Exception{
        documentService.catatanRevisi(document);
        return new ResponseHandler().
                generateResponse(ConstantMessage.SUCCESS_FIND_BY, HttpStatus.OK,"",null,null);
    }

    @GetMapping("/KK/{id}/{kk:.+}")
    public ResponseEntity<byte[]> getKK(@PathVariable("kk")String kk,
                                         @PathVariable ("id")Long id) throws IOException {

        String filePath = "uploads/" +id +"/" +kk;
        InputStream inputStream = new FileInputStream(new File(filePath));

        byte[] bytes = IOUtils.toByteArray(inputStream);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDisposition(ContentDisposition.builder("inline").filename(kk).build());

        return ResponseEntity.ok().headers(headers).body(bytes);
    }

    @GetMapping("/K1/{id}/{k1:.+}")
    public ResponseEntity<byte[]> getFormK1(@PathVariable("k1")String k1,
                                         @PathVariable ("id")Long id) throws IOException {

        String filePath = "uploads/" +id +"/" +k1;
        InputStream inputStream = new FileInputStream(new File(filePath));

        byte[] bytes = IOUtils.toByteArray(inputStream);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDisposition(ContentDisposition.builder("inline").filename(k1).build());

        return ResponseEntity.ok().headers(headers).body(bytes);
    }

    @GetMapping("/K2/{id}/{k2:.+}")
    public ResponseEntity<byte[]> getFormK2(@PathVariable("k2")String k2,
                                            @PathVariable("id")Long id) throws IOException {

        String filePath = "uploads/" +id +"/" +k2;
        InputStream inputStream = new FileInputStream(new File(filePath));

        byte[] bytes = IOUtils.toByteArray(inputStream);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDisposition(ContentDisposition.builder("inline").filename(k2).build());

        return ResponseEntity.ok().headers(headers).body(bytes);
    }

    @GetMapping("/ktpKonsumen/{id}/{ktpKonsumen:.+}")
    public ResponseEntity<byte[]> getFormKtpKonsumen(@PathVariable("ktpKonsumen")String ktpKonsumen,
                                            @PathVariable ("id")Long id) throws IOException {

        String filePath = "uploads/" +id +"/" +ktpKonsumen;
        InputStream inputStream = new FileInputStream(new File(filePath));

        byte[] bytes = IOUtils.toByteArray(inputStream);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDisposition(ContentDisposition.builder("inline").filename(ktpKonsumen).build());

        return ResponseEntity.ok().headers(headers).body(bytes);
    }

    @GetMapping("/ktpPengaju/{id}/{ktpPengaju:.+}")
    public ResponseEntity<byte[]> getFormKtpPengaju(@PathVariable("ktpPengaju")String ktpPengaju,
                                                     @PathVariable ("id")Long id) throws IOException {

        String filePath = "uploads/" +id +"/" +ktpPengaju;
        InputStream inputStream = new FileInputStream(new File(filePath));

        byte[] bytes = IOUtils.toByteArray(inputStream);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDisposition(ContentDisposition.builder("inline").filename(ktpPengaju).build());

        return ResponseEntity.ok().headers(headers).body(bytes);
    }

    @GetMapping("/resumeMedis/{id}/{resumeMedis:.+}")
    public ResponseEntity<byte[]> getResumeMedis(@PathVariable("resumeMedis")String resumeMedis,
                                                    @PathVariable ("id")Long id) throws IOException {

        String filePath = "uploads/" +id +"/" +resumeMedis;
        InputStream inputStream = new FileInputStream(new File(filePath));

        byte[] bytes = IOUtils.toByteArray(inputStream);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDisposition(ContentDisposition.builder("inline").filename(resumeMedis).build());

        return ResponseEntity.ok().headers(headers).body(bytes);
    }

    @GetMapping("/sertifikatCP/{id}/{sertifikatCP:.+}")
    public ResponseEntity<byte[]> getSertifikatCP(@PathVariable("sertifikatCP")String sertifikatCP,
                                                 @PathVariable ("id")Long id) throws IOException {

        String filePath = "uploads/" +id +"/" +sertifikatCP;
        InputStream inputStream = new FileInputStream(new File(filePath));

        byte[] bytes = IOUtils.toByteArray(inputStream);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDisposition(ContentDisposition.builder("inline").filename(sertifikatCP).build());

        return ResponseEntity.ok().headers(headers).body(bytes);
    }

    @GetMapping("/skPolisi/{id}/{skPolisi:.+}")
    public ResponseEntity<byte[]> getskPolisi(@PathVariable("skPolisi")String skPolisi,
                                                  @PathVariable ("id")Long id) throws IOException {

        String filePath = "uploads/" +id +"/" +skPolisi;
        InputStream inputStream = new FileInputStream(new File(filePath));

        byte[] bytes = IOUtils.toByteArray(inputStream);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDisposition(ContentDisposition.builder("inline").filename(skPolisi).build());

        return ResponseEntity.ok().headers(headers).body(bytes);
    }

    @GetMapping("/skTidakKerja/{id}/{skTidakKerja:.+}")
    public ResponseEntity<byte[]> getSkTidakKerja(@PathVariable("skTidakKerja")String skTidakKerja,
                                                  @PathVariable ("id")Long id) throws IOException {

        String filePath = "uploads/" +id +"/" +skTidakKerja;
        InputStream inputStream = new FileInputStream(new File(filePath));

        byte[] bytes = IOUtils.toByteArray(inputStream);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDisposition(ContentDisposition.builder("inline").filename(skTidakKerja).build());

        return ResponseEntity.ok().headers(headers).body(bytes);
    }

    @GetMapping("/suratPengantar/{id}/{pengantar:.+}")
    public ResponseEntity<byte[]> getSuratPengantar(@PathVariable("pengantar")String pengantar,
                                                  @PathVariable ("id")Long id) throws IOException {

        String filePath = "uploads/" +id +"/" +pengantar;
        InputStream inputStream = new FileInputStream(new File(filePath));

        byte[] bytes = IOUtils.toByteArray(inputStream);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDisposition(ContentDisposition.builder("inline").filename(pengantar).build());

        return ResponseEntity.ok().headers(headers).body(bytes);
    }

    @GetMapping("/loanLedger/{id}/{loanLedger:.+}")
    public ResponseEntity<byte[]> getDataLoan(@PathVariable("loanLedger")String loanLedger,
                                                    @PathVariable ("id")Long id) throws IOException {

        String filePath = "uploads/" +id +"/" +loanLedger;
        InputStream inputStream = new FileInputStream(new File(filePath));

        byte[] bytes = IOUtils.toByteArray(inputStream);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDisposition(ContentDisposition.builder("inline").filename(loanLedger).build());

        return ResponseEntity.ok().headers(headers).body(bytes);
    }

    @PutMapping("/kirimPengajuan/{id}")
    public ResponseEntity<Object> updateDocument(
            @PathVariable("id")Long param1,
            @RequestParam("pengantar")MultipartFile pengantar,
            @RequestParam("loanLedger")MultipartFile loanLedger,
            @RequestParam(value = "isProgress", defaultValue = "2")String param2
    ) throws Exception{

//        Document document = new Document();

        String suratPengantar = StringUtils.cleanPath(pengantar.getOriginalFilename());
        String dataLoanLedger = StringUtils.cleanPath(loanLedger.getOriginalFilename());

        Document doc1 =  documentRepo.getById(param1);

        doc1.setPengantar(suratPengantar);
        doc1.setLoanLedger(dataLoanLedger);
        doc1.setIsProgress(param2);
        documentRepo.save(doc1);

        String uploadDir = "uploads/" + doc1.getId();

        FileUploadUtil.saveFile(uploadDir, suratPengantar, pengantar);
        FileUploadUtil.saveFile(uploadDir, dataLoanLedger, loanLedger);

        return new ResponseHandler().generateResponse(ConstantMessage.SUCCESS_SAVE, HttpStatus.CREATED, null, null, null);
    }

    @PostMapping("/upload")
    public ResponseEntity<Object> handleSubmit(
                               @RequestParam("k1")MultipartFile multipartFile1,
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
                               @RequestParam("akun") Akun param5
                               ) throws Exception{

        Document document = new Document();

        if (multipartFile8 == null && multipartFile10 == null) {
            String formK1fileName = StringUtils.cleanPath(multipartFile1.getOriginalFilename());
            String formK2fileName = StringUtils.cleanPath(multipartFile3.getOriginalFilename());
            String ktpKonsumen = StringUtils.cleanPath(multipartFile4.getOriginalFilename());
            String ktpPengaju = StringUtils.cleanPath(multipartFile5.getOriginalFilename());
            String kk = StringUtils.cleanPath(multipartFile6.getOriginalFilename());
            String resumeMedis = StringUtils.cleanPath(multipartFile7.getOriginalFilename());
            String sertifikatCP = StringUtils.cleanPath(multipartFile9.getOriginalFilename());

            document.setK1(formK1fileName);
            document.setK2(formK2fileName);
            document.setKtpKonsumen(ktpKonsumen);
            document.setKtpPengaju(ktpPengaju);
            document.setKk(kk);
            document.setResumeMedis(resumeMedis);
            document.setSertifikatCP(sertifikatCP);
            document.setNmPemohon(param1);
            document.setEmail(param2);
            document.setHp(param3);
            document.setAkun(param5);

            Document savedDocument = documentRepo.save(document); //save to db
            String uploadDir = "uploads/" + savedDocument.getId();

            FileUploadUtil.saveFile(uploadDir, formK1fileName, multipartFile1);
            FileUploadUtil.saveFile(uploadDir, formK2fileName, multipartFile3);
            FileUploadUtil.saveFile(uploadDir, ktpKonsumen, multipartFile4);
            FileUploadUtil.saveFile(uploadDir, ktpPengaju, multipartFile5);
            FileUploadUtil.saveFile(uploadDir, kk, multipartFile6);
            FileUploadUtil.saveFile(uploadDir, resumeMedis, multipartFile7);
            FileUploadUtil.saveFile(uploadDir, sertifikatCP, multipartFile9);
        }
        else if (multipartFile8 == null){
            String formK1fileName = StringUtils.cleanPath(multipartFile1.getOriginalFilename());
            String formK2fileName = StringUtils.cleanPath(multipartFile3.getOriginalFilename());
            String ktpKonsumen = StringUtils.cleanPath(multipartFile4.getOriginalFilename());
            String ktpPengaju = StringUtils.cleanPath(multipartFile5.getOriginalFilename());
            String kk = StringUtils.cleanPath(multipartFile6.getOriginalFilename());
            String resumeMedis = StringUtils.cleanPath(multipartFile7.getOriginalFilename());
            String sertifikatCP = StringUtils.cleanPath(multipartFile9.getOriginalFilename());
            String skTidakKerja = StringUtils.cleanPath(multipartFile10.getOriginalFilename());

            document.setK1(formK1fileName);
            document.setK2(formK2fileName);
            document.setKtpKonsumen(ktpKonsumen);
            document.setKtpPengaju(ktpPengaju);
            document.setKk(kk);
            document.setResumeMedis(resumeMedis);
            document.setSertifikatCP(sertifikatCP);
            document.setSkTidakKerja(skTidakKerja);
            document.setNmPemohon(param1);
            document.setEmail(param2);
            document.setHp(param3);
            document.setAkun(param5);

            Document savedDocument = documentRepo.save(document); //save to db
            String uploadDir = "uploads/" + savedDocument.getId();

            FileUploadUtil.saveFile(uploadDir, formK1fileName, multipartFile1);
            FileUploadUtil.saveFile(uploadDir, formK2fileName, multipartFile3);
            FileUploadUtil.saveFile(uploadDir, ktpKonsumen, multipartFile4);
            FileUploadUtil.saveFile(uploadDir, ktpPengaju, multipartFile5);
            FileUploadUtil.saveFile(uploadDir, kk, multipartFile6);
            FileUploadUtil.saveFile(uploadDir, resumeMedis, multipartFile7);
            FileUploadUtil.saveFile(uploadDir, sertifikatCP, multipartFile9);
            FileUploadUtil.saveFile(uploadDir, skTidakKerja, multipartFile10);

        }else if (multipartFile10 == null){
            String formK1fileName = StringUtils.cleanPath(multipartFile1.getOriginalFilename());
            String formK2fileName = StringUtils.cleanPath(multipartFile3.getOriginalFilename());
            String ktpKonsumen = StringUtils.cleanPath(multipartFile4.getOriginalFilename());
            String ktpPengaju = StringUtils.cleanPath(multipartFile5.getOriginalFilename());
            String kk = StringUtils.cleanPath(multipartFile6.getOriginalFilename());
            String resumeMedis = StringUtils.cleanPath(multipartFile7.getOriginalFilename());
            String skPolisi = StringUtils.cleanPath(multipartFile8.getOriginalFilename());
            String sertifikatCP = StringUtils.cleanPath(multipartFile9.getOriginalFilename());

            document.setK1(formK1fileName);
            document.setK2(formK2fileName);
            document.setKtpKonsumen(ktpKonsumen);
            document.setKtpPengaju(ktpPengaju);
            document.setKk(kk);
            document.setResumeMedis(resumeMedis);
            document.setSkPolisi(skPolisi);
            document.setSertifikatCP(sertifikatCP);
            document.setNmPemohon(param1);
            document.setEmail(param2);
            document.setHp(param3);
            document.setAkun(param5);

            Document savedDocument = documentRepo.save(document); //save to db
            String uploadDir = "uploads/" + savedDocument.getId();

            FileUploadUtil.saveFile(uploadDir, formK1fileName, multipartFile1);
            FileUploadUtil.saveFile(uploadDir, formK2fileName, multipartFile3);
            FileUploadUtil.saveFile(uploadDir, ktpKonsumen, multipartFile4);
            FileUploadUtil.saveFile(uploadDir, ktpPengaju, multipartFile5);
            FileUploadUtil.saveFile(uploadDir, kk, multipartFile6);
            FileUploadUtil.saveFile(uploadDir, resumeMedis, multipartFile7);
            FileUploadUtil.saveFile(uploadDir, skPolisi, multipartFile8);
            FileUploadUtil.saveFile(uploadDir, sertifikatCP, multipartFile9);
        }
         else {
            String formK1fileName = StringUtils.cleanPath(multipartFile1.getOriginalFilename());
            String formK2fileName = StringUtils.cleanPath(multipartFile3.getOriginalFilename());
            String ktpKonsumen = StringUtils.cleanPath(multipartFile4.getOriginalFilename());
            String ktpPengaju = StringUtils.cleanPath(multipartFile5.getOriginalFilename());
            String kk = StringUtils.cleanPath(multipartFile6.getOriginalFilename());
            String resumeMedis = StringUtils.cleanPath(multipartFile7.getOriginalFilename());
            String skPolisi = StringUtils.cleanPath(multipartFile8.getOriginalFilename());
            String sertifikatCP = StringUtils.cleanPath(multipartFile9.getOriginalFilename());
            String skTidakKerja = StringUtils.cleanPath(multipartFile10.getOriginalFilename());

            document.setK1(formK1fileName);
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
            document.setAkun(param5);

            Document savedDocument = documentRepo.save(document); //save to db
            String uploadDir = "uploads/" + savedDocument.getId();

            FileUploadUtil.saveFile(uploadDir, formK1fileName, multipartFile1);
            FileUploadUtil.saveFile(uploadDir, formK2fileName, multipartFile3);
            FileUploadUtil.saveFile(uploadDir, ktpKonsumen, multipartFile4);
            FileUploadUtil.saveFile(uploadDir, ktpPengaju, multipartFile5);
            FileUploadUtil.saveFile(uploadDir, kk, multipartFile6);
            FileUploadUtil.saveFile(uploadDir, resumeMedis, multipartFile7);
            FileUploadUtil.saveFile(uploadDir, skPolisi, multipartFile8);
            FileUploadUtil.saveFile(uploadDir, sertifikatCP, multipartFile9);
            FileUploadUtil.saveFile(uploadDir, skTidakKerja, multipartFile10);

        }

        return new ResponseHandler().generateResponse(ConstantMessage.SUCCESS_SAVE, HttpStatus.CREATED, null, null, null);

    }

}





