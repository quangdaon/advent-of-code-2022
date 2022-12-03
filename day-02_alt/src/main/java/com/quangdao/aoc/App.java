package com.quangdao.aoc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        try {
            Processor processor = new Processor();

            File inputFile = new File("./inputs/input.txt");
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
