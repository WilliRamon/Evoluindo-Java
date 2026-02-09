package com.ws;

import java.util.Arrays;

public class AprendendoFilter {
    public static void main(String[] args) {
        Double[] notas = {5.5,5.5,7.3,7.2};
        Arrays.stream(notas)
                .filter(nota -> nota >= 7)
                .map(nota -> "Você foi aprovado com a nota: " + nota)
                .forEach(System.out::println);
    }
}
