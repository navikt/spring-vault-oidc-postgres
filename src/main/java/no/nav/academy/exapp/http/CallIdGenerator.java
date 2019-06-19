package no.nav.academy.exapp.http;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CallIdGenerator {

    public String create() {
        return UUID.randomUUID().toString();
    }
}
