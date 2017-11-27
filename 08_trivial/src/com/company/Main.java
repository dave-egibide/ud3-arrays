package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] preguntas = {"¿En qué deporte se usa tiza?.", "¿Cuántas manos tiene un caballo?",
                "¿Qué instrumento musical tiene nombre y forma geométricos?", "¿Cuáles son las dos primeras palabras de la Biblia?",
                "¿Quién escribió \"El Diario de Ana Frank\"?", "¿Cómo se llaman las crías de la mula?",
                "¿Cuál es el limite de edad establecido para participar en los Juegos Olímpicos?",
                "¿Qué isla del Caribe tiene nombre de flor?", "¿Qué capital española tiene cinco veces la misma vocal \"a\"?",
                "¿Cuántas capitales de provincia españolas empiezan por \"V\"?"};
        String[] respuestas = {"En el billar.", "Dos.", "El triángulo.", "\"Al principio\".", "Ana Frank.",
                "La mula no tiene crías.", "Ninguno.", "La isla Margarita.", "Guadalajara.", "Tres: Valencia, Valladolid y Vitoria"};
        String x;
        Random r = new Random();
        int aleatorio, marcador = 0;
        System.out.println("Bienvenido a Trivial - Edición 10 Preguntas. Introduzca la respuesta correcta para acumular" +
                "puntos o escriba FIN para terminar.");
        do {
            aleatorio = r.nextInt(9);
            System.out.println(preguntas[aleatorio]);
            x = br.readLine().toLowerCase();
            if (!x.equals("fin")) {
                System.out.println("La respuesta era: " + respuestas[aleatorio]);
                System.out.println("¿Era ésta su respuesta? Sí/No:");
                x = br.readLine().toLowerCase();
                if (x.equals("si") || x.equals("sí")) marcador++;
            }
        } while (!x.equals("fin"));
        System.out.printf("Fin de la partida. Ha acertado %d preguntas.", marcador);
    }
}
