internal class Minesweeper {

    fun computeMinesweeperValues(array: IntArray): IntArray {
        for (index in 0 until array.size) {
            if (isMine(array[index])) {
                incrementLeft(array, index)
                incrementRight(array, index)
            }
        }
        return array
    }

    fun computeMinesweeperValues(array: Array<IntArray>): Array<IntArray> {
        for (index in 0 until array.size) {
            for (index2 in 0 until array[index].size) {
                if (isMine(array[index][index2])) {
                    incrementLeft(array[index], index2)
                    incrementRight(array[index], index2)
                    if (isValidIndex(index + 1, array.size)) {
                        incrementOtherRow(array[index + 1], index2)
                    }
                    if (isValidIndex(index - 1, array.size)) {
                        incrementOtherRow(array[index - 1], index2)
                    }
                }
            }
        }
        return array
    }

    private fun isValidIndex(actualIndex: Int, arraySize: Int): Boolean {
        return actualIndex in 0..(arraySize - 1)
    }

    private fun incrementLeft(array: IntArray, actualIndex: Int) {
        if (isValidIndex(actualIndex - 1, array.size) && !isMine(array[actualIndex - 1]))
            ++array[actualIndex - 1]
    }

    private fun incrementRight(array: IntArray, actualIndex: Int) {
        if (isValidIndex(actualIndex + 1, array.size) && !isMine(array[actualIndex + 1]))
            ++array[actualIndex + 1]
    }

    private fun incrementOtherRow(array: IntArray, actualIndex: Int) {
        if (!isMine(array[actualIndex])) {
            ++array[actualIndex]
        }
        incrementLeft(array, actualIndex)
        incrementRight(array, actualIndex)
    }

    private fun isMine(value: Int): Boolean {
        return value == 9
    }
}