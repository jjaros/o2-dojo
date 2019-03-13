import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.test.assertTrue


internal class MinesweeperTest {

    @Test
    @DisplayName("Test get empty array.")
    fun testGetEmptyArray() {
        val inputArray: IntArray = intArrayOf()
        val expectedArray: IntArray = intArrayOf()
        assertTrue { expectedArray contentEquals computeMinesweeperValues(inputArray) }
    }

    @Test
    @DisplayName("Test change minesweeper values.")
    fun testChangeValues() {
        val inputArray: IntArray = intArrayOf(0, 9, 0)
        val expectedArray: IntArray = intArrayOf(1, 9, 1)
        assertTrue { expectedArray contentEquals computeMinesweeperValues(inputArray) }
    }

    @Test
    @DisplayName("Test compute minesweeper values")
    fun testComputeValues() {
        val inputArray: IntArray = intArrayOf(0, 9, 0, 0)
        val expectedArray: IntArray = intArrayOf(1, 9, 1, 0)
        assertTrue { expectedArray contentEquals computeMinesweeperValues(inputArray) }
    }

    @Test
    @DisplayName("Test compute left edge minesweeper values")
    fun testComputeLeftEdgeValues() {
        val inputArray: IntArray = intArrayOf(9, 0, 0, 0)
        val expectedArray: IntArray = intArrayOf(9, 1, 0, 0)
        assertTrue { expectedArray contentEquals computeMinesweeperValues(inputArray) }
    }

    @Test
    @DisplayName("Test compute right edge minesweeper values")
    fun testComputeRightEdgeValues() {
        val inputArray: IntArray = intArrayOf(9, 0, 0, 9)
        val expectedArray: IntArray = intArrayOf(9, 1, 1, 9)
        assertTrue { expectedArray contentEquals computeMinesweeperValues(inputArray) }
    }

    @Test
    @DisplayName("Test compute middle minesweeper values")
    fun testComputeMiddleValues() {
        val inputArray: IntArray = intArrayOf(9, 0, 9)
        val expectedArray: IntArray = intArrayOf(9, 2, 9)
        assertTrue { expectedArray contentEquals computeMinesweeperValues(inputArray) }
    }

    @Test
    @DisplayName("Test compute all values")
    fun testComputeAllValues() {
        val inputArray: IntArray = intArrayOf(9, 0, 9, 0)
        val expectedArray: IntArray = intArrayOf(9, 2, 9, 1)
        assertTrue { expectedArray contentEquals computeMinesweeperValues(inputArray) }
    }

    @Test
    @DisplayName("Test compute all values which two mines are neighbor")
    fun testComputeTwoMinesNeighbor() {
        val inputArray: IntArray = intArrayOf(9, 9, 0)
        val expectedArray: IntArray = intArrayOf(9, 9, 1)
        assertTrue { expectedArray contentEquals computeMinesweeperValues(inputArray) }
    }

}