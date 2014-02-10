package com.sourceclear.headlines.impl.cdpbeans;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

import javax.annotation.concurrent.Immutable;

@Immutable
public final class SiteControlConfig {

    ///////////////////////////// Class Attributes \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    public static final String HEADER_NAME = "site-control";

    ////////////////////////////// Class Methods \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    //////////////////////////////// Attributes \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    private volatile ImmutableMap<String,ImmutableList<String>> permittedPolicies;

    private volatile boolean enabled = true;

    /////////////////////////////// Constructors \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    public SiteControlConfig() {
       this(ImmutableMap.of("permitted-cross-domain-policies", ImmutableList.of("'master-only'")));
    }

    public SiteControlConfig(ImmutableMap<String, ImmutableList<String>> permittedPolicies) {
        this.permittedPolicies = permittedPolicies;
    }

    ////////////////////////////////// Methods \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    //------------------------ Implements:

    //------------------------ Overrides:

    //---------------------------- Abstract Methods -----------------------------

    //---------------------------- Utility Methods ------------------------------

    //---------------------------- Property Methods -----------------------------

    public ImmutableMap<String, ImmutableList<String>> getPermittedPolicies() {
        return permittedPolicies;
    }

    public boolean isEnabled() {
        return enabled;
    }
}
