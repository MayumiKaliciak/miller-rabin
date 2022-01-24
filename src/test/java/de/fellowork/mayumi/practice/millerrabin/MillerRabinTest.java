package de.fellowork.mayumi.practice.millerrabin;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class MillerRabinTest {

    private final MillerRabin lookForPrime = new MillerRabin();

    @ParameterizedTest
    @ValueSource (ints = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199})
    void detectPrimeNumbers(Integer primeCandidate) {
        boolean isPrime = lookForPrime.isPrimeNumber(primeCandidate, 3);
        assertThat(isPrime).isTrue();
    }

    @ParameterizedTest
    @ValueSource (ints = {0, 1})
    void onlyZeroAndOne(Integer primeCandidate) {
        boolean isPrime = lookForPrime.isPrimeNumber(primeCandidate, 3);
        assertThat(isPrime).isFalse();
    }

    @ParameterizedTest
    @ValueSource (ints = {4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36, 38, 40, 42, 44, 46, 48, 50, 52, 54, 56, 58, 60, 62, 64, 66, 68, 70, 72, 74, 76, 78, 80, 82, 84, 86, 88, 90, 92, 94, 96, 98, 100, 110, 120, 130, 300, 500, 550 })
    void allEvenNumbers(Integer primeCandidate) {
        boolean isPrime = lookForPrime.isPrimeNumber(primeCandidate, 3);
        assertThat(isPrime).isFalse();
        }

    @ParameterizedTest
    @ValueSource (ints = {-111, -110, -109, -108, -107, -106, -105, -104, -103, -102, -101, -100, -97, -67, -50, -41, -31, -30, -19, -7, -5, -3, -2, -1})
    void allNegativeNumbers(Integer primeCandidate) {
        boolean isPrime = lookForPrime.isPrimeNumber(primeCandidate, 3);
        assertThat(isPrime).isFalse();
    }

    @ParameterizedTest
    @ValueSource (ints = {9, 15, 21, 25, 27, 33 ,35, 45, 49, 51, 55, 57, 63, 65, 69, 75, 77, 81, 85, 87, 91, 93, 95, 99, 105, 155, 177, 195})
    void allOddNumbersNotPrime(Integer primeCandidate) {
        boolean isPrime = lookForPrime.isPrimeNumber(primeCandidate, 3);
        assertThat(isPrime).isFalse();
    }

    @ParameterizedTest
    @ValueSource (ints = {561, 1105, 1729})
    void carMichaelNumbers(Integer primeCandidate) {
        boolean isPrime = lookForPrime.isPrimeNumber(primeCandidate, 5);
        assertThat(isPrime).isFalse();
    }

    @ParameterizedTest
    @ValueSource (ints = {221})
    void number221(Integer primeCandidate) {
        boolean isPrime = lookForPrime.isPrimeNumber(primeCandidate, 1000);
        assertThat(isPrime).isFalse();
    }

}
