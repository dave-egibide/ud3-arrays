package com.company;

import java.io.InputStreamReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Random;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Random r = new Random();
        int matriz[][] = new int[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                matriz[i][j] = r.nextInt(99);
            }
        }
        int matriz2[][] = new int[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                matriz2[i][j] = r.nextInt(99);
            }
        }
        int matrizResultado[][] = new int [4][4];
        String x;
        visualizarMatriz(matriz,matriz2);
        do {
            System.out.println("Introduzca la operación a ejecutar:");
            System.out.println("-SUMA de las matrices");
            System.out.println("-Producto de la primera por un ESCALAR");
            System.out.println("-PRODUCTO de las dos matrices");
            System.out.println("-TRASPUESTA de la segunda matriz");
            x = br.readLine().toLowerCase();
            if (!x.equals("fin")) {
                switch (x) {
                    case "suma":
                        for (int i = 0; i < 4; i++) {
                            for (int j = 0; j < 4; j++) {
                                matrizResultado[i][j] = matriz[i][j] + matriz2[i][j];
                            }
                        }
                        visualizarMatriz(matrizResultado);
                        break;
                    case "escalar":
                        System.out.print("Introduzca un escalar (número a multiplicar por): ");
                        int escalar = Integer.parseInt(br.readLine());
                        for (int i = 0; i < 4; i++) {
                            for (int j = 0; j < 4; j++) {
                                matrizResultado[i][j] = matriz[i][j] * escalar;
                            }
                        }
                    case "producto":
                        for (int i = 0; i < 4; i++) {
                            for (int j = 0; j < 4; j++) {
                                matrizResultado[i][j] = 0; //inicializar valores por si acaso
                                for (int k = 0; k < 4; k++) {
                                    matrizResultado[i][j] += matriz[i][k] * matriz2[k][j];
                                }
                            }
                        }
                        visualizarMatriz(matrizResultado);
                        break;
                    case "traspuesta":
                        for (int i = 0; i < 4; i++) {
                            for (int j = 0; j < 4; j++) {
                                matrizResultado[i][j] = matriz2[j][i];
                            }
                        }
                        visualizarMatriz(matrizResultado);
                        break;
                }
            }
        } while (!x.equals("fin"));
    }

    private static void visualizarMatriz(int matriz[][], int matriz2[][]) {
        System.out.println("---------------------   ---------------------");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.printf("| %02d ", matriz[i][j]);
            }
            System.out.print("|   ");
            for (int j = 0; j < 4; j++) {
                System.out.printf("| %02d ", matriz2[i][j]);
            }
            System.out.println("|");
        }
        System.out.println("---------------------   ---------------------");
    }
    private static void visualizarMatriz(int matriz[][]) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.printf("| %02d ", matriz[i][j]);
            }
            System.out.println("|");
        }
    }
}