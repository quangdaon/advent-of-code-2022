Imports System
Imports System.IO

Module Program
    Const INPUT_FILENAME = "./inputs/input.txt"
    Sub Main(args As String())
        Dim input As String
        Using textReader As New StreamReader(INPUT_FILENAME)
            input = textReader.ReadToEnd
        End Using
        
        Dim part1Result = ProcessPart1Solution(input)
        Console.WriteLine($"Solution to Part 1: {part1Result}")

        Dim part2Result = ProcessPart2Solution(input)
        Console.WriteLine($"Solution to Part 2: {part2Result}")
    End Sub
End Module
