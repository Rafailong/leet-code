object PalindromeNumber {
  def isPalindromeBruteForce(x: Int): Boolean = {
    val s1 = x.toString
    s1 == s1.reverse
  }

  def isPalindrome(x: Int): Boolean = {

    if (x < 0) false
    else {
      var arr = Array.empty[Int]
      var arr1 = Array.empty[Int]
      var n = x

      while (n > 0) {
        val a = n % 10
        arr = arr.appended(a)
        arr1 = arr1.prepended(a)

        n = n / 10
      }

      arr.sameElements(arr1)
    }
  }
}
