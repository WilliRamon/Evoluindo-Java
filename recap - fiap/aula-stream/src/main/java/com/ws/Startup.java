package com.ws;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class Startup {
    public static void main(String[] args) {
        List<String> estudantes = Arrays.asList("Willi", "Léo", "Tamiris", "Lu");

        System.out.println("*** Utilizando o foreach ***");
        for(String estudante : estudantes){
            System.out.println("Estudante: " + estudante);
        }

        System.out.println("*** Utilizando o Iterator ***");
        Iterator<String> iterator = estudantes.iterator();
        while(iterator.hasNext()){
            System.out.println("Estudante: " + iterator.next());
        }

        System.out.println("*** Utilizando a Stream ***");
        Stream<String> stream = estudantes.stream();
        stream.forEach(System.out::println);
    }
}
