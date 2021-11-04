object PalindromeNumber {
  def isPalindromeBruteForce(x: Int): Boolean = {
    val s1 = x.toString
    s1 == s1.reverse
  }

  def main(args: Array[String]): Unit = {
    assert(isPalindromeBruteForce(121))

    assert(!isPalindromeBruteForce(-121))
    assert(!isPalindromeBruteForce(10))
    assert(!isPalindromeBruteForce(-101))
  }
}
