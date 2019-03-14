fun computeMinesweeperValues(array: IntArray): IntArray {
    for (index in 0 until array.size) {
        if (isMine(array[index])) {
            incrementLeft(array, index)
            incrementRight(array, index)
        }
    }
    return array
}

fun incrementLeft(array: IntArray, actualIndex: Int) {
//    if (actualIndex != 0 && !isMine(array[actualIndex - 1]))
//        ++array[actualIndex - 1]

    if (!isActualIndexLeftEdge(actualIndex) && !isMine(array[actualIndex - 1]))
        ++array[actualIndex - 1]
}

fun incrementRight(array: IntArray, actualIndex: Int) {
//    if (actualIndex < array.size - 1 && !isMine(array[actualIndex + 1]))
//        ++array[actualIndex + 1]

    if (isActualIndexLessThenRightEdge(array, actualIndex) && !isMine(array[actualIndex + 1]))
        ++array[actualIndex + 1]
}

fun isMine(value: Int): Boolean {
    return value == 9
}

fun isActualIndexLeftEdge(index: Int): Boolean {
    return index == 0
}

fun isActualIndexLessThenRightEdge(array: IntArray, index: Int): Boolean {
    return index < array.size - 1
}