package org.galib.httpwebserver.server;

import org.galib.httpwebserver.httpmessageparser.HttpMessageParser;
import org.galib.httpwebserver.httpmessageparser.HttpMessageParserImpl;
import org.galib.httpwebserver.httpmessages.HttpMethod;
import org.galib.httpwebserver.httpmessages.HttpRequestMessage;
import org.galib.httpwebserver.httpmessages.HttpResponseMessage;
import org.galib.httpwebserver.utilities.FileService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by bakhtiar.galib on 2/24/15.
 */
public class HttpClientHandler implements Runnable {

    private BufferedReader reader;
    private PrintWriter writer;
    private Socket clientSocket;
    private HttpMessageParser httpMessageParser;


    public HttpClientHandler(Socket clientSocket) throws IOException {

        this.clientSocket = clientSocket;
        this.reader = new BufferedReader(new InputStreamReader(
                clientSocket.getInputStream()));

        this.writer = new PrintWriter(clientSocket.getOutputStream());
        this.httpMessageParser = new HttpMessageParserImpl();
    }

    @Override
    public void run() {

        HttpRequestMessage httpRequestMessage = getHttpRequestMessage();
        sendResponse(httpRequestMessage);
        closeConnection();

    }




    private HttpRequestMessage getHttpRequestMessage() {

        HttpRequestMessage httpRequestMessage = null;
        String httpRequestMessageString = "";
        String line = ".";

        while (line!=null && !line.equals("")) {
            try {
                line = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            httpRequestMessageString += line + "\r\n";
        }

        String method = httpRequestMessageString.split("\r\n")[0].split(" ")[0];

        if(method.equals(HttpMethod.GET)){

            httpRequestMessage = httpMessageParser.parseGetMessage(httpRequestMessageString);

        }else if (method.equals(HttpMethod.POST)) {

            httpRequestMessageString += getPostContent(httpRequestMessageString);
            httpRequestMessage = httpMessageParser.parsePostMessage(httpRequestMessageString);
        }

        System.out.println(httpRequestMessageString);
        return httpRequestMessage;
    }


    private void sendResponse(HttpRequestMessage httpRequestMessage) {

        if( httpRequestMessage!= null ){

            String url = httpRequestMessage.getUrl();
            String pageRequest = ( url.contains("?") == true ? url.split("\\?")[0] : url );

            System.out.println(pageRequest);

            HttpResponseMessage httpResponseMessage = new HttpResponseMessage();
            httpResponseMessage.setHttpProtocolVersion("HTTP/1.0");
            httpResponseMessage.setStatusCode("200");
            httpResponseMessage.setStatusMessage("OK");
            httpResponseMessage.setContentType("text/html");
            httpResponseMessage.setServer("Test Server");
            httpResponseMessage.setContentBody(FileService.readFromFile(pageRequest));

            //System.out.println(httpResponseMessage);
            writer.println(httpResponseMessage);
            writer.flush();
        }

    }

    private String getPostContent(String httpRequestMessageString){
        int contentLength = Integer.parseInt(httpRequestMessageString.split("Content-Length: ")[1].split("\r\n")[0]);
        char[] content = new char[contentLength];

        try {
            reader.read(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new String(content);
    }


    private void closeConnection() {

        try {
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
