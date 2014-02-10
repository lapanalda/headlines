package com.sourceclear.headlines.impl.cdpbeans;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

import javax.annotation.concurrent.Immutable;

@Immutable
public final class AllowAccessFromConfig {

    ///////////////////////////// Class Attributes \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    public static final String HEADER_NAME = "allow-access-from";

    ////////////////////////////// Class Methods \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    //////////////////////////////// Attributes \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    private volatile ImmutableMap<String,ImmutableList<String>> domains;

    private volatile boolean secure;

    /////////////////////////////// Constructors \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    public AllowAccessFromConfig() {

    }

    public AllowAccessFromConfig(ImmutableMap<String, ImmutableList<String>> domains) {
        this.domains = domains;
    }

    public AllowAccessFromConfig(ImmutableMap<String, ImmutableList<String>> domains, boolean secure) {
        this.domains = domains;
        this.secure = secure;
    }

    ////////////////////////////////// Methods \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    //------------------------ Implements:

    //------------------------ Overrides:

    //---------------------------- Abstract Methods -----------------------------

    //---------------------------- Utility Methods ------------------------------

    //---------------------------- Property Methods -----------------------------

    public boolean isSecure() {
        return secure;
    }

    public ImmutableMap<String, ImmutableList<String>> getDomains() {
        return domains;
    }
}
