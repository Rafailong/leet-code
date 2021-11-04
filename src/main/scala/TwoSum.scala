object TwoSum {

  def twoSumBruteForce(nums: Array[Int], target: Int): Array[Int] = {
    val zipped = nums.zipWithIndex

    {
      for {
        (in, i) <- zipped
        (jn, j) <- zipped
        if in + jn == target && i != j
      } yield Array(i, j)
    }.head
  }

  def main(args: Array[String]): Unit = {
    val result = twoSumBruteForce(
      nums = Array(3, 1, 3),
      target = 6
    )

    assert(result sameElements Array(0, 2))
  }
}
