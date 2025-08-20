package com.wederson.currency;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n=== CONVERSOR DE MOEDAS ===");
            System.out.println("1. USD -> BRL");
            System.out.println("2. BRL -> USD");
            System.out.println("3. EUR -> BRL");
            System.out.println("4. BRL -> EUR");
            System.out.println("5. USD -> EUR");
            System.out.println("6. EUR -> USD");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            int choice = scanner.nextInt();

            if (choice == 0) {
                running = false;
                continue;
            }

            System.out.print("Digite o valor: ");
            double amount = scanner.nextDouble();

            String from = "";
            String to = "";

            switch (choice) {
                case 1: from = "USD"; to = "BRL"; break;
                case 2: from = "BRL"; to = "USD"; break;
                case 3: from = "EUR"; to = "BRL"; break;
                case 4: from = "BRL"; to = "EUR"; break;
                case 5: from = "USD"; to = "EUR"; break;
                case 6: from = "EUR"; to = "USD"; break;
                default:
                    System.out.println("Opção inválida!");
                    continue;
            }

            double result = CurrencyConverter.convert(from, to, amount);
            if (result != -1) {
                System.out.printf("%.2f %s = %.2f %s%n", amount, from, result, to);
            }
        }

        scanner.close();
        System.out.println("Programa encerrado.");
    }
}
