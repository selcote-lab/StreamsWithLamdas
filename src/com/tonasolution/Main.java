package com.tonasolution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> someBingNumbers = Arrays.asList(
             "N40", "N36",
             "B12", "B6",
             "G53", "G49", "G60", "G50","g46",
             "126", "117", "129",
             "071"
        );
        List<String> gNumbers = new ArrayList<>();
//        someBingNumbers.forEach( s -> {
//            if(s.toUpperCase().startsWith("G")){
//                gNumbers.add(s);
//                System.out.println(s);
//            }
//        } );
//
//        gNumbers.sort((String s1, String s2) -> s1.compareTo(s2));
//        gNumbers.forEach((String s) -> System.out.println(s));

        someBingNumbers
                .stream()
                .map(String::toUpperCase)
                .filter(s -> s.startsWith("G"))
                .sorted()
                .forEach(System.out::println);
    }
}
