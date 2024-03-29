package no.nav.academy.exapp.config;

import no.nav.academy.exapp.util.EnvUtil;
import no.nav.security.oidc.context.OIDCRequestContextHolder;
import no.nav.security.oidc.context.OIDCValidationContext;
import no.nav.security.spring.oidc.SpringOIDCRequestContextHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.client.RestOperations;

import java.util.Arrays;

@Configuration
public class RestClientConfig {
    private static final Logger LOG = LoggerFactory.getLogger(RestClientConfig.class);

    @Bean
    @Primary
    public RestOperations restTemplate(RestTemplateBuilder builder, ClientHttpRequestInterceptor... interceptors) {
        LOG.info("Registrerer interceptorer {}", Arrays.toString(interceptors));
        return builder
                .interceptors(interceptors)
                .build();
    }

    @Bean
    @Profile(EnvUtil.DEV)
    @ConditionalOnMissingBean(SpringOIDCRequestContextHolder.class)
    OIDCRequestContextHolder dummyContextHolderForDev() {
        return new OIDCRequestContextHolder() {

            @Override
            public void setRequestAttribute(String name, Object value) {

            }

            @Override
            public Object getRequestAttribute(String name) {
                return null;
            }

            @Override
            public OIDCValidationContext getOIDCValidationContext() {
                return null;
            }

            @Override
            public void setOIDCValidationContext(OIDCValidationContext oidcValidationContext) {

            }
        };
    }

}
