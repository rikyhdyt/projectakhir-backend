package com.bcafinace.projectakhir.repos;/*
Created by IntelliJ IDEA 2022.2.3 (Community Edition)
Build #IC-222.4345.14, built on October 5, 2022
@Author Kyoto a.k.a Riky Hidayat
Java Developer
Created on 20/01/2023
@Last Modified 20/01/2023 09:52
Version 1.0
*/

import com.bcafinace.projectakhir.models.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface DocumentRepo extends JpaRepository<Document, Long> {

    List<Document>findByIsProgress(String isProgress);

    @Query(value = "SELECT * FROM TbDocument WHERE IsProgress = '2' OR IsProgress ='2b' OR IsProgress='1b'", nativeQuery = true)
    @Modifying
    List<Document> getProgressForAdmin();

    @Query(value = "SELECT * FROM TbDocument WHERE IsProgress = '3' OR IsProgress ='4' ", nativeQuery = true)
    @Modifying
    List<Document> getHistoriForAdmin();

    @Override
    Optional<Document> findById(Long id);


}
