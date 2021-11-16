import TwoSum.twoSumBruteForce
import munit.FunSuite

class TwoSumTest extends FunSuite {

  test("twoSumBruteForce") {
    val result = twoSumBruteForce(
      nums = Array(3, 1, 3),
      target = 6
    )

    assert(result sameElements Array(0, 2))
  }
}
