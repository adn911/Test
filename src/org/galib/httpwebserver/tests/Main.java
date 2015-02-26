package org.galib.httpwebserver.tests;

import org.galib.httpwebserver.server.SimpleHttpServerImpl;

import java.io.IOException;

/**
 * Created by bakhtiar.galib on 2/25/15.
 */
public class Main {

    public static void main(String[] args) throws IOException {

        new SimpleHttpServerImpl().go();
    }
}
