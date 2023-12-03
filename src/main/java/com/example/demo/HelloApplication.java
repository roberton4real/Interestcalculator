package com.example.demo;

import java.text.NumberFormat;
import java.util.Scanner;

public class HelloApplication {
    public static void main(String[] args) {
        final byte MONTHS_IN_YEAR = 12; // These are constant variables, meaning they do not change
        final byte PERCENT = 100;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Principal: ");
        int principal = scanner.nextInt();

        System.out.println("Annual Interest Rate: ");
        float annualInterest = scanner.nextFloat();
        float monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;

        System.out.println("Period (Years): ");
        byte years = scanner.nextByte();
        int numberOfPayments = years * MONTHS_IN_YEAR;

        double mortgage = principal
                * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                / (Math.pow(1 + monthlyInterest, numberOfPayments));

        // Format the mortgage amount using NumberFormat for better readability
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage: " + mortgageFormatted);

        // Close the Scanner to release resources
        scanner.close();
    }
}
