package com.example.demo;

import java.text.NumberFormat;
import java.util.Scanner;

public class HelloApplication {

    private static final byte MONTHS_IN_YEAR = 12;
    private static final byte PERCENT = 100;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int principal = getInput("Principal: ", 1000, 1_000_000, scanner);
        float annualInterest = getInput("Annual Interest Rate: ", 0, 30, scanner);
        byte years = getInput("Period (Years): ", 1, 30, scanner);

        // Close the Scanner to release resources
        scanner.close();

        double mortgage = calculateMortgage(principal, annualInterest, years);

        // Format the mortgage amount using NumberFormat for better readability
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage: " + mortgageFormatted);
    }

    private static int getInput(String prompt, int min, int max, Scanner scanner) {
        int input;
        while (true) {
            System.out.println(prompt);
            input = scanner.nextInt();
            if (input >= min && input <= max) {
                break;
            }
            System.out.println("Enter a value between " + min + " and " + max);
        }
        return input;
    }

    private static float getInput(String prompt, float min, float max, Scanner scanner) {
        float input;
        while (true) {
            System.out.println(prompt);
            input = scanner.nextFloat();
            if (input >= min && input <= max) {
                break;
            }
            System.out.println("Enter a value between " + min + " and " + max);
        }
        return input;
    }

    private static double calculateMortgage(int principal, float annualInterest, byte years) {
        float monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;
        int numberOfPayments = years * MONTHS_IN_YEAR;
        return principal * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                / (Math.pow(1 + monthlyInterest, numberOfPayments));
    }
}
