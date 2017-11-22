package com.company;

import java.io.IOException;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Random r = new Random();
        int matriz[][] = new int[10][10];
        for (int i = 0; i < 10; i++) {
            for (int y = 0; y < 10; y++) {
                matriz[i][y] = r.nextInt(99);
            }
        }
        System.out.println("---------------------------------------------------");
        for (int i = 0; i < 10; i++) {
            for (int y = 0; y < 10; y++) {
                System.out.printf("| %02d ",matriz[i][y]);
            }
            System.out.println("|");
        }
        System.out.println("---------------------------------------------------");
    }
}