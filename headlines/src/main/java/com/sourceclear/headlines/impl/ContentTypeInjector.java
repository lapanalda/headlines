package com.sourceclear.headlines.impl;

import com.sourceclear.headlines.AbstractHeaderLinesInjector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public final class ContentTypeInjector extends AbstractHeaderLinesInjector<ContentTypeConfig> {

    ///////////////////////////// Class Attributes \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    ////////////////////////////// Class Methods \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    //////////////////////////////// Attributes \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    /////////////////////////////// Constructors \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    public ContentTypeInjector() {
        setConfig(new ContentTypeConfig());
    }

    ////////////////////////////////// Methods \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    //------------------------ Implements: HttpInjector

    public void inject(HttpServletRequest request, HttpServletResponse response) {
        ContentTypeConfig config = getConfig();

        if (config.isEnabled() && config.getCharset() != null) {
            String headerValue = String.format("%s; charset=%s",config.getType(), config.getCharset());
            response.setHeader("Content-Type", headerValue);
        }
    }

    //------------------------ Overrides:

    //---------------------------- Abstract Methods -----------------------------

    //---------------------------- Utility Methods ------------------------------

    //---------------------------- Property Methods -----------------------------
}
