package de.fellowork.mayumi.practice.millerrabin;

import java.math.BigInteger;
import java.util.Random;

public class MillerRabin {

    /**
     * find out if input is prime number
     *
     * @return randomNumber if it is detected as primeNumber
     */

    public boolean isPrimeNumber(int primeCandidate, int checkIterations) {

        if (primeCandidateIsPerDefinitionNotPrime(primeCandidate)) {
            return false;
        }
        if (primeCandidateIsPerDefinitionPrime(primeCandidate)) {
            return true;
        }
        if (primeCandidateIsEven(primeCandidate)) {
            return false;
        }
        return doMillerRabinTest(primeCandidate, checkIterations);

    }

    private boolean primeCandidateIsPerDefinitionNotPrime(int primeCandidate) {
        return primeCandidate < 2;
    }

    private boolean primeCandidateIsPerDefinitionPrime(int primeCandidate) {
        return primeCandidate == 2 || primeCandidate == 3;
    }

    private boolean primeCandidateIsEven(int primeCandidate) {
        return primeCandidate % 2 == 0;
    }

    private boolean doMillerRabinTest(int primeCandidate, int checkIterations) {

        for (int i = 0; i < checkIterations; i++) {

            MillerRabinExponent exponent = calculateExponents(primeCandidate);
            int randomChecker = createRandomChecker(primeCandidate);
            boolean isPrime = false;

            for (int numberOfExponents = 0; numberOfExponents < exponent.getExponentIterations(); numberOfExponents++) {

                int resultToCheck = createResultToCheck(primeCandidate, exponent.getExponent(), randomChecker);
                isPrime = isProbablyPrime(resultToCheck, primeCandidate);

                if (firstResultToCheckIsOne(numberOfExponents, resultToCheck)) {
                    return true;
                }
                if (isPrime) {
                    break;
                }
                exponent.multiplyExponent(2);
            }
            if (!isPrime) {
                return false;
            }
        }
        return true;
    }

    public MillerRabinExponent calculateExponents(int primeCandidate) {

        int exponent = primeCandidate - 1;
        int exponentIterations = 0;

        while (exponentIsEven(exponent)) {
            exponent = exponent / 2;
            exponentIterations += 1;
        }
        return new MillerRabinExponent(exponent, exponentIterations);
    }

    private boolean exponentIsEven(int exponent) {
        return exponent % 2 == 0;
    }

    public int createRandomChecker(int primeCandidate) {

        Random random = new Random();
        return random.nextInt(2, primeCandidate - 2);
    }

    public int createResultToCheck(int primeCandidate, int exponent, int randomCheckNumber) {

        BigInteger valueOfPrimeCandidate = BigInteger.valueOf(primeCandidate);
        BigInteger valueOfRandomCheckNumber = BigInteger.valueOf(randomCheckNumber);

        return valueOfRandomCheckNumber.pow(exponent)
                .mod(valueOfPrimeCandidate)
                .intValue();
    }

    private boolean isProbablyPrime(int resultToCheck, int primeCandidate) {
        return resultToCheck == primeCandidate - 1;
    }

    private boolean firstResultToCheckIsOne(int j, int resultToCheck) {
        return resultToCheck == 1 && j == 0;
    }


}
