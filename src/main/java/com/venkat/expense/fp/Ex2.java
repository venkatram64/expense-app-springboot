package com.venkat.expense.fp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ex2 {

    private static void process(){

        var list = List.of(22, 10, 51, 73, 37, 47);
        var newStream = list.stream()
                .map(i -> i * 2);
        newStream.forEach(System.out::println);
    }

    private static void process2(){

        var list = List.of(22, 10, 51, 73, 37, 47);
        var newStream = list.stream()
                .map(i -> i * 2);
        var max = newStream.max(Integer::compareTo);
        System.out.println("MAX..." + max);

        var intStream = list.stream().mapToInt(i -> i + 10);

        var intMax = intStream.max();
        System.out.println("int max ..." + intMax);

        var ints = new int[]{23, 10, 45, 12, 9};
        IntStream.of(ints)
                .mapToObj(i -> "$ " + i)
                .forEach(System.out::println);
    }

    private static void process3(){
        System.out.println("********************");
        var ints = new int[]{23, 10, 45, 12, 9};
        IntStream.of(ints)
                .map(i -> {
                    System.out.println("Mapping " + i);
                    return i + 4;
                })
                .filter(i -> {
                    System.out.println("Filtering " + i);
                    return i > 15;
                })
                .forEach(System.out::println);
    }

    private static void process4(){
        System.out.println("********************");
        var list = List.of(22, 10, 51, 73, 37, 47);
        list.stream()
                .flatMap(i -> Stream.of(i + 10, i + 2))
                .forEach(System.out::println);
    }

    private static void process5(){
        System.out.println("********* Flat Map ***********");
        var arr1 = new int[] {2, 12, 90};
        var arr2 = new int[] {13, 7, 2};
        Stream.of(arr1, arr2)
                .flatMapToInt(i -> IntStream.of(i))
                .forEach(System.out::println);
    }

    public static void main(String[] args) {
        process();
        process2();
        process3();
        process4();
        process5();
    }
}
