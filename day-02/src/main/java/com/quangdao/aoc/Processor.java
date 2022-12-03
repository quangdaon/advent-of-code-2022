package com.quangdao.aoc;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Processor {
  // { "Rock", "Paper", "Scissors" }
  private static final char[] PLAYER_SYMBOLS = { 'X', 'Y', 'Z' };
  private static final char[] OPPONENT_SYMBOLS = { 'A', 'B', 'C' };

  public Choices[] parseChoices(String row) {
    char[] choices = row.replace(" ", "").toCharArray();

    return new Choices[] {
        Choices.values()[java.util.Arrays.binarySearch(OPPONENT_SYMBOLS, choices[0])],
        Choices.values()[java.util.Arrays.binarySearch(PLAYER_SYMBOLS, choices[1])]
    };
  }

  public int calculateScore(Choices opponent, Choices player) {
    int optionScore = player.ordinal() + 1; // 1 for Rock, 2 for Paper, and 3 for Scissors
    int outcome = calculateOutcome(opponent, player); // -1 = Loss, 0 = Draw, 1 = Win
    int outcomeMultiplier = outcome + 1;
    int outcomeScore = outcomeMultiplier * 3;
    return optionScore + outcomeScore;
  }

  public int calculateOutcome(Choices opponent, Choices player) {
    // I made a mistake trying to solve this mathematically instead of conditionally
    int diff = player.ordinal() - opponent.ordinal();
    return Math.abs(diff) == 2 ? -diff / Math.abs(diff) : diff;
  }

  public int processPart1Solution(String input) {
    String[] results = input.split("\n");

    int[] scores = new int[results.length];

    for (int i = 0; i < results.length; i++) {
      Choices[] choices = parseChoices(results[i]);
      scores[i] = calculateScore(choices[0], choices[1]);
    }

    return IntStream.of(scores).sum();
  }

  public int processPart2Solution(String input) {
    return 123;
  }
}
