package com.mav;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Client {

    private static final String START_MESSAGE = "Enter an integer: ";
    private static final String REPEAT_MESSAGE = "Continue? Enter another integer: ";
    private static final String RESULT_MESSAGE = "Prime factors of number '%d' are as follows : %s %n";
    private static final String WRONG_INPUT_MESSAGE = "Wrong input, try again: ";

    private static Scanner sc = new Scanner(System.in);

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
        System.out.printf(RESULT_MESSAGE, number, primeFactors(number));
    }

    public static Set primeFactors(long number) {
        Set primefactors = new HashSet<>();
        long copyOfInput = number;

        for (int i = 2; i <= copyOfInput; i++) {
            if (copyOfInput % i == 0) {
                primefactors.add(i); // prime factor
                copyOfInput /= i;
                i--;
            }
        }
        return primefactors;
    }
}
