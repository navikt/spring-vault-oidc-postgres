package no.nav.academy.exapp.http;

import java.net.URI;

public interface PingEndpointAware extends Pingable {

    URI pingEndpoint();

    String name();
}
