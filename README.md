## SourceClear - HeadLines
### A collection of security related response headers designed to help increase security for servlet based apps.
===

##Overview
Our HeadLines project is a Java project inspired by Twitter's [SecureHeaders](https://github.com/twitter/secureheaders).  We have a Java implementation which provides similar functionality to Twitter's Ruby implementation.  While never a guarantee of security, using these headers in your web based applications can help reduce the attack surface area exposed by your app.  

##Functionality
Here's what our HeadLines implementation covers:

###1) [HTTP Strict Transport Security (HSTS)](https://tools.ietf.org/html/rfc6797)
###2) [X-Frame-Options](https://tools.ietf.org/html/draft-ietf-websec-x-frame-options-00)
###3) [Microsoft's XSS Filter](http://msdn.microsoft.com/en-us/library/dd565647.aspx)
###4) [X-Content-Type Options](http://msdn.microsoft.com/en-us/library/ie/gg622941.aspx)
###5) [CSP - Content Security Policy](https://developer.mozilla.org/en-US/docs/Security/CSP)
###6) [HttpOnly Cookies*](https://www.owasp.org/index.php/HttpOnly)
###7) [Secure Cookies*](https://www.owasp.org/index.php/SecureFlag)
###8) [Cache-Control](https://www.w3.org/Protocols/rfc2616/rfc2616-sec14.html#sec14.9)
###9) [Access Control Allow Origin](http://en.wikipedia.org/wiki/Cross-origin_resource_sharing)
###10) [Cross Domain Meta Policy](http://www.adobe.com/devnet/articles/crossdomain_policy_file_spec.html)
###11) [Server Information](https://securityheaders.com/server-information.php)
###12) [X-Powered-By](https://securityheaders.com/x-powered-by.php)
###13) [Content-Type](http://www.w3.org/International/O-charset)

* Servlet 3.0 required.

Most of the functionality is simple to configure.  CSP is the exception, and it may take a period of trial and error to pin down the most secure config that doesn't restrict allowable usage.

### Installation
See the [Wiki](https://github.com/sourceclear/headlines/wiki) for installation details

### Set up a config file (optional).
Without a config file, HeadLines will use a set of restricted default options.  If you want some of the features turned off or wish to fine tune
others you'll want a config file.  Here is a complete config which uses the default settings:

```json

{
  "XContentTypeConfig": {
    "enabled": true
  },
  
  "XFrameOptionsConfig": {
    "enabled": true,
    "value":"DENY"
  },

  "XssProtectionConfig": {
    "enabled": true
  },

  "HstsConfig": {
    "enabled": true,
    "includeSubdomains":true,
    "maxAge":31536000
  },

  "CspConfig": {
    "csp": {
      "default-src":["'self'"]
    },
    "cspReportOnly":{}
  },
  
  "CacheControlConfig": {
    "enabled": true,
    "value": "no-cache"
  },

  "AcaoConfig": {
    "origin": "http://localhost http://google.com.ua"
   },

  "CrossDomainPolicyConfig": {
    "enabled": true,
    "siteControl": {
      "permitted-cross-domain-policies": ["master-only"]
    },
    "allowAccessFrom": {
      "domain": ["*"],
      "to-ports": ["8080", "9000"],
      "secure": false
    },
    "accessFromIdentity": {
      "fingerprint-algorithm": "sha-1",
      "fingerprint": "0DFA8998CEA9E8940DE984569DF49343EBB9FD4A"
    },
    "allowHttpRequestHeadersFrom": {
      "domain": ["*"],
      "headers": ["*"],
      "secure": true
    }
  },

  "ServerInformationConfig": {
    "server": "nginx/1.2.1"
  },

  "XPoweredByConfig": {
    "x-powered-by": "PHP/5.2.13"
  },

  "ContentTypeConfig": {
    "type": "text/html",
    "charset": "UTF-16"
  }
}
```

This file should be saved into WEB-INF/headlines.conf.

Most of the options should be self-explanatory.  The hstsConfig->maxAge option is the length in seconds the HSTS directive should be followed.  The spec
recommends a length of 1 to 2 years.  The defualt is 1 year.  The 'proxyHeader' is currently used only by HSTS.  When behind a reverse proxy which handles SSL,
the proxy server will often add this header on the request to inform the app server whether HTTP or HTTPS was used.  While 'X-Forwarded-Proto' is the
defacto-standard (AWS's elastic load balancer does this by default, for example), you can change this is if needed.  `Cache-Control` can be set to any
acceptable value; when the default of `no-cache` is used, `Pragma: NO-CACHE` is also set for HTTP 1.0 compatibility.

####For CSP
CSP has the bulk of the configuration options.  The following example shows permitted CSP fields:

```json	

  "CspConfig": {
      "default-src":["'none'"],
      "script-src":["'self'"],
      "style-src":["'self'", "fonts.googleapis.com"],
      "img-src":["'self'"],
      "media-src":["'none'"],
      "frame-src":["'none'"],
      "font-src":["themes.googleusercontent.com"],
      "connect-src":["'none'"],
      "report-uri": ["/report/violation"]
  }
```

Each of the source types are defined in the [CSP RFC](http://www.w3.org/TR/2012/CR-CSP-20121115/).  In the above example, media, frames, and connect sources are outlawed
altogether.  Scripts and images may be loaded only from the same host as the loaded page, while CSS and fonts may be loaded from Google (although CSS can also be loaded
from the source host as well).

The report-uri declaration dictates that when the browser determines a loading violation was attempted, it should report this to the url located at /report/violation on
the host server.  This is optional and can often show attack attempts or overly-restricted rules.  Analyzing the report-uri violations is beyond the scope of this project.

## Feedback
Feedback on the HeadLines project can be directed to opensource@sourceclear.com.
