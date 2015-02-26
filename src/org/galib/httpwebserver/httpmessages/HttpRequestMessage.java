package org.galib.httpwebserver.httpmessages;

import org.galib.httpwebserver.httpmessages.HttpMessage;

/**
 * Created by bakhtiar.galib on 2/24/15.
 */
public class HttpRequestMessage extends HttpMessage {

    private String method;
    private String url;
    private String host;
    private String userAgent;
    private String acceptLanguage;

    private String contentType;
    private int contentLength;
    private String contentBody;


    public HttpRequestMessage() {
    }

    public HttpRequestMessage(String method, String url, String host, String httpProtocolVersion,
                              String connection, String userAgent, String acceptLanguage) {
        this.method = method;
        this.url = url;
        this.host = host;
        this.httpProtocolVersion = httpProtocolVersion;
        this.connection = connection;
        this.userAgent = userAgent;
        this.acceptLanguage = acceptLanguage;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public String getAcceptLanguage() {
        return acceptLanguage;
    }

    public void setAcceptLanguage(String acceptLanguage) {
        this.acceptLanguage = acceptLanguage;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public int getContentLength() {
        return contentLength;
    }

    public void setContentLength(int contentLength) {
        this.contentLength = contentLength;
    }

    public String getContentBody() {
        return contentBody;
    }

    public void setContentBody(String contentBody) {
        this.contentBody = contentBody;
    }


    @Override
    public String toString() {
        return   method +" "+url+" "+httpProtocolVersion+ "\r\n"
                 +"Host: "+host+"\r\n"
                 +"Connection: "+connection+"\r\n"
                 +"User-agent: "+userAgent+"\r\n"
                 +"Accept Language: "+acceptLanguage+"\r\n"
                 +contentBody;

    }
}
