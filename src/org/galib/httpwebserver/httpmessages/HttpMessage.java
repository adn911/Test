package org.galib.httpwebserver.httpmessages;

/**
 * Created by bakhtiar.galib on 2/24/15.
 */
public class HttpMessage {

    protected String httpProtocolVersion;
    protected String connection;

    public HttpMessage() {
    }

    public HttpMessage(String httpProtocolVersion, String connection) {

        this.httpProtocolVersion = httpProtocolVersion;
        this.connection = connection;
    }

    public String getHttpProtocolVersion() {
        return httpProtocolVersion;
    }

    public void setHttpProtocolVersion(String httpProtocolVersion) {
        this.httpProtocolVersion = httpProtocolVersion;
    }

    public String getConnection() {
        return connection;
    }

    public void setConnection(String connection) {
        this.connection = connection;
    }
}
