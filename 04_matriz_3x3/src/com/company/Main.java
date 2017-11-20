package com.company;

import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int matriz[][] = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int y = 0; y < 3; y++) {
                System.out.printf("Escriba el valor %dx%d: ", i + 1, y + 1);
                matriz[i][y] = Integer.parseInt(br.readLine());
            }
        }
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.printf("| %d | %d | %d |\n", matriz[i][0],matriz[i][1],matriz[i][2]);
        }
        System.out.println("-------------");
    }
}
