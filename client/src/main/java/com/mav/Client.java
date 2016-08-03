package com.mav;

import java.util.Scanner;

class Client {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        RemotePrimeFactorizer primeFactorizer = new RemotePrimeFactorizer();

        Integer fromConsole;

        while (scanner.hasNext()) {

            fromConsole = scanner.nextInt();

            System.out.println("Server: " + primeFactorizer.factorize(fromConsole));

        }
    }
}
