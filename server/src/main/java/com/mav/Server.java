package com.mav;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private ServerSocket serverSocket;
    private Socket acceptSocket;
    private ObjectOutputStream output;
    private ObjectInputStream input;
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

                output = new ObjectOutputStream(acceptSocket.getOutputStream());

                input = new ObjectInputStream(acceptSocket.getInputStream());

                while (acceptSocket.isConnected()) {
                    output.writeObject(primeFactorizer.factorize((Integer) input.readObject()));
                }
            } catch (IOException |ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
}
