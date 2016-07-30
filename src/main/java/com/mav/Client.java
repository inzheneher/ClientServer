package com.mav;

import java.util.Scanner;

public class Client {

    private static final String START_MESSAGE = "Enter an integer: ";
    private static final String REPEAT_MESSAGE = "Continue? Enter another integer: ";
    private static final String WRONG_INPUT_MESSAGE = "Wrong input, try again: ";

    private static Scanner sc = new Scanner(System.in);

    private boolean appCondition = true;

    void run() {

        System.out.println(START_MESSAGE);

        while (appCondition) {

            String appStartCondition = sc.nextLine();

            switch (appStartCondition) {

                case "start":

                    break;

                case "exit":
                    appCondition = false;
                    break;

                default:
                    System.out.println(WRONG_INPUT_MESSAGE);
                    break;
            }
        }
    }

}
