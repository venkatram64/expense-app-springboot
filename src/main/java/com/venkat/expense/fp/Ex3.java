package com.venkat.expense.fp;

import com.venkat.expense.fp.model.Person;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ex3 {

    private static <V> V findMostFrequentItem(final Collection<V> items){
        return items.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .max(Comparator.comparing(Map.Entry::getValue))
                .map(Map.Entry::getKey)
                .orElse(null);
    }

    /*private static <V> V findMostFrequentItem(final Collection<V> items){
        boolean seen = false;
        Map.Entry<V, Long> best = null;

        Comparator<Map.Entry<V, Long>> comparator = Comparator.comparing(Map.Entry::getValue);

        for (Map.Entry<V, Long> vLongEntry : items.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()) {
            if (!seen || comparator.compare(vLongEntry, best) > 0) {
                seen = true;
                best = vLongEntry;
            }
        }
        return (seen ? Optional.of(best) : Optional.<Map.Entry<V, Long>>empty())
                .map(Map.Entry::getKey)
                .orElse(null);
    }*/

    /*private static <V> Map<V, Long> findFrequencies(final Collection<V> items){
        Map<V, Long> map = new HashMap<>();
        for (V item : items) {
            if (item != null) {
                map.merge(item, 1L, Long::sum);
            }
        }
        return map;
    }*/

    private static <V> Map<V, Long> findFrequencies(final Collection<V> items){
        return items.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    private static void wordCount() throws IOException {
        System.out.println("********* Flat Map ***********");

        long wordCount = Files.lines(Paths.get("sample.txt"))
                .flatMap(line -> Arrays.stream(line.split("\\s+")))
                .distinct()
                .count();
        System.out.println(wordCount);
    }

    private static void wordFrequencyCount(){
        var words = Arrays.asList("hello", "bye", "Java", "Scala", "hello", "Java", "C++");
        Map<String, Integer> counts = words.parallelStream()
                .collect(Collectors.toConcurrentMap(w -> w, w-> 1, Integer :: sum));
        System.out.println(counts);
    }

    private static void mostFrequentWord(){
        System.out.println("**********Most Frequent word***********");
        var words = Arrays.asList("hello","Scala", "bye", "Java", "Scala", "hello", "Java", "C++", "Scala");

        System.out.println(findMostFrequentItem(words));
    }

    private static void wordFrequencyCount2(){
        System.out.println("word frequencies");
        var words = Arrays.asList("hello", "bye", "Java", "Scala", "hello", "Java", "C++");
        System.out.println(findFrequencies(words));
    }

    private static void flatMapEx1(){
        var arr1 = new int[]{2, 18, 49};
        var arr2 = new int[]{14, 7, 3};

        Stream.of(arr1, arr2)
                .flatMapToInt(IntStream::of)
                .forEach(System.out::println);
    }

    private static void allMatch(){
        System.out.println("All Match...");
        var people = List.of(
                new Person("Jack", 34, 12.1f),
                new Person("Joe", 27, 89.4f),
                new Person("James", 47, 08.7f),
                new Person("John", 34, 82.3f)
        );

        var result = people.stream().allMatch(p -> p.getScore() > 70);
        System.out.println(result);
    }

    private static void streamBuilderEx(){
        var builder = Stream.<Integer>builder();
        builder.accept(12);
        builder.accept(14);
        builder.accept(7);
        builder.accept(16);
        builder.accept(34);

        var sum = builder.build()
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println("Sum using the Stream Builder ... " + sum);

    }

    private static void streamBuilderEx2(){
        var builder = Stream.<Integer>builder();
        var sc = new Scanner(System.in);
        var value = 0;

        do {
            System.out.println("Enter a number !");
            builder.accept(value);
            value = sc.nextInt();
        }while(value != -1);

        System.out.println("Sum: ");

        var sum = builder.build()
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println(sum);
    }

    private static void collectEx(){
        var list = List.of(2, 5, 1, 10, 3, 9, 11, 30 , 12);

       /* list.stream()
                .filter(i -> i % 2 == 0)
                .collect(
                        () -> new ArrayList<Integer>(),//supplier
                        (listI, value) -> listI.add(value),
                        (l1, l2) -> l1.addAll(l2)
                );*/

        /*var result = list.stream()
                .filter(i -> i % 2 == 0)
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);*/

        var result = list.stream()
                .filter(i -> i % 2 == 0)
                .collect(HashSet::new, HashSet::add, HashSet::addAll);

        System.out.println("Even numbers : " + result);
    }

    private static void addTo(){
        System.out.println("All Match...");
        var people = List.of(
                new Person("Jack", 34, 12.1f),
                new Person("Mark", 24, 82.3f),
                new Person("Joe", 27, 89.4f),
                new Person("James", 47, 08.7f),
                new Person("John", 34, 82.3f)
        );

        var result = people.stream()
                                .filter(p -> p.getAge() > 27)
                                .collect(Collectors.toList());
        System.out.println(result);
    }

    private static void joining(){
        System.out.println("All Match...");
        var people = List.of(
                new Person("Jack", 34, 12.1f),
                new Person("Mark", 24, 82.3f),
                new Person("Joe", 27, 89.4f),
                new Person("James", 47, 08.7f),
                new Person("John", 34, 82.3f)
        );

       /* var result = people.stream()
                .map(p -> p.getName())
                .collect(Collectors.joining(", "));*/

        var result = people.stream()
                .map(p -> p.getName())
                .collect(Collectors.joining(", ", "Names are ", "."));

        System.out.println(result);
    }

    private static void toMap(){
        System.out.println("All Match...");
        var people = List.of(
                new Person("Jack", 34, 12.1f),
                new Person("Mark", 24, 82.3f),
                new Person("Joe", 27, 89.4f),
                new Person("James", 47, 08.7f),
                new Person("John", 34, 82.3f)
        );


        var result = people.stream()
                .collect(Collectors.toMap(p -> p.getName(), p ->p.getScore()));

        System.out.println(result);
    }


    private static void toPartitionBy(){
        System.out.println("All Match...");
        var people = List.of(
                new Person("Jack", 34, 12.1f),
                new Person("Mark", 24, 84.3f),
                new Person("Joe", 27, 89.4f),
                new Person("James", 47, 08.7f),
                new Person("John", 34, 72.3f)
        );


        var result = people.stream()
                .collect(Collectors.partitioningBy(p -> p.getScore() > 50));

        System.out.println(result);

        var result2 = people.stream()
                .collect(Collectors.partitioningBy(p -> p.getScore() > 50, Collectors.toList()));
        System.out.println("Collected by list: ");
        System.out.println(result2);

        var result3 = people.stream()
                .collect(Collectors.partitioningBy(p -> p.getScore() > 50, Collectors.summarizingInt(p -> p.getAge())));
        System.out.println("Summarizing list: ");
        System.out.println(result3);
    }

    private static void groupingBy(){
        System.out.println("All Match...");
        var people = List.of(
                new Person("Jack", 34, 12.1f),
                new Person("Mark", 24, 84.3f),
                new Person("Joe", 27, 89.4f),
                new Person("James", 47, 08.7f),
                new Person("John", 27, 72.3f)
        );


        var result = people.stream()
                .collect(Collectors.groupingBy(p -> p.getAge()));
        System.out.println("Grouping by");
        System.out.println(result);


    }

    public static void main(String[] args) {

        try {
            wordCount();
        } catch (IOException e) {
            e.printStackTrace();
        }
        wordFrequencyCount();
        mostFrequentWord();
        wordFrequencyCount2();
        allMatch();
        streamBuilderEx();
        //streamBuilderEx2();
        collectEx();
        addTo();
        joining();
        toMap();
        toPartitionBy();
        groupingBy();
    }
}
