package no.nav.academy.exapp.routes;

import no.nav.academy.exapp.repositories.HelloRepository;
import no.nav.academy.exapp.repositories.dto.JPAHelloMelding;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {

    private final HelloRepository dao;

    public HelloController(HelloRepository dao) {
        this.dao = dao;
    }
    @RequestMapping("/hello")
    String hello() {
        return "Hello World";
    }


    @GetMapping("/message")
    List<JPAHelloMelding> message() {
        List<JPAHelloMelding> all = dao.findAll();
        System.out.println(all.toString());
        return all;
    }
    @PostMapping("/message")
    Boolean insertMessage(){
        JPAHelloMelding s = new JPAHelloMelding();
        s.setMessage("hello");
        dao.saveAndFlush(s);
        return true;
    }
}
