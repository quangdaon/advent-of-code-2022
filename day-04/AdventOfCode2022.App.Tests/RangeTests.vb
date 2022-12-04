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
    End Class
End Namespace
