package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tablero[][] = sudokuTablero();
        String x;
        int y;
        sudokuVisualizar(tablero);
        do {
            do {
                System.out.print("Escriba la casilla que desea cambiar escribiendo Vertical x Horizontal (ej.: 4x8): ");
                x = br.readLine().toLowerCase();
                if (tablero[Integer.parseInt(x.substring(0, 1)) - 1][Integer.parseInt(x.substring(2)) - 1] == 0) {
                    System.out.print("Escriba el número a rellenar: ");
                    y = Integer.parseInt(br.readLine());
                    if (y > 0 && y < 10) {
                        if (sudokuLinea(tablero, x, y) && sudokuCuadrante(tablero, x, y)) {
                            tablero[Integer.parseInt(x.substring(0, 1)) - 1][Integer.parseInt(x.substring(2)) - 1] = y;
                            sudokuVisualizar(tablero);
                        } else {
                            System.out.println("Número invalido.");
                            x = "";
                        }
                    } else {
                        System.out.println("Número invalido.");
                        x = "";
                    }
                } else {
                    System.out.println("Casilla ocupada.");
                    x = "";
                }
            } while (x.equals(""));
        } while (!sudokuFinalizado(tablero));
        System.out.println("Tablero completado. ¡Buen trabajo!");
    }

    private static boolean sudokuCuadrante(int[][] tablero, String casilla, int valor) {
        int dispVertical = (Integer.parseInt(casilla.substring(0, 1)) - 1) / 3;
        int dispHorizontal = (Integer.parseInt(casilla.substring(2)) - 1) / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tablero[i + (dispVertical * 3)][j + (dispHorizontal * 3)] == valor) return false;
            }
        }
        return true;
    }

    private static boolean sudokuLinea(int[][] tablero, String casilla, int valor) {
        for (int i = 0; i < 9; i++) {
            if (valor == tablero[Integer.parseInt(casilla.substring(0, 1)) - 1][i]) return false;
        }
        for (int i = 0; i < 9; i++) {
            if (valor == tablero[i][Integer.parseInt(casilla.substring(2)) - 1]) return false;
        }
        return true;
    }

    private static boolean sudokuFinalizado(int[][] tablero) {
        int total = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                total += tablero[i][j];
            }
        }
        return (total == 405);
    }

    private static void sudokuVisualizar(int[][] tablero) {
        System.out.println("x   1 2 3   4 5 6   7 8 9");
        System.out.println("    -----------------------");
        for (int i = 0; i < 9; i++) {
            System.out.print(i + 1 + " | ");
            for (int j = 0; j < 9; j++) {
                if (j == 3 || j == 6) System.out.print("| ");
                if (tablero[i][j] > 0) {
                    System.out.printf("%d ", tablero[i][j]);
                } else System.out.print("  ");
            }
            System.out.println("|");
            if (i == 2 || i == 5) System.out.println("    -----------------------");
        }
        System.out.println("    -----------------------");
    }

    private static int[][] sudokuTablero() {
        int[][] sudoku = {
                {1, 9, 5, 7, 8, 6, 3, 4, 2},
                {3, 7, 8, 4, 2, 9, 1, 6, 5},
                {2, 4, 6, 3, 5, 1, 7, 8, 9},
                {7, 6, 2, 5, 3, 8, 4, 9, 1},
                {8, 1, 3, 9, 6, 4, 5, 2, 7},
                {9, 5, 4, 1, 7, 2, 8, 3, 6},
                {4, 3, 9, 2, 1, 7, 6, 5, 8},
                {6, 2, 7, 8, 4, 5, 9, 1, 3},
                {5, 8, 1, 6, 9, 3, 2, 7, 4}
        };
        Random r = new Random();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (r.nextInt(10) > 2) sudoku[i][j] = 0;
            }
        }
        return sudoku;
    }
}



