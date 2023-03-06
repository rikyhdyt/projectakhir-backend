package com.bcafinace.projectakhir.controller;/*
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
import com.bcafinace.projectakhir.models.Maskapai;
import com.bcafinace.projectakhir.service.MaskapaiService;
import com.bcafinace.projectakhir.utils.ConstantMessage;
import lombok.Getter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("api/maskapai")
public class MaskapaiController {

    @Getter
    private MaskapaiService maskapaiService;

    public MaskapaiController(){}

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    public MaskapaiController(MaskapaiService maskapaiService){this.maskapaiService=maskapaiService;}

    @GetMapping("/getDataPengajuan/{id}")
    public ResponseEntity<Object> getData(@PathVariable("id")Long id)throws Exception{
        return new ResponseHandler().
                generateResponse(ConstantMessage.SUCCESS_FIND_BY, HttpStatus.OK,maskapaiService.getForMaskapai(id),null,null);
    }

    @PostMapping("/maskapaiLogin")
    public ResponseEntity<Object>
    loginMaskapai(@Valid @RequestBody Maskapai maskapai, @RequestHeader Map<String, String> headers,
                  @RequestParam Map<String,String> params,
                  WebRequest request, Error error) throws Exception{
        if (maskapai==null) throw new ResourceNotFoundException(ConstantMessage.ERROR_NO_CONTENT);
        return new ResponseHandler().generateResponse(ConstantMessage.SUCCESS_LOGIN, HttpStatus.OK,maskapaiService.maskapaiLogin(maskapai),null,null);
    }

}
