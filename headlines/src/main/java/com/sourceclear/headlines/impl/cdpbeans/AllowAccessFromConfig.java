package com.sourceclear.headlines.impl.cdpbeans;

import com.google.common.collect.ImmutableList;
import com.google.gson.annotations.SerializedName;

import javax.annotation.concurrent.Immutable;

/**
 * allow-access-from grants a requesting domain access to read data from the target domain. For
 * each requesting that is given permission, a new allow-access-from element is required, although
 * multiple domains can be given access with one allow-access-from element by using a wildcard (*).
 * (from Cross-domain Policy File Specification)
 */
@Immutable
public final class AllowAccessFromConfig {

    ///////////////////////////// Class Attributes \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    public static final String HEADER_NAME = "allow-access-from";

    ////////////////////////////// Class Methods \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    //////////////////////////////// Attributes \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    private volatile ImmutableList<String> domain;

    @SerializedName("to-ports")
    private volatile ImmutableList<String> toPorts;

    private volatile boolean secure = true;

    private volatile boolean enabled = true;

    /////////////////////////////// Constructors \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    public AllowAccessFromConfig() {

    }

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
     * @return A comma-separated list of ports or range of ports that a socket connection
     * is allowed to connect to. A range of ports is specified through a dash (-) between two port numbers.
     * Ranges can be used with individual ports when separated with a comma. A single wildcard (*) can
     * be used to allow all ports
     */
    public ImmutableList<String> getToPorts() {
        return toPorts;
    }

    public void setToPorts(ImmutableList<String> toPorts) {
        this.toPorts = toPorts;
    }

    /**
     * @return whether access is granted only to HTTPS
     * documents from the specified origin (true) or to all documents from the specified origin (false)
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
