package no.nav.academy.exapp.routes;

import no.nav.academy.exapp.repositories.HelloRepository;
import no.nav.academy.exapp.repositories.dto.JPAHelloMessage;
import org.springframework.web.bind.annotation.*;

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


    @GetMapping("/messages")
    List<JPAHelloMessage> getAllMessages() {
        List<JPAHelloMessage> all = dao.findAll();
        System.out.println(all.toString());
        return all;
    }

    @PostMapping("/messages")
    Boolean insertNewMessage(@RequestBody JPAHelloMessage s){
        dao.saveAndFlush(s);
        return true;
    }
}
