
Imports System.Linq

Public Module Processor
  Public Function ParseAssignmentsRow(row As String) As (Range, Range)
    Dim assignments = row.Split(
      New Char() {"-", ","}).ToArray().Select(Function(x) Integer.Parse(x))

    Return (
      New Range(assignments(0), assignments(1)), 
      New Range(assignments(2), assignments(3))
    )
  End Function

  Public Function ProcessPart1Solution(input As String)
    Dim rows = input.Split(Environment.NewLine)
    Dim containedCount = 0

    For Each row As String in rows
      Dim ranges = ParseAssignmentsRow(row)
      Dim range1 = ranges.Item1
      Dim range2 = ranges.Item2

      If range1.Contains(range2) OrElse range2.Contains(range1) Then
        containedCount += 1
      End If
    Next

    Return containedCount
  End Function

  Public Function ProcessPart2Solution(input As String)
    Dim rows = input.Split(Environment.NewLine)
    Dim containedCount = 0

    For Each row As String in rows
      Dim ranges = ParseAssignmentsRow(row)
      Dim range1 = ranges.Item1
      Dim range2 = ranges.Item2

      If range1.Overlaps(range2) Then
        containedCount += 1
      End If
    Next

    Return containedCount
  End Function
End Module