package no.nav.academy.exapp.repositories;

import no.nav.academy.exapp.model.JPAHelloMessageDTO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface HelloRepository extends JpaRepository<JPAHelloMessageDTO, Long> {


    @Query("select m from JPAHelloMessageDTO m")
    List<JPAHelloMessageDTO> findAllBy();


}
