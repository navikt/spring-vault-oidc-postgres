package no.nav.academy.exapp.repositories;

import no.nav.academy.exapp.repositories.dto.JPAHelloMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface HelloRepository extends JpaRepository<JPAHelloMessage, Long> {


    @Query("select m from JPAHelloMessage m")
    List<JPAHelloMessage> findAllBy();


}
