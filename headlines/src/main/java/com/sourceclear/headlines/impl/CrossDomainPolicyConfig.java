package com.sourceclear.headlines.impl;

import com.sourceclear.headlines.impl.cdpbeans.AllowAccessFromConfig;
import com.sourceclear.headlines.impl.cdpbeans.AllowAccessFromIdentityConfig;
import com.sourceclear.headlines.impl.cdpbeans.AllowHttpRequestHeadersConfig;
import com.sourceclear.headlines.impl.cdpbeans.SiteControlConfig;

import javax.annotation.concurrent.Immutable;

@Immutable
public final class CrossDomainPolicyConfig {

    ///////////////////////////// Class Attributes \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    ////////////////////////////// Class Methods \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    //////////////////////////////// Attributes \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\


    private volatile SiteControlConfig siteControl;

    private volatile AllowAccessFromConfig allowAccessFrom;

    private volatile AllowAccessFromIdentityConfig accessFromIdentity;

    private volatile AllowHttpRequestHeadersConfig allowHttpRequestHeadersFrom;

    private volatile boolean enabled = true;

    /////////////////////////////// Constructors \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    ////////////////////////////////// Methods \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    //------------------------ Implements

    //------------------------ Overrides:

    //---------------------------- Abstract Methods -----------------------------

    //---------------------------- Utility Methods ------------------------------

    //---------------------------- Property Methods -----------------------------


    public SiteControlConfig getSiteControl() {
        return siteControl;
    }

    public void setSiteControl(SiteControlConfig siteControl) {
        this.siteControl = siteControl;
    }

    public AllowAccessFromConfig getAllowAccessFrom() {
        return allowAccessFrom;
    }

    public void setAllowAccessFrom(AllowAccessFromConfig allowAccessFrom) {
        this.allowAccessFrom = allowAccessFrom;
    }

    public AllowAccessFromIdentityConfig getAccessFromIdentity() {
        return accessFromIdentity;
    }

    public void setAccessFromIdentity(AllowAccessFromIdentityConfig accessFromIdentity) {
        this.accessFromIdentity = accessFromIdentity;
    }

    public AllowHttpRequestHeadersConfig getAllowHttpRequestHeadersFrom() {
        return allowHttpRequestHeadersFrom;
    }

    public void setAllowHttpRequestHeadersFrom(AllowHttpRequestHeadersConfig allowHttpRequestHeadersFrom) {
        this.allowHttpRequestHeadersFrom = allowHttpRequestHeadersFrom;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
