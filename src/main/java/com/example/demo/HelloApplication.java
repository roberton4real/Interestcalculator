package com.example.demo;

import java.text.NumberFormat;
import java.util.Scanner;

public class HelloApplication {
    public static void main(String[] args) {
        final byte MONTHS_IN_YEAR = 12; // These are constant variables, meaning they do not change
        final byte PERCENT = 100;
        int principal = 0;

        Scanner scanner = new Scanner(System.in);

        // Principal Input Loop
        while (true) {
            System.out.println("Principal: ");
            principal = scanner.nextInt();
            if (principal >= 1000 && principal <= 1_000_000)
                break;
            System.out.println("Enter a value between 1000 and 1000000");
        }

        // Annual Interest Rate Input Loop
        float annualInterest;
        while (true) {
            System.out.println("Annual Interest Rate: ");
            annualInterest = scanner.nextFloat();
            if (annualInterest > 0 && annualInterest <= 30)
                break;
            System.out.println("Enter a value between 0 and 30");
        }

        // Period (Years) Input Loop
        byte years;
        while (true) {
            System.out.println("Period (Years): ");
            years = scanner.nextByte();
            if (years >= 1 && years <= 30)
                break;
            System.out.println("Enter a value between 1 and 30");
        }

        // Mortgage Calculation
        float monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;
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
