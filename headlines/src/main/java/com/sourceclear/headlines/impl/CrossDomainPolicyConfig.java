package com.sourceclear.headlines.impl;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
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

    public CrossDomainPolicyConfig(SiteControlConfig siteControl) {
        this.siteControl = siteControl;
    }

    public CrossDomainPolicyConfig(AllowAccessFromConfig allowAccessFrom) {
        this.allowAccessFrom = allowAccessFrom;
    }

    public CrossDomainPolicyConfig(AllowHttpRequestHeadersConfig allowHttpRequestHeadersFrom) {
        this.allowHttpRequestHeadersFrom = allowHttpRequestHeadersFrom;
    }

    /**
     * Create a default CrossDomainPolicyConfig (meta domain policy) instance. This instance has different parameters: site-control, allow-access-from, allow-http-request-headers-from.
     */


    public CrossDomainPolicyConfig() {
        this(new SiteControlConfig(),
                new AllowAccessFromConfig(ImmutableMap.of("domain", ImmutableList.of("'*'")), false),
                new AllowHttpRequestHeadersConfig(ImmutableMap.of("domain", ImmutableList.of("'*'")), ImmutableMap.of("headers", ImmutableList.of("'*'")), false));
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

    public boolean isEnabled() {
        return enabled;
    }

    public SiteControlConfig getSiteControl() {
        return siteControl;
    }

    public AllowAccessFromConfig getAllowAccessFrom() {
        return allowAccessFrom;
    }

    public AllowHttpRequestHeadersConfig getAllowHttpRequestHeadersConfig() {
        return allowHttpRequestHeadersFrom;
    }

}
