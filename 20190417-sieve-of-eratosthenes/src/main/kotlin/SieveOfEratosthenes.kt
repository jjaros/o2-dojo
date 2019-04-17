internal class SieveOfEratosthenes {
    fun findPrimeNumbers(maxRange: Int): List<Int> {
        val primeNumbers = mutableListOf<Int>()
        // generate range
        val baseData = mutableListOf<SieveOfEratosthenesNumber>()
        for (i in 2..maxRange) {
            baseData.add(
                SieveOfEratosthenesNumber(i)
            )
        }
        // find print numbers
        baseData.forEachIndexed { index, sieveOfEratosthenesNumber ->
            if (!sieveOfEratosthenesNumber.isNotPrimeNumber) {
                primeNumbers.add(sieveOfEratosthenesNumber.value)
                // mark NOT prime numbers
                for (i in index..(baseData.size - 1)) {
                    if (baseData[i].value % sieveOfEratosthenesNumber.value == 0) {
                        baseData[i].isNotPrimeNumber = true
                    }
                }
            }
        }
        return primeNumbers
    }

    private data class SieveOfEratosthenesNumber(val value: Int, var isNotPrimeNumber: Boolean = false)
}
