package no.nav.academy.exapp.routes;

import no.nav.academy.exapp.repositories.HelloRepository;
import no.nav.academy.exapp.repositories.dto.JPAHelloMessage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {

    private final HelloRepository dao;

    public HelloController(HelloRepository dao) {
        this.dao = dao;
    }

    @GetMapping("/hello")
    String world() {
        return "Hello World";
    }


    @GetMapping("/messages")
    List<JPAHelloMessage> getAllMessages() {
        List<JPAHelloMessage> all = dao.findAll();
        System.out.println(all.toString());
        return all;
    }

    @PostMapping("/messages")
    Boolean insertNewMessage(@RequestBody JPAHelloMessage s) {
        dao.saveAndFlush(s);
        return true;
    }
}
