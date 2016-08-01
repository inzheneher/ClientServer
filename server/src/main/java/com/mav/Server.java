package com.mav;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private ServerSocket serverSocket;
    private Socket acceptSocket;
    private ObjectOutputStream outputStream;
    private ObjectInputStream inputStream;
    private LocalPrimeFactorizer primeFactorizer;

    public static void main(String[] args) {
        Server server = new Server();
        server.run();
    }

        private void run(){

            try {

                serverSocket = new ServerSocket(12512);
                acceptSocket = serverSocket.accept();
                primeFactorizer = new LocalPrimeFactorizer();

                outputStream = new ObjectOutputStream(acceptSocket.getOutputStream());

                inputStream = new ObjectInputStream(acceptSocket.getInputStream());

                while (acceptSocket.isConnected()) {
                    outputStream.writeObject(primeFactorizer.factorize((Integer) inputStream.readObject()));
                }
            } catch (IOException |ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
}
