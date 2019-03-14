import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream
import kotlin.test.assertTrue

internal class MinesweeperTest {

    @DisplayName("Test compute Minesweeper values.")
    @ParameterizedTest(name = "{index}) input: {0} => expected={1}")
    @ArgumentsSource(MinesweeperTestArguments::class)
    fun testComputeMinesweeperValues(inputArray: IntArray, expectedArray: IntArray) {
        val computedValues = Minesweeper().computeValues(inputArray)
        assertTrue(expectedArray contentEquals computedValues,
            "\nExpected values: `${arrayToString(expectedArray)}`\nBut was compute: `${arrayToString(computedValues)}`")
    }

    class MinesweeperTestArguments : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<Arguments> {
            return Stream.of(
                Arguments.of(intArrayOf(), intArrayOf()),
                Arguments.of(intArrayOf(0, 9, 0), intArrayOf(1, 9, 1)),
                Arguments.of(intArrayOf(0, 9, 0, 0), intArrayOf(1, 9, 1, 0)),
                Arguments.of(intArrayOf(9, 0, 0, 0), intArrayOf(9, 1, 0, 0)),
                Arguments.of(intArrayOf(0, 0, 0, 9), intArrayOf(0, 0, 1, 9)),
                Arguments.of(intArrayOf(9, 0, 0, 9), intArrayOf(9, 1, 1, 9)),
                Arguments.of(intArrayOf(9, 0, 9), intArrayOf(9, 2, 9)),
                Arguments.of(intArrayOf(9, 0, 9, 0), intArrayOf(9, 2, 9, 1)),
                Arguments.of(intArrayOf(9, 9, 0), intArrayOf(9, 9, 1))
            )
        }
    }

    private fun arrayToString(array: IntArray): String {
        return array.joinToString(", ", "[", "]")
    }
}