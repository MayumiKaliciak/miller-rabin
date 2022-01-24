package de.fellowork.mayumi.practice.millerrabin;

public class MillerRabinExponent {

   private int exponent;
   private final int exponentIterations;

    public MillerRabinExponent(int exponent, int exponentIterations) {
        this.exponent = exponent;
        this.exponentIterations = exponentIterations;
    }

    public int getExponent() {
        return exponent;
    }

    public int getExponentIterations() {
        return exponentIterations;
    }

    public void multiplyExponent(int factor) {
        this.exponent *= factor;
    }
}
