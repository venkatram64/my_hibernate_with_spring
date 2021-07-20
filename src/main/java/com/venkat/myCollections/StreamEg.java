package com.venkat.myCollections;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamEg {

    public static void main(String[] args) {
        Stream<Integer> integerStream = Stream.of(20, 12, 15, 77, 89, 90, 100);



        integerStream.filter(i -> i > 80)
                .forEach(System.out::println);

        int[] arr1 = new int[]{4, 88, 22, 3, 9, 25};
        Arrays.stream(arr1).map(i -> i * 3)
                .sorted()
                .forEach(System.out::println);

        integerStream = Stream.of(20, 12, 15, 77, 89, 90, 100);
        integerStream.min(Integer::compare)
                .ifPresent(System.out::println);

        IntStream.of(2, 3, 8, 0, -2)
                .min()
                .ifPresent(System.out::println);
    }
}
