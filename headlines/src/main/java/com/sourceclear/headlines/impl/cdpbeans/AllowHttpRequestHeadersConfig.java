package com.sourceclear.headlines.impl.cdpbeans;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

import javax.annotation.concurrent.Immutable;

@Immutable
public final class AllowHttpRequestHeadersConfig {

    ///////////////////////////// Class Attributes \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    public static final String HEADER_NAME = "allow-http-request-headers-from";

    ////////////////////////////// Class Methods \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    //////////////////////////////// Attributes \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    private volatile ImmutableMap<String,ImmutableList<String>> domains;

    private volatile ImmutableMap<String,ImmutableList<String>> headers;

    private volatile boolean secure;

    /////////////////////////////// Constructors \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    public AllowHttpRequestHeadersConfig() {

    }

    public AllowHttpRequestHeadersConfig(ImmutableMap<String, ImmutableList<String>> domains, ImmutableMap<String, ImmutableList<String>> headers) {
        this.domains = domains;
        this.headers = headers;
    }

    public AllowHttpRequestHeadersConfig(ImmutableMap<String, ImmutableList<String>> domains, ImmutableMap<String, ImmutableList<String>> headers, boolean secure) {
        this.domains = domains;
        this.headers = headers;
        this.secure = secure;
    }

    ////////////////////////////////// Methods \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    //------------------------ Implements:

    //------------------------ Overrides:

    //---------------------------- Abstract Methods -----------------------------

    //---------------------------- Utility Methods ------------------------------

    //---------------------------- Property Methods -----------------------------

    public ImmutableMap<String, ImmutableList<String>> getDomains() {
        return domains;
    }

    public ImmutableMap<String, ImmutableList<String>> getHeaders() {
        return headers;
    }

    public boolean isSecure() {
        return secure;
    }
}
