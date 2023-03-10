package com.bcafinace.projectakhir.controller;/*
Created by IntelliJ IDEA 2022.2.3 (Community Edition)
Build #IC-222.4345.14, built on October 5, 2022
@Author Kyoto a.k.a Riky Hidayat
Java Developer
Created on 07/02/2023
@Last Modified 07/02/2023 09:32
Version 1.0
*/

import com.bcafinace.projectakhir.handler.ResourceNotFoundException;
import com.bcafinace.projectakhir.handler.ResponseHandler;
import com.bcafinace.projectakhir.models.Akun;
import com.bcafinace.projectakhir.models.Document;
import com.bcafinace.projectakhir.models.Maskapai;
import com.bcafinace.projectakhir.service.AkunService;
import com.bcafinace.projectakhir.utils.ConstantMessage;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("api/akun")
public class AkunController {

    @Getter
    private AkunService akunService;

//    public AkunController(){}

    @Autowired
    public AkunController(AkunService akunService){this.akunService=akunService;}

    @GetMapping("/validation/{noKontrak}/{noPolis}")
    public ResponseEntity<Object> getValidationAkun(@PathVariable("noKontrak") String noKontrak,
                                                    @PathVariable("noPolis") String noPolis) throws Exception{
        Akun akun = akunService.validationAkun(noKontrak, noPolis);

        if (akun != null) {
            return new ResponseHandler().
                    generateResponse(ConstantMessage.SUCCESS_FIND_BY, HttpStatus.OK, akun, null, null);

        } else {
            throw new ResourceNotFoundException(ConstantMessage.WARNING_NOT_FOUND);
        }
    }

    @PutMapping("/updateStatusPengajuan")
    public ResponseEntity<Object> updateFlag(@RequestBody Akun akun) throws Exception{
        akunService.updateFlagCp(akun);

        return new ResponseHandler().
                generateResponse(ConstantMessage.SUCCESS_FIND_BY, HttpStatus.OK,"",null,null);
    }

    @GetMapping("/getTracking/{noKontrak}")
    public ResponseEntity<Object> getData(@PathVariable("noKontrak")String noKontrak)throws Exception{
        return new ResponseHandler().
                generateResponse(ConstantMessage.SUCCESS_FIND_BY, HttpStatus.OK,akunService.getDataTrack(noKontrak),null,null);
    }

    @PostMapping("/ahliWarisLogin")
    public ResponseEntity<Object>
    loginUser(@Valid @RequestBody Akun akun, @RequestHeader Map<String, String> headers,
                  @RequestParam Map<String,String> params,
                  WebRequest request, Error error) throws Exception{
        if (akun==null) throw new ResourceNotFoundException(ConstantMessage.ERROR_NO_CONTENT);
        return new ResponseHandler().generateResponse(ConstantMessage.SUCCESS_LOGIN, HttpStatus.OK,akunService.userLogin(akun),null,null);
    }

}
