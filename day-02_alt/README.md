# Day Two: Java (Alternate)

My ["official" attempt](../day-02/) at solving this problem uses mathematical algorithms to determine the outcome and total score for each match. However, due to the nature of the puzzle, there are only nine distinct rows and each one maps one-to-one to a final score. This alternate solution takes advantage of this fact and rather than trying to calculate the result of each row, it just matches the string input for each round to its corresponding score.

The reason this works is because the scores granted by the outcome (0 for a loss, 3 for a draw, and 6 for a win) are spaced evenly, three points apart. Then the score awarded for the selection fills in the gaps. The possible scores are as follows:

| Score | Description        | Opponent | Us (Score)  | Result (Score) | Part 1 Row | Part 2 Row |
| :---- | ------------------ | -------- | ----------- | -------------- | ---------- | ---------- |
| 1     | Lose with Rock     | Paper    | Rock (1)    | Loss (0)       | B X        | B X        |
| 2     | Lose with Paper    | Scissors | Paper (2)   | Loss (0)       | C Y        | C X        |
| 3     | Lose with Scissor  | Rock     | Scissor (3) | Loss (0)       | A Z        | A X        |
| 4     | Draw with Rock     | Rock     | Rock (1)    | Draw (3)       | A X        | A Y        |
| 5     | Draw with Paper    | Paper    | Paper (2)   | Draw (3)       | B Y        | B Y        |
| 6     | Draw with Scissors | Scissors | Scissor (3) | Draw (3)       | C Z        | C Y        |
| 7     | Win with Rock      | Scissor  | Rock (1)    | Win (6)        | C X        | C Z        |
| 8     | Win with Paper     | Rock     | Paper (2)   | Win (6)        | A Y        | A Z        |
| 9     | Win with Scissors  | Paper    | Scissor (3) | Win (6)        | B Z        | B Z        |

## Running Tests

```
mvn clean test
```

## Running Program

You will need to create a file called `input.txt` inside the `inputs` folder for a valid input from AOC for this challenge.

```
mvn clean compile exec:java
```

Warning: This program outputs the solutions to BOTH parts of Day 2. Beware of spoilers.
