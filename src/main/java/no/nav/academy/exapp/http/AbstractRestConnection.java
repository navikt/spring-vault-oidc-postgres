package no.nav.academy.exapp.http;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestOperations;

import java.net.URI;

import static no.nav.academy.exapp.util.EnvUtil.CONFIDENTIAL;
import static org.springframework.http.HttpStatus.NOT_FOUND;

public abstract class AbstractRestConnection {
    private static final String RESPONS = "Respons: {}";
    private static final Logger LOG = LoggerFactory.getLogger(AbstractRestConnection.class);
    private final RestOperations restOperations;

    public AbstractRestConnection(RestOperations restOperations) {
        this.restOperations = restOperations;
    }

    protected String ping(URI uri) {
        return getForObject(uri, String.class);
    }

    protected <T> ResponseEntity<T> postForEntity(URI uri, HttpEntity<?> payload, Class<T> responseType) {
        ResponseEntity<T> respons = restOperations.postForEntity(uri, payload, responseType);
        if (respons.hasBody()) {
            LOG.trace(CONFIDENTIAL, RESPONS, respons.getBody());
        }
        return respons;
    }

    protected <T> T getForObject(URI uri, Class<T> responseType) {
        return getForObject(uri, responseType, false);
    }

    protected <T> T getForObject(URI uri, Class<T> responseType, boolean doThrow) {
        try {
            T respons = restOperations.getForObject(uri, responseType);
            if (respons != null) {
                LOG.trace(CONFIDENTIAL, RESPONS, respons);
            }
            return respons;
        } catch (HttpClientErrorException e) {
            if (NOT_FOUND.equals(e.getStatusCode()) && !doThrow) {
                LOG.info("Fant intet objekt, returnerer null");
                return null;
            }
            throw e;
        }
    }

    protected <T> ResponseEntity<T> getForEntity(URI uri, Class<T> responseType) {
        return getForEntity(uri, responseType, true);
    }

    protected <T> ResponseEntity<T> getForEntity(URI uri, Class<T> responseType, boolean doThrow) {
        try {
            ResponseEntity<T> respons = restOperations.getForEntity(uri, responseType);
            if (respons.hasBody()) {
                LOG.trace(CONFIDENTIAL, RESPONS, respons.getBody());
            }
            return respons;
        } catch (HttpClientErrorException e) {
            if (NOT_FOUND.equals(e.getStatusCode()) && !doThrow) {
                LOG.info("Fant ingen entity, returnerer null");
                return null;
            }
            throw e;
        }
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " [restOperations=" + restOperations + "]";
    }
}
