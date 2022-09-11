package org.example;

import org.example.model.Pair;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;


import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toCollection;

public class Main {
    public String arrayChallenge(int[] arr) {
        if (arr.length == 0){
            return "array is empty";
        }
        Set<Pair> pairs = new LinkedHashSet<>();

        for (int i = 0; i < arr.length; i += 2) {
            pairs.add(new Pair(arr[i], arr[i + 1]));
        }
        Set<Pair> withoutReversedPair = pairs.stream()
                .filter(p -> !pairs.contains(new Pair(p.getY(), p.getX())) || p.getX() == p.getY())
                .collect(toCollection(LinkedHashSet::new));

        return withoutReversedPair.isEmpty() ? "yes" : buildStringFromSet(withoutReversedPair);
    }

    private String buildStringFromSet(Set<Pair> set) {
        return set.stream().map(Pair::toString).collect(joining(", "));
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] arr = Arrays.stream(scan.nextLine()
                        .trim()
                        .split(","))
                .filter(x ->  !x.equals(""))
                .mapToInt(Integer::parseInt)
                .filter(x -> x >= 0)
                .toArray();
        System.out.println(new Main().arrayChallenge(arr));
    }
}