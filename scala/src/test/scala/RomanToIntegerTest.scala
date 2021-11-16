import RomanToInteger.romanToInt
import munit.FunSuite

class RomanToIntegerTest extends FunSuite {

  test("romanToInt") {
    assert(romanToInt("III") == 3)
    assert(romanToInt("IV") == 4)
    assert(romanToInt("IX") == 9)
    assert(romanToInt("LVIII") == 58)
    assert(romanToInt("MCMXCIV") == 1994)
  }
}
