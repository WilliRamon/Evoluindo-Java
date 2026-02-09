package com.ws;

import java.util.stream.Stream;

public class ConstrucaoStream {
    public static void main(String[] args) {
        Stream<Number> notas = Stream.of(1, 2, 3, 4, 5, 6.7, 7, 8, 9, 10, 98.7);
        notas.forEach(System.out::println);

        System.out.println("******** <hr/> ********");

        Number[] maisNotas = {7, 8.9, 4.5, 7, 10, 10};
        Stream.of(maisNotas).forEach(System.out::println);
        System.out.println("******** <hr/> ********");
        Stream.of(maisNotas).parallel().forEach(System.out::println);
    }
}
