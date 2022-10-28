package com.kawahedukasi.batch4.repository;

import com.kawahedukasi.batch4.model.Peserta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PesertaRepository extends JpaRepository<Peserta, Long> {

    Optional<Peserta> findByName(String name);
    Optional<Peserta> findByEmail(String email);
    Optional<Peserta> findByPhoneNumber(String phoneNumber);

    @Query(nativeQuery = true, value = "SELECT * FROM batch_4_spring.peserta WHERE phone_number = ?1 OR email = ?2")
    List<Peserta> findByPhoneNumberOrEmail(String phoneNumber, String email);

}
