package com.sourceclear.headlines.impl.cdpbeans;

import com.google.common.collect.ImmutableList;

import javax.annotation.concurrent.Immutable;

/**
 * allow-http-request-headers-from grants a requesting document from a requesting
 * domain to send user-defined headers to the target domain. This tag grants permission to push data
 * in the form of headers. (from Cross-domain Policy File Specification)
 */
@Immutable
public final class AllowHttpRequestHeadersConfig {

    ///////////////////////////// Class Attributes \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    public static final String HEADER_NAME = "allow-http-request-headers-from";

    ////////////////////////////// Class Methods \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    //////////////////////////////// Attributes \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    private volatile ImmutableList<String> domain;

    private volatile ImmutableList<String> headers;

    private volatile boolean secure = true;

    private volatile boolean enabled = true;

    /////////////////////////////// Constructors \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\


    ////////////////////////////////// Methods \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    //------------------------ Implements:

    //------------------------ Overrides:

    //---------------------------- Abstract Methods -----------------------------

    //---------------------------- Utility Methods ------------------------------

    //---------------------------- Property Methods -----------------------------

    /**
     * @return requesting domain to be granted access
     */
    public ImmutableList<String> getDomain() {
        return domain;
    }

    public void setDomain(ImmutableList<String> domain) {
        this.domain = domain;
    }

    /**
     * @return a comma-separated list of headers that the allowed requesting domain is permitted to send.
     */
    public ImmutableList<String> getHeaders() {
        return headers;
    }

    public void setHeaders(ImmutableList<String> headers) {
        this.headers = headers;
    }

    /**
     * @return false if allows an HTTPS policy file to grant access to a request
     * coming from an HTTP source. The default is true, providing only HTTPS sources permission.
     */
    public boolean isSecure() {
        return secure;
    }

    public void setSecure(boolean secure) {
        this.secure = secure;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
