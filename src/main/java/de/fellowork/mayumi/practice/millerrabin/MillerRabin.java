package de.fellowork.mayumi.practice.millerrabin;

import java.util.Random;

public class MillerRabin {

    /**
     * find out if input (scanned) is prime number
     *
     * @return randomNumber if it is detected as primeNumber
     */


    public boolean isPrimeNumber() {
        //GetUserInput checkIfPrime = new GetUserInput();

        int randomNumber= getRandomNumberToCheckIfPrime();

        int d = randomNumber - 1;
        int counter = 0;

        while (d % 2 == 0) {
            d = d / 2;
            counter++;

            Random random = new Random();
            int checker = random.nextInt(2, randomNumber - 1);
            int x = (int) ((Math.pow(checker, d)) % randomNumber);

            if (x == 1 || x == (randomNumber - 1)) {
                return true;
            }
            while (counter > 1) {
                x = (x * x) % randomNumber;
                if (x == 1) {
                    return false;
                } else if (x == (randomNumber - 1)) {
                    return true;
                }
                counter--;
            }

        }
        return false;
    }

    public int getRandomNumberToCheckIfPrime() {
        Random random = new Random();
        int randomNumber = random.nextInt(2, 200);
        return randomNumber;
    }
}

