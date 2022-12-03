package com.quangdao.aoc;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Processor {
  private final String[] PART_1_PERMUTATIONS = {
      "B X",
      "C Y",
      "A Z",
      "A X",
      "B Y",
      "C Z",
      "C X",
      "A Y",
      "B Z"
  };

  private final String[] PART_2_PERMUTATIONS = {
      "B X",
      "C X",
      "A X",
      "A Y",
      "B Y",
      "C Y",
      "C Z",
      "A Z",
      "B Z"
  };

  // https://www.geeksforgeeks.org/find-the-index-of-an-array-element-in-java/
  private static int findIndex(String[] arr, String t) {
    int len = arr.length;
    return IntStream.range(0, len)
        .filter(i -> t.equals(arr[i]))
        .findFirst() // first occurrence
        .orElse(-1); // No element found
  }

  private int processTotalScore(String[] permutations, String input) {
    String[] results = input.split("\n");

    int[] scores = new int[results.length];

    for (int i = 0; i < results.length; i++) {
      scores[i] = findIndex(permutations, results[i].trim()) + 1;
    }

    return IntStream.of(scores).sum();
  }

  public int processPart1Solution(String input) {
    return processTotalScore(PART_1_PERMUTATIONS, input);
  }


  public int processPart2Solution(String input) {
    return processTotalScore(PART_2_PERMUTATIONS, input);
  }
}
