package org.galib.httpwebserver.httpmessageparser;

import org.galib.httpwebserver.httpmessageparser.HttpMessageParser;
import org.galib.httpwebserver.httpmessages.HttpRequestMessage;

/**
 * Created by bakhtiar.galib on 2/24/15.
 */
public class HttpMessageParserImpl implements HttpMessageParser {

    @Override
    public HttpRequestMessage parseGetMessage(String message) {

        HttpRequestMessage httpRequestMessage = new HttpRequestMessage();
        String headerLines[] = message.split("\r\n");

        httpRequestMessage.setMethod(headerLines[0].split(" ")[0]);
        httpRequestMessage.setUrl(headerLines[0].split(" ")[1]);
        httpRequestMessage.setHttpProtocolVersion(headerLines[0].split(" ")[2]);

        for(String line:headerLines){

            if(line.startsWith("Host: "))
                httpRequestMessage.setHost(line.replace("Host: ",""));

            if(line.startsWith("User-Agent: "))
                httpRequestMessage.setUserAgent(line.replace("User-Agent: ", ""));

            if(line.startsWith("Accept-Language: "))
                httpRequestMessage.setAcceptLanguage(line.replace("Accept-Language: ", ""));

            if(line.startsWith("Connection: "))
                httpRequestMessage.setConnection(line.replace("Connection: ",""));
        }

        return httpRequestMessage;
    }

    @Override
    public HttpRequestMessage parsePostMessage(String message) {

        HttpRequestMessage httpRequestMessage = new HttpRequestMessage();
        String headerLines[] = message.split("\r\n");

        httpRequestMessage.setMethod(headerLines[0].split(" ")[0]);
        httpRequestMessage.setUrl(headerLines[0].split(" ")[1]);
        httpRequestMessage.setHttpProtocolVersion(headerLines[0].split(" ")[2]);

        for(String line:headerLines){

            if(line.startsWith("Host: "))
                httpRequestMessage.setHost(line.replace("Host: ",""));

            if(line.startsWith("User-Agent: "))
                httpRequestMessage.setUserAgent(line.replace("User-Agent: ", ""));

            if(line.startsWith("Connection: "))
                httpRequestMessage.setConnection(line.replace("Connection: ",""));
        }

        httpRequestMessage.setContentBody(headerLines[headerLines.length-1]);
        return httpRequestMessage;
    }
}
