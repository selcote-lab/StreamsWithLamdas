package com.tonasolution;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

        Stream<String> ioNumbersStream = Stream.of("123", "112", "071");
        Stream<String> inNumbersStream = Stream.of("123", "112", "071");
        Stream<String> concatStream = Stream.concat(ioNumbersStream, inNumbersStream);
        System.out.println("-------------------------------------");
//        System.out.println(concatStream.distinct().count());
        System.out.println(concatStream.distinct().peek(System.out::println).count());

        Employee zouhaire = new Employee("Zouhaire Elakioui",29);
        Employee ali = new Employee("Ali Sako",28);
        Employee sarah = new Employee("Sarah Bamako",28);

        Department hr = new Department("Humain Resources");
        hr.addEmployee(ali);
        hr.addEmployee(sarah);
        Department accounting = new Department("Accounting");
        accounting.addEmployee(zouhaire);

        List<Department> departments = new ArrayList<>();
        departments.add(hr);
        departments.add(accounting);

        departments
                .stream()
                .flatMap(department -> department.getEmployees().stream())
                .forEach(System.out::println);

       /* List<String> sortedGNumbers = someBingNumbers
                .stream()
                .map(String::toUpperCase)
                .filter(s -> s.startsWith("G"))
                .sorted()
                .collect(Collectors.toList());*/
        List<String> sortedGNumbers = someBingNumbers
                .stream()
                .map(String::toUpperCase)
                .filter(s -> s.startsWith("G"))
                .sorted()
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

        for (String s: sortedGNumbers){
            System.out.println(s);
        }

        Map<Integer, List<Employee>> groupedByAge = departments.stream()
                                                        .flatMap(department -> department.getEmployees().stream())
                                                        .collect(Collectors.groupingBy( employee -> employee.getAge()));

        departments.stream()
                    .flatMap(department -> department.getEmployees().stream())
                    .reduce((e1, e2) -> e1.getAge() < e2.getAge() ? e1 : e2)
                    .ifPresent(System.out::println);

        Stream.of("ABC", "AC", "BAA", "CCC", "XY", "ST")
                .filter(s -> {
                        System.out.println(s);
                        return args.length == 3;
                    }
                )
                .count();


    }
}
