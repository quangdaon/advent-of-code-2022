package com.quangdao.aoc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {
    private static final String INPUT_FILEPATH = "./inputs/input.txt";
    
    public static void main(String[] args) {
        try {
            Processor processor = new Processor();

            File inputFile = new File(INPUT_FILEPATH);
            Scanner scanner = new Scanner(inputFile);
            scanner.useDelimiter("\\Z");
            String inputText = scanner.next();
            scanner.close();

            Integer part1Result = processor.processPart1Solution(inputText);
            System.out.println("Solution to Part 1: " + part1Result);

            Integer part2Result = processor.processPart2Solution(inputText);
            System.out.println("Solution to Part 2: " + part2Result);
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
