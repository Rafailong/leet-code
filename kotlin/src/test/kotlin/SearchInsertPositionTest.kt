import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData
import org.assertj.core.api.Assertions.assertThat

class SearchInsertPositionTest : FunSpec({
    context("check implementation") {
        withData(
            Triple(intArrayOf(1, 3, 5, 6), 5, 2),
            Triple(intArrayOf(1, 3, 5, 6), 2, 1),
            Triple(intArrayOf(1, 3, 5, 6), 3, 4),
            Triple(intArrayOf(1, 3, 5, 6), 0, 0)
        ) { tuple: Triple<IntArray, Int, Int> ->
            val result = SearchInsertPosition.searchInsert(tuple.first, tuple.second)
            assertThat(result == tuple.third)
        }
    }
})