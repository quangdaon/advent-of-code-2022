package com.quangdao.aoc;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;

import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * Unit test for simple App.
 */
@RunWith(Enclosed.class)
public class ProcessorTest {

    @RunWith(Parameterized.class)
    public static class ParseChoicesTest {
        private String row;
        private int[] expected;

        @Parameters
        public static Collection<Object[]> data() {
            return Arrays.asList(new Object[][] {
                    { "A X", new int[] { 0, 0 } },
                    { "A Z", new int[] { 0, 2 } },
                    { "C Y", new int[] { 2, 1 } }
            });
        }

        public ParseChoicesTest(String row, int[] expected) {
            this.row = row;
            this.expected = expected;
        }

        @Test
        public void testParseChoices() {
            Processor processor = new Processor();
            int[] results = processor.parseChoices(row);

            assertArrayEquals(expected, results);
        }
    }
    
    @RunWith(Parameterized.class)
    public static class TransposePlayerChoiceTest {
        

        private int opponentIndex;
        private int outcome;
        private Choices expected;

        @Parameters
        public static Collection<Object[]> data() {
            return Arrays.asList(new Object[][] {
                    { Choices.Rock.ordinal(), 0, Choices.Scissors },
                    { Choices.Rock.ordinal(), 1, Choices.Rock },
                    { Choices.Rock.ordinal(), 2, Choices.Paper }
            });
        }

        public TransposePlayerChoiceTest(int opponentIndex, int outcome, Choices expected) {
            this.opponentIndex = opponentIndex;
            this.outcome = outcome;
            this.expected = expected;
        }

        @Test
        public void testTransposePlayerChoice() {
            Processor processor = new Processor();
            Choices results = processor.transposePlayerChoice(opponentIndex, outcome);

            assertEquals(expected, results);
        }
    }

    @RunWith(Parameterized.class)
    public static class CalculateOutcomeTest {
        private Choices opponent;
        private Choices player;
        private int expected;

        @Parameters
        public static Collection<Object[]> data() {
            return Arrays.asList(new Object[][] {
                    { Choices.Rock, Choices.Rock, 0 },
                    { Choices.Rock, Choices.Scissors, -1 },
                    { Choices.Scissors, Choices.Paper, -1 },
                    { Choices.Rock, Choices.Paper, 1 }
            });
        }

        public CalculateOutcomeTest(Choices opponent, Choices player, int expected) {
            this.opponent = opponent;
            this.player = player;
            this.expected = expected;
        }

        @Test
        public void testCalculateOutcome() {
            Processor processor = new Processor();
            int results = processor.calculateOutcome(opponent, player);

            assertEquals(expected, results);
        }
    }

    @RunWith(Parameterized.class)
    public static class CalculateScoreTest {
        private Choices opponent;
        private Choices player;
        private int expected;

        @Parameters
        public static Collection<Object[]> data() {
            return Arrays.asList(new Object[][] {
                    { Choices.Rock, Choices.Rock, 4 },
                    { Choices.Rock, Choices.Paper, 8 },
                    { Choices.Rock, Choices.Scissors, 3 },
                    { Choices.Paper, Choices.Rock, 1 },
                    { Choices.Paper, Choices.Paper, 5 },
                    { Choices.Paper, Choices.Scissors, 9 },
                    { Choices.Scissors, Choices.Rock, 7 },
                    { Choices.Scissors, Choices.Paper, 2 },
                    { Choices.Scissors, Choices.Scissors, 6 }
            });
        }

        public CalculateScoreTest(Choices opponent, Choices player, int expected) {
            this.opponent = opponent;
            this.player = player;
            this.expected = expected;
        }

        @Test
        public void testCalculateScore() {
            Processor processor = new Processor();
            int results = processor.calculateScore(opponent, player);

            assertEquals(expected, results);
        }
    }

    public static class SolutionsTest {

        @Test
        public void testPart1Solution_givenAocSample_returnsProvidedResults() {
            try {
                Processor processor = new Processor();

                File sampleInputFile = new File("./inputs/input.sample.txt");
                Scanner scanner = new Scanner(sampleInputFile);
                scanner.useDelimiter("\\Z");
                String sampleInput = scanner.next();

                assertEquals(15, processor.processPart1Solution(sampleInput));

                scanner.close();
            } catch (FileNotFoundException e) {
                assertTrue(false);
            }
        }

        @Test
        public void testPart2Solution_givenAocSample_returnsProvidedResults() {
            try {
                Processor processor = new Processor();

                File sampleInputFile = new File("./inputs/input.sample.txt");
                Scanner scanner = new Scanner(sampleInputFile);
                scanner.useDelimiter("\\Z");
                String sampleInput = scanner.next();

                assertEquals(12, processor.processPart2Solution(sampleInput));

                scanner.close();
            } catch (FileNotFoundException e) {
                assertTrue(false);
            }
        }
    }

}
