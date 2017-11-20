package com.company;

import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Escriba un texto: ");
        String x = br.readLine().toLowerCase();
        visualizarRecuento(contarLetras(x));
    }

    private static void visualizarRecuento(int[] cuentaLetras) {
        char alfabeto[] = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ".toCharArray();
        for (int i = 0; i < 27; i++) {
            if (cuentaLetras[i] > 0) System.out.println(alfabeto[i] + ": " + cuentaLetras[i]);
        }
    }

    private static int[] contarLetras(String texto) {
        char alfabeto[] = "abcdefghijklmnñopqrstuvwxyz".toCharArray();
        int cuentaLetras[] = new int[27];
        for (int i = 0; i < texto.length(); i++) {
            for (int y = 0; y < 27; y++) {
                if (texto.charAt(i) == alfabeto[y]) cuentaLetras[y] += 1;
            }
        }
        return cuentaLetras;
    }
}
