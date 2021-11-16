import munit.FunSuite

class ValidParenthesesTest extends FunSuite {

  test("valid") {
    List("()", "{[]}", "()[]{}").foreach { testCase =>
      val result = ValidParentheses.isValid(testCase)
      assert(result)
    }
  }

  test("invalid") {
    List("([)]", "(]", "(").foreach { testCase =>
      val result = ValidParentheses.isValid(testCase)
      assert(!result)
    }
  }
}
