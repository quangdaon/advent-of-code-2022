Imports Xunit

Imports Models

Namespace AdventOfCode2022.App.Tests
    Public Class RangeTests
      Dim TestRange As Range = New Range(10, 20)

      <Fact>
      Sub Contains_GivenSmallerRange_ReturnsTrue
        Assert.True(TestRange.Contains(New Range(12, 15)))
      End Sub

      <Fact>
      Sub Contains_GivenRangeAlignedToLowerBound_ReturnsTrue
        Assert.True(TestRange.Contains(New Range(10, 12)))
      End Sub

      <Fact>
      Sub Contains_GivenRangeAlignedToUpperBound_ReturnsTrue
        Assert.True(TestRange.Contains(New Range(18, 20)))
      End Sub

      <Fact>
      Sub Contains_EquivalentRange_ReturnsTrue
        Assert.True(TestRange.Contains(New Range(10, 20)))
      End Sub

      <Fact>
      Sub Contains_GivenLargerRange_ReturnsFalse
        Assert.False(TestRange.Contains(New Range(9, 21)))
      End Sub

      <Fact>
      Sub Contains_GivenOverlappingRange_ReturnsFalse
        Assert.False(TestRange.Contains(New Range(17, 25)))
      End Sub

      <Fact>
      Sub Contains_GivenDisconnectedRange_ReturnsFalse
        Assert.False(TestRange.Contains(New Range(30, 31)))
      End Sub

      <Fact>
      Sub Overlaps_GivenUpperOverlappingRange_ReturnsTrue
        Assert.True(TestRange.Overlaps(New Range(18, 22)))
      End Sub

      <Fact>
      Sub Overlaps_GivenLowerOverlappingRange_ReturnsTrue
        Assert.True(TestRange.Overlaps(New Range(8, 12)))
      End Sub

      <Fact>
      Sub Overlaps_GivenContainedRange_ReturnsTrue
        Assert.True(TestRange.Overlaps(New Range(14, 16)))
      End Sub

      <Fact>
      Sub Overlaps_GivenWrappingRange_ReturnsTrue
        Assert.True(TestRange.Overlaps(New Range(5, 32)))
      End Sub

      <Fact>
      Sub Overlaps_GivenRangeOverUpperBound_ReturnsFalse
        Assert.False(TestRange.Overlaps(New Range(30, 31)))
      End Sub

      <Fact>
      Sub Overlaps_GivenRangeUnderLowerBound_ReturnsFalse
        Assert.False(TestRange.Overlaps(New Range(4, 5)))
      End Sub
    End Class
End Namespace
