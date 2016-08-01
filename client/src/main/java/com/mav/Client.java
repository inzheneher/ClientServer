package com.mav;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

class Client {

    private static final String START_MESSAGE = "Enter an integer: ";
    private static final String REPEAT_MESSAGE = "Continue? Enter another integer: ";
    private static final String RESULT_MESSAGE = "Prime factors of number '%d' are as follows : %s %n";
    private static final String WRONG_INPUT_MESSAGE = "Wrong input, try again: ";

    private Socket clientSoket;
    private BufferedReader input;
    private PrintStream output;
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Client client = new Client();
        client.run();
    }

    private void run() {
        try {
            clientSoket = new Socket("localhost", 12512);

            input = new BufferedReader(new InputStreamReader(clientSoket.getInputStream()));

            output = new PrintStream(clientSoket.getOutputStream());

            while (clientSoket.isConnected()){
                String reply = scanner.nextLine();
                output.println(reply);

                String message = input.readLine();
                System.out.println("Server: " + message);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
