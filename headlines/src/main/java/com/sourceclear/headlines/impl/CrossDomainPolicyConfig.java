package com.sourceclear.headlines.impl;

import com.sourceclear.headlines.impl.cdpbeans.AllowAccessFromConfig;
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

    private volatile AllowHttpRequestHeadersConfig allowHttpRequestHeadersFrom;

    private volatile boolean enabled = true;

    /////////////////////////////// Constructors \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    /**
     * Create a default CrossDomainPolicyConfig (meta domain policy) instance. This instance has different parameters: site-control, allow-access-from, allow-http-request-headers-from.
     */

    public CrossDomainPolicyConfig() {
        this(new SiteControlConfig(), new AllowAccessFromConfig(), new AllowHttpRequestHeadersConfig());
    }

    public CrossDomainPolicyConfig(SiteControlConfig siteControl, AllowAccessFromConfig allowAccessFrom, AllowHttpRequestHeadersConfig allowHttpRequestHeadersFrom) {
        this.siteControl = siteControl;
        this.allowAccessFrom = allowAccessFrom;
        this.allowHttpRequestHeadersFrom = allowHttpRequestHeadersFrom;
    }

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
