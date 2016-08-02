package com.mav;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

class MultiServer extends Thread {

    private Socket socket;
    private ObjectOutputStream outputStream;
    private ObjectInputStream inputStream;
    private LocalPrimeFactorizer primeFactorizer;

    MultiServer(Socket socket) {
        super("MultiServer");
        this.socket = socket;
    }
}
