import io.kotest.core.spec.style.StringSpec
import org.assertj.core.api.Assertions.assertThat

class LongestCommonPrefixSpec : StringSpec({
    "check implementation" {
        val arr: Array<String> = arrayOf("flower", "flow", "flight")
        val prefix = LongestCommonPrefix.longestCommonPrefix(arr)
        assertThat(prefix).isEqualTo("fl")
    }
})