package com.sourceclear.headlines.impl;

import com.sourceclear.headlines.AbstractHeaderLinesInjector;
import com.sourceclear.headlines.impl.cdpbeans.AllowAccessFromConfig;
import com.sourceclear.headlines.impl.cdpbeans.AllowAccessFromIdentityConfig;
import com.sourceclear.headlines.impl.cdpbeans.AllowHttpRequestHeadersConfig;
import com.sourceclear.headlines.impl.cdpbeans.SiteControlConfig;
import com.sourceclear.headlines.util.HeaderBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public final class CrossDomainPolicyInjector extends AbstractHeaderLinesInjector<CrossDomainPolicyConfig> {

    public CrossDomainPolicyInjector() {
        setConfig(new CrossDomainPolicyConfig());
    }

    /**
     * Creating header "Cross-Domain-Policy" for server response
     *
     * @param request
     * @param response
     */
    public void inject(HttpServletRequest request, HttpServletResponse response) {
        CrossDomainPolicyConfig config = getConfig();

        if (config.isEnabled()) {
            String value = "";

            // Setting site-control attribute if it enable
            SiteControlConfig siteControlConfig = config.getSiteControl();
            if (siteControlConfig != null && siteControlConfig.isEnabled() && !siteControlConfig.getPermittedCrossDomainPolicies().isEmpty()) {
                value = String.format("%s permitted-cross-domain-policies=%s;", SiteControlConfig.HEADER_NAME,
                        HeaderBuilder.formatListAttributeValues(siteControlConfig.getPermittedCrossDomainPolicies())).trim();
            }

            // Setting allow-access-from attribute if it enable
            AllowAccessFromConfig accessDomainsConfig = config.getAllowAccessFrom();
            if (accessDomainsConfig != null && accessDomainsConfig.isEnabled() && !accessDomainsConfig.getDomain().isEmpty()) {
                String domain = HeaderBuilder.formatListAttributeValues(accessDomainsConfig.getDomain());
                value = String.format("%s %s domain=%s", value, AllowAccessFromConfig.HEADER_NAME, domain);
                if (accessDomainsConfig.getToPorts() != null && !accessDomainsConfig.getToPorts().isEmpty()) {
                    String toPorts = HeaderBuilder.formatListAttributeValues(accessDomainsConfig.getToPorts());
                    value = String.format("%s to-ports=%s", value, toPorts);
                }
                value = String.format("%s secure=%s;", value, accessDomainsConfig.isSecure());
            }

            //Setting allow-access-from-identity if if enable
            AllowAccessFromIdentityConfig allowAccessFromIdentity = config.getAccessFromIdentity();
            if (allowAccessFromIdentity != null && allowAccessFromIdentity.isEnabled() && allowAccessFromIdentity.getFingerprintAlgorithm() != null) {
                value = String.format("%s %s fingerprint-algorithm='%s'", value, AllowAccessFromIdentityConfig.HEADER_NAME, allowAccessFromIdentity.getFingerprintAlgorithm());
                if (allowAccessFromIdentity.getFingerprint() != null) {
                    value = String.format("%s fingerprint='%s';", value, allowAccessFromIdentity.getFingerprint());
                } else {
                    value = String.format("%s;", value);
                }
            }

            //Setting allow-http-request-headers attribute if it enable
            AllowHttpRequestHeadersConfig accessHttpConfig = config.getAllowHttpRequestHeadersFrom();
            if (accessHttpConfig != null && accessHttpConfig.isEnabled() && !accessHttpConfig.getDomain().isEmpty()) {
                value = String.format("%s %s domain=%s", value, AllowHttpRequestHeadersConfig.HEADER_NAME, HeaderBuilder.formatListAttributeValues(accessHttpConfig.getDomain()));
                if (accessHttpConfig.getHeaders()!= null && !accessHttpConfig.getHeaders().isEmpty()) {
                    value = String.format("%s headers=%s", value, HeaderBuilder.formatListAttributeValues(accessHttpConfig.getHeaders())).trim();
                }
                value = String.format("%s secure=%s", value, accessHttpConfig.isSecure());
            }

            // Setting created header to response
            if (!value.isEmpty()) {
                response.setHeader("Cross-Domain-Policy", value);
            }
        }
    }
}
