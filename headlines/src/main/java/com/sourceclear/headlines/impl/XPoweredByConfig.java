package com.sourceclear.headlines.impl;

import com.google.gson.annotations.SerializedName;

import javax.annotation.concurrent.Immutable;

@Immutable
public final class XPoweredByConfig {

    ///////////////////////////// Class Attributes \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    ////////////////////////////// Class Methods \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    //////////////////////////////// Attributes \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    private volatile boolean enabled = true;

    @SerializedName("x-powered-by")
    private volatile String xPoweredBy;

    /////////////////////////////// Constructors \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    ////////////////////////////////// Methods \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    //------------------------ Implements: HttpInjectorConfig

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

    public String getXPoweredBy() {
        return xPoweredBy;
    }

    public void setXPoweredBy(String xPoweredBy) {
        this.xPoweredBy = xPoweredBy;
    }
}
