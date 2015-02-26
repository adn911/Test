package org.galib.httpwebserver.httpmessageparser;

import org.galib.httpwebserver.httpmessages.HttpRequestMessage;

/**
 * Created by bakhtiar.galib on 2/24/15.
 */
public interface HttpMessageParser {

    public HttpRequestMessage parseGetMessage(String httpHeaderMessage);

    public HttpRequestMessage parsePostMessage(String httpHeaderMessage);
}
