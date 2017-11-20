package com.company;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String x;

        System.out.print("Escriba el número de alumnos en la clase: ");
        int numlista = Integer.parseInt(br.readLine());

        String listaalumno[] = new String[numlista];

        for (int i = 0; i < numlista; i++) {
            System.out.printf("Escriba el nombre y apellidos del alummno #%d: ", i + 1);
            listaalumno[i] = br.readLine();
        }

        do {
            System.out.print("Escriba una letra para buscar inicial o STOP para terminar: ");
            x = br.readLine().toLowerCase();
            if (!x.equals("stop")) {
                for (int i = 0; i < numlista; i++) {
                    if (listaalumno[i].toLowerCase().startsWith(x.substring(0, 1))) System.out.println(listaalumno[i]);
                }
            }
        } while (!x.equals("stop"));
    }
}
