package com.mav;

import java.util.Scanner;

class Client {

    private static final String START_MESSAGE = "Enter an integer: ";
    private static final String REPEAT_MESSAGE = "Continue? Enter another integer: ";
    private static final String RESULT_MESSAGE = "Prime factors of number '%d' are as follows : %s %n";
    private static final String WRONG_INPUT_MESSAGE = "Wrong input, try again: ";

    private static Scanner sc = new Scanner(System.in);
    private static LocalPrimeFactorizer localPrimeFactorizer = new LocalPrimeFactorizer();

    public static void main(String[] args) {

    }


    void run() {

        int number;
        do {
            System.out.println(START_MESSAGE);
            while (!sc.hasNextInt()) {
                System.out.println(WRONG_INPUT_MESSAGE);
                sc.next();
            }
            number = sc.nextInt();

        } while (number <= 0);
        System.out.printf(RESULT_MESSAGE, number, localPrimeFactorizer.factorize(number));
    }
}
