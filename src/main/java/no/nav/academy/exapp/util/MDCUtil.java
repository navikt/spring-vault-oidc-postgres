package no.nav.academy.exapp.util;

import no.nav.academy.exapp.http.CallIdGenerator;
import org.slf4j.MDC;

import java.util.Optional;

import static no.nav.academy.exapp.config.Constants.NAV_CALL_ID;

public final class MDCUtil {

    private static final CallIdGenerator GEN = new CallIdGenerator();

    private MDCUtil() {
    }

    public static String callId() {
        return MDC.get(NAV_CALL_ID);
    }

    public static String callIdOrNew() {
        return Optional.ofNullable(callId()).orElse(GEN.create());
    }

    public static void toMDC(String key, Object value) {
        if (value != null) {
            toMDC(key, value.toString());
        }
    }

    public static void toMDC(String key, String value) {
        toMDC(key, value, null);
    }

    public static void toMDC(String key, String value, String defaultValue) {
        MDC.put(key, Optional.ofNullable(value)
                .orElse(defaultValue));
    }
}
