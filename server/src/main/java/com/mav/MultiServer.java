package com.mav;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

class MultiServer extends Thread {

    private Socket acceptSocket;
    private ObjectOutputStream outputStream;
    private ObjectInputStream inputStream;
    private LocalPrimeFactorizer primeFactorizer;

    MultiServer(Socket acceptSocket) {
        super("MultiServer");
        this.acceptSocket = acceptSocket;
    }

    public void run() {

        try {

            primeFactorizer = new LocalPrimeFactorizer();

            outputStream = new ObjectOutputStream(acceptSocket.getOutputStream());

            inputStream = new ObjectInputStream(acceptSocket.getInputStream());

            while (acceptSocket.isConnected()) {
                outputStream.writeObject(primeFactorizer.factorize((Integer) inputStream.readObject()));
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
