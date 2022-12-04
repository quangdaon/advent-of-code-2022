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

public class ProcessorTest {
    private static final String SAMPLE_INPUT_FILEPATH = "./inputs/input.sample.txt";

    @Test
    public void testPart1Solution_givenAocSample_returnsProvidedResults() {
        try {
            Processor processor = new Processor();

            File sampleInputFile = new File(SAMPLE_INPUT_FILEPATH);
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

            File sampleInputFile = new File(SAMPLE_INPUT_FILEPATH);
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
