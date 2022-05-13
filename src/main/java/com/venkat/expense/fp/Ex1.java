package com.venkat.expense.fp;

import com.venkat.expense.fp.model.Person;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ex1 {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(12,9,13,4,6,2,4,12,15);
        List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker", "Kubernetes");
//        oddNum(numbers);
//        printBooks(courses);
          //printBooksBySorted(courses);
//        printBooksWithFilter(courses);
//        printAtleast4letters(courses);
//        squareOfOddNum(numbers);
//        sum(numbers);
//        myDistinct(numbers);
          //squareOfNumByCollect(numbers);
          squareOfEvenNum(numbers);
          sum2(numbers);
          //
        /*filterAndPrint(numbers, x -> x % 2 == 0);
        filterAndPrint(numbers, x -> x % 2 != 0);*/
        multiplyNum(numbers, x -> x * x);
        System.out.println("*******************");
        multiplyNum(numbers, x -> x * 4);
        //stream examples
        myStreamEx1();
    }

    public static void multiplyNum(List<Integer> numbers,Function<Integer, Integer> integerIntegerFunction){
        numbers
            .stream()
            .map( integerIntegerFunction)
            .forEach(System.out::println);
    }

    private static void filterAndPrint(List<Integer> numbers, Predicate<Integer> predicate){
        numbers
            .stream()
            .filter(predicate)
            .forEach(System.out :: println);
    }

    public static void oddNum(List<Integer> numbers){
        numbers.stream().
                filter(n -> n % 2 != 0)
                .forEach(System.out::println);
    }

    public static void squareOfOddNum(List<Integer> numbers){
        numbers.stream().
                filter(n -> n % 2 != 0)
                .map(n -> n * n)
                .forEach(System.out::println);
    }

    public static void printBooks(List<String> books){
        books.stream().forEach(System.out::println);
    }

    public static void printBooksBySorted(List<String> books){
        books.
                stream().
                sorted(Comparator.naturalOrder()).
                forEach(System.out::println);
        System.out.println("***************");
        books.
                stream().
                sorted(Comparator.reverseOrder()).
                forEach(System.out::println);
        System.out.println("***************");
        books.
                stream().
                sorted(Comparator.comparing(String::length)).
                forEach(System.out::println);
    }

    public static void printBooksWithFilter(List<String> books){
        books.stream()
                .filter(x -> x.contains("Spring"))
                .forEach(System.out::println);
    }

    public static void printAtleast4letters(List<String> books){
        books.stream()
                .filter(x -> x.length() >=4)
                .forEach(System.out::println);
    }

    private static int mySum(int a, int b){
        System.out.println(a + "  " + b);
        return a + b;
    }
    public static void sum(List<Integer> numbers){
        int sum = numbers.stream()
                //.reduce(0,Ex1 :: mySum)
                //.reduce(0, (x, y) -> x + y)
                .reduce(0, Integer :: sum)
                .intValue();
        System.out.println("Sum is " + sum);
    }

    public static void myDistinct(List<Integer> numbers){

        numbers.stream()
                .distinct()
                .forEach(System.out :: println);

        numbers.stream()
                .sorted()
                .forEach(System.out :: println);
    }

    public static void squareOfNumByCollect(List<Integer> numbers){
        System.out.println("***** squareOfNumByCollect ******");
        List<Integer> squaredNums = numbers.stream()
                .map(number -> number * number)
                .collect(Collectors.toList());

        squaredNums.forEach(System.out :: println);
    }

    public static void squareOfEvenNum(List<Integer> numbers){
        System.out.println("***** squareOfNumByCollect ******");
        Predicate<Integer> isEven = x -> x % 2 == 0;
        Predicate<Integer> isEven2 = new Predicate<Integer>() {
            @Override
            public boolean test(Integer x) {
                return x % 2 == 0;
            }
        };
        Function<Integer, Integer> squareIt = number -> number * number;

        Function<Integer, Integer> squareIt2 = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer x) {
                return x * x;
            }
        };

        Consumer<Integer> print = System.out::println;
        numbers.stream()
                .filter(isEven)
                .map(squareIt)
                .forEach(print);
    }

    public static void sum2(List<Integer> numbers){
        BinaryOperator<Integer> sum1 = new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer x, Integer y) {
                return x + y;
            }
        };

        int sum = numbers.stream()
                .reduce(0, sum1)
                .intValue();
        System.out.println("Sum is " + sum);
    }

    public static void myStreamEx1(){
        var stream = Stream.of(23, 10, 74, 100);
        System.out.println("*****************************");
        stream.forEach(i -> System.out.println(i));

        System.out.println("*************");
        var arr1 = new int[]{4, 80, 77, 10, 1};
        Stream.of(arr1)
                .forEach(System.out::println);
        //below converts int array object into primitives
        Arrays.stream(arr1)
                .forEach(System.out::println);
        //IntStream will accepts the int array
        System.out.println("*****************");
        IntStream.of(arr1)
                .forEach(System.out::println);

        //integer objects
        var list = List.of(2,10, 5, 7, 8);
        var min = list.stream().min((a,b) -> Integer.compare(a,b));
        System.out.println(min);
        var min2 = list.stream().min(Integer::compare);
        System.out.println(min2);

        //primitive data types
        IntStream.of(arr1)
                .min()
                .ifPresent(System.out::println);

        var sum = list.stream()
                //.reduce((a, b) -> a + b);
                .reduce(0, (a, b) -> a + b);

        System.out.println("Reduced sum is " + sum);

        // reduce
        System.out.println("REDUCER...");
        var people = List.of(
                new Person("Jack", 34, 12.1f),
                new Person("Joe", 27, 89.4f),
                new Person("James", 47, 08.7f),
                new Person("John", 34, 82.3f)
        );

        /*var person = people.stream()
                .reduce((p1, p2) ->{
                    if(p1.getAge() > p2.getAge()){
                        return p1;
                    }else{
                        return p2;
                    }
                });*/

       /* var binaryOperator = BinaryOperator.<Person>maxBy((p1, p2) ->
                    Math.max(p1.getAge(), p2.getAge()));

        var person = people.stream()
                        .reduce(binaryOperator);*/

        var personComparator = Comparator.<Person>comparingInt(p -> p.getAge());
        var binaryOperator = BinaryOperator.maxBy(personComparator);
        var person = people.stream()
                        .reduce(binaryOperator);

        System.out.println(person);
    }
}
