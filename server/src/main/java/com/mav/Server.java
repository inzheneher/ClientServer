package com.mav;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private ServerSocket serverSocket;
    private Socket acceptSocket;
    private PrintStream output;
    private BufferedReader input;
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

            output = new PrintStream(acceptSocket.getOutputStream());

            input = new BufferedReader(new InputStreamReader(acceptSocket.getInputStream()));

            while (acceptSocket.isConnected()) {
                output.println(primeFactorizer.factorize(Integer.valueOf(input.readLine())));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
