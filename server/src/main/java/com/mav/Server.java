/**
 * This is the entry point for server side.
 * This class is responsible for establishing connection
 * between server and client and launching instance of Worker.
 */

package com.mav;

import java.io.IOException;
import java.net.ServerSocket;

public class Server {

    public static void main(String[] args) {

        boolean listening = true;
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(12512);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        while (listening) {
            try {
                new Worker(serverSocket.accept()).start();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
