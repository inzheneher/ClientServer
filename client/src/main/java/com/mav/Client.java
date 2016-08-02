package com.mav;

import java.util.Scanner;

class Client {

    private static final String START_MESSAGE = "Enter an integer: ";
    private static final String REPEAT_MESSAGE = "Continue? Enter another integer: ";
    private static final String RESULT_MESSAGE = "Prime factors of number '%d' are as follows : %s %n";
    private static final String WRONG_INPUT_MESSAGE = "Wrong input, try again: ";

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
