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
import com.bcafinace.projectakhir.service.AkunService;
import com.bcafinace.projectakhir.utils.ConstantMessage;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/")
public class AkunController {

    @Getter
    private AkunService akunService;

//    public AkunController(){}

    @Autowired
    public AkunController(AkunService akunService){this.akunService=akunService;}

    @GetMapping("akun/validation/{noKontrak}/{noPolis}")
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

}
