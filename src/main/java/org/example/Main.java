package org.example;

import java.util.LinkedHashSet;
import java.util.Set;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toCollection;

public class Main {
    public String arrayChallenge(int[] arr) {
        Set<Pair> setPair = new LinkedHashSet<>();
        for (int i = 0; i < arr.length; i += 2) {
            setPair.add(new Pair(arr[i], arr[i + 1]));
        }
        Set<Pair> setWithoutReversedPair = setPair.stream()
                .filter(p -> !setPair.contains(new Pair(p.getY(), p.getX())) || p.getX() == p.getY())
                .collect(toCollection(LinkedHashSet::new));

        return setWithoutReversedPair.isEmpty() ? "yes" : buildStringFromSet(setWithoutReversedPair);
    }

    private String buildStringFromSet(Set<Pair> set) {
        return set.stream().map(Pair::toString).collect(joining(", "));
    }
    public static void main(String[] args) {
        int[] arr = {2,1,1,2,3,3};
      //  int[] arr = {5,4,6,7,7,6,4,5};
        System.out.println(new Main().arrayChallenge(arr));
    }
}