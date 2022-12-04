Imports System
Imports System.IO
Imports System.Reflection
Imports System.Text.RegularExpressions
Imports Xunit

Imports Processor

Namespace AdventOfCode2022.App.Tests
    Public Class ProcessorTests
        Dim SAMPLE_INPUT_FILENAME As String = GetInputFilename()

        ' https://codebuckets.com/2017/10/19/getting-the-root-directory-path-for-net-core-applications/
        Public Function GetInputFilename() As String
            Dim exePath = Path.GetDirectoryName(Assembly.GetExecutingAssembly().Location)
            Dim appPathMatcher = new Regex("(?<!fil)[A-Za-z]:\\+[\S\s]*?(?=\\+bin)")
            Dim appRoot = appPathMatcher.Match(exePath).Value
            Return new DirectoryInfo(Path.Combine(appRoot, "../inputs/input.sample.txt")).FullName
        End Function

        Public Shared ParseAssignmentRowArguments As IEnumerable(Of Object()) = {
            New Object() { "1-2,1-2", (New Range(1, 2), New Range(1, 2)) },
            New Object() { "36-75,23-33", (New Range(36, 75), New Range(23, 33)) }
        }

        <Theory>
        <MemberData(NameOf(ParseAssignmentRowArguments))>
        Sub ParseAssignmentsRow_GivenRow_ReturnsArraysOfAssignments(input As String, expected As (Range, Range))
            Dim result = ParseAssignmentsRow(input)
            Assert.Equal(expected.Item1.Min, result.Item1.Min)
            Assert.Equal(expected.Item1.Max, result.Item1.Max)
            Assert.Equal(expected.Item2.Min, result.Item2.Min)
            Assert.Equal(expected.Item2.Max, result.Item2.Max)
        End Sub

        <Fact>
        Sub ProcessPart1Solution_GivenAocSample_ReturnsProvidedResult()
            Dim input As String
            Using textReader As New StreamReader(SAMPLE_INPUT_FILENAME)
                input = textReader.ReadToEnd
            End Using

            Dim result = ProcessPart1Solution(input)
            Assert.Equal(2, result)
        End Sub

        <Fact>
        Sub ProcessPart2Solution_GivenAocSample_ReturnsProvidedResult()
            Dim input As String
            Using textReader As New StreamReader(SAMPLE_INPUT_FILENAME)
                input = textReader.ReadToEnd
            End Using

            Dim result = ProcessPart2Solution(input)
            Assert.Equal(4, result)
        End Sub
    End Class
End Namespace

