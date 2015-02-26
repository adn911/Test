package org.galib.httpwebserver.server;

import org.galib.httpwebserver.utilities.Configuration;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by bakhtiar.galib on 2/24/15.
 */
public class SimpleHttpServerImpl implements SimpleHttpServer {

    private ServerSocket serverSocket;
    private ExecutorService executorService;


    @Override
    public void go() throws IOException {

        serverSocket = new ServerSocket(Configuration.LISTENING_PORT);
        executorService = Executors.newFixedThreadPool(Configuration.INITIAL_THREAD_POOL_SIZE);

        while (true) {

            Socket clientSocket = serverSocket.accept();
            executorService.execute(new HttpClientHandler(clientSocket));
        }

    }


}
