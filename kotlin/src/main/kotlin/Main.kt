fun main(args: Array<String>) {
    val arr: Array<String> = arrayOf("flower", "flow", "flight")
    val prefix = LongestCommonPrefix.longestCommonPrefix(arr)
    assert(prefix == "fl")
    println("Prefix is: '$prefix'")
}