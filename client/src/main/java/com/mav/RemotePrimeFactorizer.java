package com.mav;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;

class RemotePrimeFactorizer implements PrimeFactorizer {

    private Socket clientSoket;
    private ObjectOutputStream outputStream;
    private ObjectInputStream inputStream;

    RemotePrimeFactorizer() {
        try {
            clientSoket = new Socket("localhost", 12512);

            outputStream = new ObjectOutputStream(clientSoket.getOutputStream());

            inputStream = new ObjectInputStream(clientSoket.getInputStream());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Set<Integer> factorize(Integer numberToFactorize) {

        try {
            outputStream.writeObject(numberToFactorize);
            return (HashSet<Integer>) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
