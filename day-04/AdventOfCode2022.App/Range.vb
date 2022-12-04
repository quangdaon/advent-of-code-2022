Public Module Models
  Public Class Range
    Public Min As Integer
    Public Max As Integer

    Public Sub New(x As Integer, y As Integer)
      Min = x
      Max = y
    End Sub

    Public Function Contains(comparison As Range) As Boolean
      Return (Min <= comparison.Min) AndAlso (Max >= comparison.Max)
    End Function
  End Class
End Module