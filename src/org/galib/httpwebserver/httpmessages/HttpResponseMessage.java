package org.galib.httpwebserver.httpmessages;

/**
 * Created by bakhtiar.galib on 2/24/15.
 */
public class HttpResponseMessage extends HttpMessage {

    private String statusCode;
    private String statusMessage;
    private String date;
    private String server;
    private String lastModified;
    private String contentType;
    private int contentLength;
    private String contentBody;

    public HttpResponseMessage() {


    }

    public HttpResponseMessage(String statusCode, String statusMessage, String date, String server,
                               String lastModified, String contentType, int contentLength, String contentBody) {

        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
        this.date = date;
        this.server = server;
        this.lastModified = lastModified;
        this.contentType = contentType;
        this.contentLength = contentLength;
        this.contentBody = contentBody;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public String getLastModified() {
        return lastModified;
    }

    public void setLastModified(String lastModified) {
        this.lastModified = lastModified;
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

    @Override
    public String toString() {

        return   httpProtocolVersion +" "+statusCode+" "+statusMessage+"\r\n"
                 +"Content-Type: "+contentType+"\r\n"
                 +"Server: "+server+"\r\n"
                 +""+"\r\n"
                 +contentBody
               ;
    }
}
