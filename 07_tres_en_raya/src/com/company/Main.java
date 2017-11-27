package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String turno = "0";
        int contador = 0;
        String tablero[][] = new String[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tablero[i][j] = " ";
            }
        }
        System.out.println("TRES EN RAYA");
        do {
            visualizarTablero(tablero);
            System.out.println("Turno de jugador " + turno);
            System.out.print("Escriba la casilla a jugar (Vertical x horizontal. Ej: 1x1): ");
            String x = br.readLine();
            if (tablero[Integer.parseInt(x.substring(0, 1)) - 1][Integer.parseInt(x.substring(2)) - 1].equals(" ")) {
                tablero[Integer.parseInt(x.substring(0, 1)) - 1][Integer.parseInt(x.substring(2)) - 1] = String.valueOf(turno);
                if (!comprobarGanador(turno, tablero)) {
                    ++contador;
                    if (turno.equals("0")) {
                        turno = "1";
                    } else turno = "0";
                }
            } else System.out.println("Casilla incorrecta.");

        } while (!comprobarGanador(turno, tablero) && contador < 9);
        if (contador == 9) System.out.println("Fin de la partida - Empate");
        else
            System.out.println("Fin de la partida - Victoria de Jugador " + turno);
    }

    private static boolean comprobarGanador(String turno, String[][] tablero) {
        return ((tablero[0][0] + tablero[0][1] + tablero[0][2]).equals(turno + turno + turno) ||
                (tablero[0][0] + tablero[1][0] + tablero[2][0]).equals(turno + turno + turno) ||
                (tablero[0][0] + tablero[1][1] + tablero[2][2]).equals(turno + turno + turno) ||
                (tablero[0][1] + tablero[1][1] + tablero[2][1]).equals(turno + turno + turno) ||
                (tablero[0][2] + tablero[1][1] + tablero[2][0]).equals(turno + turno + turno) ||
                (tablero[0][2] + tablero[1][2] + tablero[2][2]).equals(turno + turno + turno) ||
                (tablero[1][0] + tablero[1][1] + tablero[1][2]).equals(turno + turno + turno) ||
                (tablero[2][0] + tablero[2][1] + tablero[2][2]).equals(turno + turno + turno));
    }

    private static void visualizarTablero(String[][] tablero) {
        System.out.println("    1   2   3");
        System.out.println("  -------------");
        for (int i = 0; i < 3; i++) {
            System.out.print(i + 1);
            for (int j = 0; j < 3; j++) {
                System.out.print(" | " + tablero[i][j]);
            }
            System.out.println(" |");
            System.out.println("  -------------");
        }
    }
}
