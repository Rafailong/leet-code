import PalindromeNumber.{isPalindrome, isPalindromeBruteForce}
import munit.FunSuite

class PalindromeNumberTest extends FunSuite {

  test("isPalindromeBruteForce") {
    assert(isPalindromeBruteForce(121))
    assert(!isPalindromeBruteForce(-121))
    assert(!isPalindromeBruteForce(10))
    assert(!isPalindromeBruteForce(-101))
  }

  test("isPalindrome") {
    assert(isPalindrome(121))
    assert(!isPalindrome(-121))
    assert(!isPalindrome(10))
    assert(!isPalindrome(-101))
  }
}
