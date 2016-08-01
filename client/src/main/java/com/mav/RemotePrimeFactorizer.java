package com.mav;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;

public class RemotePrimeFactorizer implements PrimeFactorizer {

    private Socket clientSoket;
    private BufferedReader input;
    private PrintStream output;


    public void run(String reply) {
        try {
            clientSoket = new Socket("localhost", 12512);

            input = new BufferedReader(new InputStreamReader(clientSoket.getInputStream()));

            output = new PrintStream(clientSoket.getOutputStream());

            while (clientSoket.isConnected()){

                output.println(reply);

                String message = input.readLine();
                System.out.println("Server: " + message);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Set<Integer> factorize(Integer numberToFactorize) {
        Set<Integer> primefactors = new HashSet<>();
        long copyOfInput = numberToFactorize;

        for (int i = 2; i <= copyOfInput; i++) {
            if (copyOfInput % i == 0) {
                primefactors.add(i);
                copyOfInput /= i;
                i--;
            }
        }
        return primefactors;
    }
}
