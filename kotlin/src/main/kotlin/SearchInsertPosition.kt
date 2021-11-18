object SearchInsertPosition {

    // https://leetcode.com/problems/search-insert-position/
    fun searchInsert(nums: IntArray, target: Int): Int {

        if (nums.isEmpty()) return 0

        val size = nums.size
        if (size == 1) return if (nums[0] < target) 1 else 0

        val index = size / 2
        val n = nums[index]

        return if (n == target) index
        else if (n > target) {
            val newNums = nums.sliceArray(IntRange(0, index - 1))
            searchInsert(newNums, target)
        } else {
            val newNums = nums.sliceArray(IntRange(index, size - 1))
            searchInsert(newNums, target) + index
        }
    }
}