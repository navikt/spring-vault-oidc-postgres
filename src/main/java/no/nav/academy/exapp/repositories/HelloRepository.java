package no.nav.academy.exapp.repositories;

import no.nav.academy.exapp.repositories.dto.JPAHelloMelding;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface HelloRepository extends JpaRepository<JPAHelloMelding, Long> {


    @Query("select m from JPAHelloMelding m")
    List<JPAHelloMelding> findAllBy();


}
