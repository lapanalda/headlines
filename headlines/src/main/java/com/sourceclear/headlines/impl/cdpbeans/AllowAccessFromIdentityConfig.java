package com.sourceclear.headlines.impl.cdpbeans;

import com.google.gson.annotations.SerializedName;

import javax.annotation.concurrent.Immutable;

/**
 * allow-access-from-identity grants permissions based on cryptographic credentials. The only mechanism
 * defined thus far is to allow access by any document that has been digitally signed by a given party,
 * where the party is identified by certificate. (from Cross-domain Policy File Specification)
 */
@Immutable
public final class AllowAccessFromIdentityConfig {

    ///////////////////////////// Class Attributes \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    public static final String HEADER_NAME = "allow-access-from-identity";

    ////////////////////////////// Class Methods \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    //////////////////////////////// Attributes \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\


    private volatile boolean enabled = true;

    @SerializedName("fingerprint-algorithm")
    private volatile String fingerprintAlgorithm;

    private volatile String fingerprint;

    /////////////////////////////// Constructors \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\


    ////////////////////////////////// Methods \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    //------------------------ Implements:

    //------------------------ Overrides:

    //---------------------------- Abstract Methods -----------------------------

    //---------------------------- Utility Methods ------------------------------

    //---------------------------- Property Methods -----------------------------


    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    /**
     * @return hash algorithm used to compute the certificate fingerprint.
     */
    public String getFingerprintAlgorithm() {
        return fingerprintAlgorithm;
    }

    public void setFingerprintAlgorithm(String fingerprintAlgorithm) {
        this.fingerprintAlgorithm = fingerprintAlgorithm;
    }

    /**
     * @return fingerprint of the signing certificate, expressed as a string of hexadecimal digits
     */
    public String getFingerprint() {
        return fingerprint;
    }

    public void setFingerprint(String fingerprint) {
        this.fingerprint = fingerprint;
    }
}
