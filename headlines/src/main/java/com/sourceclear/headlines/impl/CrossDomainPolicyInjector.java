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
     */
    public void inject(HttpServletRequest request, HttpServletResponse response) {
        CrossDomainPolicyConfig config = getConfig();

        if (config.isEnabled()) {
            String value = "";

            SiteControlConfig siteControlConfig = config.getSiteControl();
            if (siteControlConfig != null && siteControlConfig.isEnabled() && !siteControlConfig.getPermittedCrossDomainPolicies().isEmpty()) {
                value = String.format("%s permitted-cross-domain-policies=%s;", SiteControlConfig.HEADER_NAME,
                        HeaderBuilder.formatListAttributeValues(siteControlConfig.getPermittedCrossDomainPolicies())).trim();
            }

            String allowAccessHeader = getAllowAccessFromHeader(config.getAllowAccessFrom());
            if (allowAccessHeader != null) {
                value = String.format("%s %s", value, allowAccessHeader);
            }

            String allowAccessFromIdentityHeader = getAllowAccessFromIdentityHeader(config.getAccessFromIdentity());
            if (allowAccessFromIdentityHeader != null) {
                value = String.format("%s %s", value, allowAccessFromIdentityHeader);
            }

            String allowHttpRequestHeader = getAccessHttpRequestHeader(config.getAllowHttpRequestHeadersFrom());
            if (allowHttpRequestHeader != null) {
                value = String.format("%s %s", value, allowHttpRequestHeader);
            }

            // Setting created header to response
            if (!value.isEmpty()) {
                response.setHeader("Cross-Domain-Policy", value.trim());
            }
        }
    }

    /**
     * @param config - object with allow-access-from attributes
     * @return string with ordered attributes of header.
     */
    private String getAllowAccessFromHeader(AllowAccessFromConfig config) {
        String value = null;
        if (config != null && config.isEnabled()) {
            if (config.getDomain() != null && !config.getDomain().isEmpty()) {
                String domain = HeaderBuilder.formatListAttributeValues(config.getDomain());
                value = String.format("%s domain=%s", AllowAccessFromConfig.HEADER_NAME, domain);
            }
            if (config.getToPorts() != null && !config.getToPorts().isEmpty()) {
                String toPorts = HeaderBuilder.formatListAttributeValues(config.getToPorts());
                if (value == null) {
                    value = AllowAccessFromConfig.HEADER_NAME;
                }
                value = String.format("%s to-ports=%s", value, toPorts);
            }
            if (value != null) {
                value = String.format("%s secure=%s;", value, config.isSecure());
                return value;
            }
        }
        return null;
    }

    /**
     * @param config - object with allow-http-request-headers attributes
     * @return string with ordered attributes of header.
     */
    private String getAllowAccessFromIdentityHeader(AllowAccessFromIdentityConfig config) {
        String value = null;
        if (config != null && config.isEnabled()) {
            if (config.getFingerprintAlgorithm() != null && !config.getFingerprintAlgorithm().isEmpty()) {
                value = String.format("%s fingerprint-algorithm='%s'", AllowAccessFromIdentityConfig.HEADER_NAME, config.getFingerprintAlgorithm());
            }
            if (config.getFingerprint() != null && !config.getFingerprint().isEmpty()) {
                if (value == null) {
                    value = AllowAccessFromIdentityConfig.HEADER_NAME;
                }
                value = String.format("%s fingerprint='%s'", value, config.getFingerprint());
            }
            if (value != null) {
                value = String.format("%s;", value);
                return value;
            }
        }
        return null;
    }

    /**
     * @param config - object with allow-http-request-headers attributes
     * @return string with ordered attributes of current header
     */
    private String getAccessHttpRequestHeader(AllowHttpRequestHeadersConfig config) {
        String value = null;
        if (config != null && config.isEnabled()) {
            if (config.getDomain() != null && !config.getDomain().isEmpty()) {
                value = String.format("%s domain=%s", AllowHttpRequestHeadersConfig.HEADER_NAME, HeaderBuilder.formatListAttributeValues(config.getDomain()));
            }
            if (config.getHeaders() != null && !config.getHeaders().isEmpty()) {
                if (value == null) {
                    value = AllowHttpRequestHeadersConfig.HEADER_NAME;
                }
                value = String.format("%s headers=%s", value, HeaderBuilder.formatListAttributeValues(config.getHeaders())).trim();
            }
            if (value != null) {
                value = String.format("%s secure=%s", value, config.isSecure());
                return value;
            }
        }
        return null;
    }

}
