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
}
