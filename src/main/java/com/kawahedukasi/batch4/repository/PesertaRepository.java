package com.kawahedukasi.batch4.repository;

import com.kawahedukasi.batch4.model.Peserta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PesertaRepository extends JpaRepository<Peserta, Long> {
}
