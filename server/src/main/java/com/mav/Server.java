package com.mav;

import java.io.IOException;
import java.net.ServerSocket;

public class Server {

    public static void main(String[] args) {

        boolean listening = true;
        ServerSocket serverSocket;

        try {
            serverSocket = new ServerSocket(12512);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        while (listening) {
            try {
                new MultiServer(serverSocket.accept()).start();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
