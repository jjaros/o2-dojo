import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream
import kotlin.test.assertTrue


internal class MinesweeperTest {

    private val minesweeper: Minesweeper = Minesweeper()

    @ParameterizedTest(name = "{index}) input: {0} => expected={1}")
    @ArgumentsSource(OneDimensionMinesweeperTestArguments::class)
    fun `Test compute 1D Minesweeper array`(inputArray: IntArray, expectedArray: IntArray) {
        val computedValues = minesweeper.computeMinesweeperValues(inputArray)
        assertTrue(
            expectedArray contentEquals computedValues,
            "\nExpected values: ${arrayToString(expectedArray)}\nBut was compute: ${arrayToString(computedValues)}"
        )
    }

    @ParameterizedTest(name = "{index}) input: {0} => expected={1}")
    @ArgumentsSource(TwoDimensionMinesweeperTestArguments::class)
    fun `Test compute 2D Minesweeper array`(inputArray: Array<IntArray>, expectedArray: Array<IntArray>) {
        val computedValues = minesweeper.computeMinesweeperValues(inputArray)
        assertTrue(
            expectedArray contentDeepEquals computedValues,
            "\nExpected values: ${arrayToString(expectedArray)}\nBut was compute: ${arrayToString(computedValues)}"
        )
    }

    class OneDimensionMinesweeperTestArguments : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext): Stream<Arguments> {
            return Stream.of(
                Arguments.of(intArrayOf(), intArrayOf()),
                Arguments.of(intArrayOf(0, 9, 0), intArrayOf(1, 9, 1)),
                Arguments.of(intArrayOf(0, 9, 0, 0), intArrayOf(1, 9, 1, 0)),
                Arguments.of(intArrayOf(9, 0, 0, 0), intArrayOf(9, 1, 0, 0)),
                Arguments.of(intArrayOf(9, 0, 0, 9), intArrayOf(9, 1, 1, 9)),
                Arguments.of(intArrayOf(9, 0, 9), intArrayOf(9, 2, 9)),
                Arguments.of(intArrayOf(9, 0, 9, 0), intArrayOf(9, 2, 9, 1)),
                Arguments.of(intArrayOf(9, 9, 0), intArrayOf(9, 9, 1))
            )
        }
    }

    class TwoDimensionMinesweeperTestArguments : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext): Stream<Arguments> {
            return Stream.of(
                Arguments.of(arrayOf(intArrayOf(), intArrayOf()), arrayOf(intArrayOf(), intArrayOf())),
                Arguments.of(
                    arrayOf(
                        intArrayOf(0, 0),
                        intArrayOf(0, 0)
                    ), arrayOf(
                        intArrayOf(0, 0),
                        intArrayOf(0, 0)
                    )
                ),
                Arguments.of(
                    arrayOf(
                        intArrayOf(9, 0),
                        intArrayOf(0, 0)
                    ), arrayOf(
                        intArrayOf(9, 1),
                        intArrayOf(1, 1)
                    )
                ),
                Arguments.of(
                    arrayOf(
                        intArrayOf(0, 0),
                        intArrayOf(9, 0)
                    ), arrayOf(
                        intArrayOf(1, 1),
                        intArrayOf(9, 1)
                    )
                ),
                Arguments.of(
                    arrayOf(
                        intArrayOf(0, 9),
                        intArrayOf(0, 0)
                    ), arrayOf(
                        intArrayOf(1, 9),
                        intArrayOf(1, 1)
                    )
                ),
                Arguments.of(
                    arrayOf(
                        intArrayOf(0, 0),
                        intArrayOf(9, 9)
                    ), arrayOf(
                        intArrayOf(2, 2),
                        intArrayOf(9, 9)
                    )
                ),
                Arguments.of(
                    arrayOf(
                        intArrayOf(9, 9),
                        intArrayOf(0, 0)
                    ), arrayOf(
                        intArrayOf(9, 9),
                        intArrayOf(2, 2)
                    )
                ),
                Arguments.of(
                    arrayOf(
                        intArrayOf(0, 9),
                        intArrayOf(9, 0)
                    ), arrayOf(
                        intArrayOf(2, 9),
                        intArrayOf(9, 2)
                    )
                ),
                Arguments.of(
                    arrayOf(
                        intArrayOf(9, 0),
                        intArrayOf(9, 0)
                    ), arrayOf(
                        intArrayOf(9, 2),
                        intArrayOf(9, 2)
                    )
                ),
                Arguments.of(
                    arrayOf(
                        intArrayOf(0, 9),
                        intArrayOf(0, 9)
                    ), arrayOf(
                        intArrayOf(2, 9),
                        intArrayOf(2, 9)
                    )
                ),
                Arguments.of(
                    arrayOf(
                        intArrayOf(0, 9),
                        intArrayOf(9, 9)
                    ), arrayOf(
                        intArrayOf(3, 9),
                        intArrayOf(9, 9)
                    )
                ),
                Arguments.of(
                    arrayOf(
                        intArrayOf(9, 0, 9),
                        intArrayOf(9, 9, 0)
                    ),
                    arrayOf(
                        intArrayOf(9, 4, 9),
                        intArrayOf(9, 9, 2)
                    )
                ),
                Arguments.of(
                    arrayOf(
                        intArrayOf(0, 0, 9),
                        intArrayOf(9, 9, 9),
                        intArrayOf(0, 9, 0)
                    ), arrayOf(
                        intArrayOf(2, 4, 9),
                        intArrayOf(9, 9, 9),
                        intArrayOf(3, 9, 3)
                    )
                ),
                Arguments.of(
                    arrayOf(
                        intArrayOf(0, 0, 9, 0, 9),
                        intArrayOf(9, 9, 0, 0, 9),
                        intArrayOf(0, 9, 0, 9, 0),
                        intArrayOf(0, 0, 0, 0, 0)
                    ), arrayOf(
                        intArrayOf(2, 3, 9, 3, 9),
                        intArrayOf(9, 9, 4, 4, 9),
                        intArrayOf(3, 9, 3, 9, 2),
                        intArrayOf(1, 1, 2, 1, 1)
                    )
                ),
                Arguments.of(
                    arrayOf(
                        intArrayOf(0, 9, 0, 9, 0),
                        intArrayOf(0, 0, 9, 0, 0),
                        intArrayOf(0, 0, 0, 0, 0),
                        intArrayOf(0, 0, 0, 0, 0)
                    ), arrayOf(
                        intArrayOf(1, 9, 3, 9, 1),
                        intArrayOf(1, 2, 9, 2, 1),
                        intArrayOf(0, 1, 1, 1, 0),
                        intArrayOf(0, 0, 0, 0, 0)
                    )
                )
            )
        }
    }

    private fun arrayToString(array: IntArray): String {
        return array.joinToString(", ", "[", "]")
    }

    private fun arrayToString(array: Array<IntArray>): String {
        var result = "\n"
        for (intArray in array) {
            result += "${intArray.joinToString(", ", "[", "]")}\n"
        }
        return result
    }
}