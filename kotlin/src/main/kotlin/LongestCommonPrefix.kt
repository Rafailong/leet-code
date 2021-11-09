object LongestCommonPrefix {

    fun longestCommonPrefix(strs: Array<String>): String {

        if (strs.size == 1) {
            return strs[0]
        }

        val acc = StringBuilder().append("")

        // sort in-place
        strs.sortBy { s -> s.length }

        val shortestWord: String = strs[0]
        val words = strs.drop(1).toTypedArray()

        var extFlag = true
        var charIndex = 0

        // assuming not empty words here!
        while (extFlag && charIndex < shortestWord.length) {
            val char = shortestWord[charIndex]

            var wordIndex = 0
            while (wordIndex < words.size) {
                val word = words[wordIndex]
                val c = word[0]
                if (c != char) {
                    extFlag = false // breaking outter loop
                    break // breaking inner loop
                }

                words.set(wordIndex, word.drop(1))

                wordIndex += 1
            }

            if (!extFlag) continue

            acc.append(char)
            charIndex += 1
        }

        return acc.toString()
    }
}