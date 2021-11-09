object RomanToInteger {

  val symbols = Map(
    'I' -> 1,
    'V' -> 5,
    'X' -> 10,
    'L' -> 50,
    'C' -> 100,
    'D' -> 500,
    'M' -> 1000
  )

  val specials = Map(
    "IV" -> 4,
    "IX" -> 9,
    "XL" -> 40,
    "XC" -> 90,
    "CD" -> 400,
    "CM" -> 900
  )

  def romanToInt(s: String): Int = {
    var sum = 0
    val size = s.length
    var i = 0
    while (i < size) {
      val a = s(i)

      // extracting next char
      val j = i + 1
      if (j < size) {
        val str = s"$a${s(j)}"

        // and finding if the pair of current and next is s special case
        specials.get(str) match {
          case Some(n) =>
            sum = sum + n
            i = i + 2
          case None =>
            symbols.get(a).foreach { n =>
              sum = sum + n
              i = i + 1
            }
        }
      } else {
        symbols.get(a).foreach { n =>
          sum = sum + n
          i = i + 1
        }
      }

    }

    sum
  }

  def main(args: Array[String]): Unit = {

    assert(romanToInt("III") == 3)
    assert(romanToInt("IV") == 4)
    assert(romanToInt("IX") == 9)
    assert(romanToInt("LVIII") == 58)
    assert(romanToInt("MCMXCIV") == 1994)
  }
}
