package com.sourceclear.headlines.impl.cdpbeans;

import com.google.common.collect.ImmutableList;
import com.google.gson.annotations.SerializedName;

import javax.annotation.concurrent.Immutable;

/**
 * Defines the meta-policy for the current domain. A meta-policy specifies acceptable
 * domain policy files other than the master policy file located in the target domain's root and named
 * crossdomain.xml.  (from Cross-domain Policy File Specification)
 */
@Immutable
public final class SiteControlConfig {

    ///////////////////////////// Class Attributes \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    public static final String HEADER_NAME = "site-control";

    ////////////////////////////// Class Methods \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    //////////////////////////////// Attributes \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    @SerializedName("permitted-cross-domain-policies")
    private volatile ImmutableList<String> permittedCrossDomainPolicies;

    private volatile boolean enabled = true;

    /////////////////////////////// Constructors \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\


    ////////////////////////////////// Methods \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    //------------------------ Implements:

    //------------------------ Overrides:

    //---------------------------- Abstract Methods -----------------------------

    //---------------------------- Utility Methods ------------------------------

    //---------------------------- Property Methods -----------------------------

    /**
     *
     * @return specified the meta-policy
     */
    public ImmutableList<String> getPermittedCrossDomainPolicies() {
        return permittedCrossDomainPolicies;
    }

    public void setPermittedCrossDomainPolicies(ImmutableList<String> permittedCrossDomainPolicies) {
        this.permittedCrossDomainPolicies = permittedCrossDomainPolicies;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

}
