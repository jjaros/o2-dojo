
internal class SieveOfEratosthenes {

    fun findPrimeNumbers(maxRange: Int): List<Int> {
        val primeNumbers = mutableListOf<Int>()
        // generate range
        val baseData = (2..maxRange).map { it -> SieveOfEratosthenesNumber(it) }

        // find prime numbers
        baseData.forEachIndexed { actualIndex, soeNumber ->
            if (soeNumber.isNotPrimeNumber) {
                primeNumbers.add(soeNumber.value)
                // mark non-prime numbers
                (actualIndex until baseData.size)
                    .filter { i -> baseData[i].value % soeNumber.value == 0 }
                    .forEach { i -> baseData[i].isNotPrimeNumber = false }
            }
        }
        return primeNumbers
    }

    private data class SieveOfEratosthenesNumber(val value: Int, var isNotPrimeNumber: Boolean = true)
}
