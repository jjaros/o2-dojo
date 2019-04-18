import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream
import kotlin.test.assertEquals

internal class SieveOfEratosthenesTest {

    private val sieveOfEratosthenes = SieveOfEratosthenes()

    @ParameterizedTest(name = "{index}) maxRange: {0} => expectedPrimes={1}")
    @ArgumentsSource(SieveOfEratosthenesTestArguments::class)
    fun `Test find prime numbers using Sieve of Eratosthenes`(inputMaxRange: Int, expectedPrimeNumbers: List<Int>) {
        assertEquals(expectedPrimeNumbers, sieveOfEratosthenes.findPrimeNumbers(inputMaxRange))
    }

    class SieveOfEratosthenesTestArguments : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext): Stream<Arguments>? {
            return Stream.of(
                Arguments.of(2, listOf(2)),
                Arguments.of(3, listOf(2, 3)),
                Arguments.of(4, listOf(2, 3)),
                Arguments.of(5, listOf(2, 3, 5)),
                Arguments.of(6, listOf(2, 3, 5)),
                Arguments.of(7, listOf(2, 3, 5, 7)),
                Arguments.of(8, listOf(2, 3, 5, 7)),
                Arguments.of(9, listOf(2, 3, 5, 7)),
                Arguments.of(10, listOf(2, 3, 5, 7)),
                Arguments.of(11, listOf(2, 3, 5, 7, 11)),
                Arguments.of(12, listOf(2, 3, 5, 7, 11)),
                Arguments.of(13, listOf(2, 3, 5, 7, 11, 13)),
                Arguments.of(14, listOf(2, 3, 5, 7, 11, 13)),
                Arguments.of(15, listOf(2, 3, 5, 7, 11, 13)),
                Arguments.of(16, listOf(2, 3, 5, 7, 11, 13)),
                Arguments.of(17, listOf(2, 3, 5, 7, 11, 13, 17)),
                Arguments.of(18, listOf(2, 3, 5, 7, 11, 13, 17)),
                Arguments.of(19, listOf(2, 3, 5, 7, 11, 13, 17, 19)),
                Arguments.of(20, listOf(2, 3, 5, 7, 11, 13, 17, 19))
            )
        }
    }
}
