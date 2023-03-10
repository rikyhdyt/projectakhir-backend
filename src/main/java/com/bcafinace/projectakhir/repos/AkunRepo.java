package com.bcafinace.projectakhir.repos;/*
Created by IntelliJ IDEA 2022.2.3 (Community Edition)
Build #IC-222.4345.14, built on October 5, 2022
@Author Kyoto a.k.a Riky Hidayat
Java Developer
Created on 07/02/2023
@Last Modified 07/02/2023 09:07
Version 1.0
*/

import com.bcafinace.projectakhir.models.Akun;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AkunRepo extends JpaRepository<Akun, Long> {

    Optional<Akun> findByNoKontrakAndNoPolis(String noKontrak, String noPolis);

    Optional<Akun> findByNoKontrak(String noKontrak);

}
