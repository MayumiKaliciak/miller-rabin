package de.fellowork.mayumi.practice.millerrabin;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

public class MillerRabinTest {
    @Test
    void detectPrimeNumbersTo200() {
        MillerRabin lookForPrime = new MillerRabin();

        boolean isPrime = lookForPrime.isPrimeNumber();
        if (isPrime) {
            int numberToCheck = lookForPrime.getRandomNumberToCheckIfPrime();

            assertThat(numberToCheck).isNotNull();
            assertThat(numberToCheck).isNotEqualTo(200);


            List<Integer> AllPrimeNumbersTo200 = List.of(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199);
            assertThat(AllPrimeNumbersTo200).contains(numberToCheck);


        }
    }

}
