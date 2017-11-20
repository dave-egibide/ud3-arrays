package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double min = Double.MAX_VALUE, max = Double.MIN_VALUE, total = 0;
        double temperatura[] = new double[24];

        System.out.println("Escriba una temperatura para cada hora de un día.");

        for (int i = 0; i < 24; i++) {
            System.out.printf("Hora %02d: ", i);
            temperatura[i] = Double.parseDouble(br.readLine());

            total += temperatura[i];
            if (temperatura[i] < min) min = temperatura[i];
            if (temperatura[i] > max) max = temperatura[i];
        }

        System.out.println("--- Tabla temperatura ---");

        for (int i = 0; i < 24; i++) {
            System.out.printf("%02d  ", i);

            for (int y = 0; y < temperatura[i]; y++) {
                System.out.print("*");
            }

            System.out.print("  " + temperatura[i]);

            if (temperatura[i] == max) {
                System.out.println("  --> MAX");
            } else if (temperatura[i] == min) {
                System.out.println("  --> MIN");
            } else System.out.println();
        }

        System.out.printf("Media: %f", total / 24);
    }
}
