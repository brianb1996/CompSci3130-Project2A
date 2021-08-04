package edu.umsl.algorithms;

import java.util.Random;
import java.lang.Math;
import java.math.BigInteger;
import java.lang.*;

public class Main{
    public static void main(String[] args){
        PrimeFactorization prime = new PrimeFactorization();
        prime.factor();

    }
}

class PrimeFactorization {
    Random rand;                //Used to create instance of Random class
    BigInteger largeInt;        //Used to store large integer number
    final int SIZE = 100;       //Used to hold to number of digits in the integer
    final BigInteger lowerBound = new BigInteger("1000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000");
    final BigInteger upperBound = new BigInteger("9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999");
    final BigInteger zero = new BigInteger("0");
    final BigInteger one = new BigInteger("1");
    final BigInteger two = new BigInteger("2");

    public PrimeFactorization(){
        this.rand = new Random();
        do {
            this.largeInt = new BigInteger(333, this.rand);
        }while(this.largeInt.compareTo(lowerBound) == -1 || this.largeInt.compareTo(upperBound) == 1);
    }

    public void factor(){
        BigInteger currInt = new BigInteger(largeInt.toByteArray());
        BigInteger currPrime = new BigInteger(two.toByteArray());
        if (currInt.mod(currPrime).compareTo(zero) == 0) {
            System.out.print(currPrime + ", ");
            currInt = currInt.divide(currPrime);
        }
        currPrime = currPrime.add(one);

        do {
            if (currInt.mod(currPrime).compareTo(zero) == 0) {
                System.out.print(currPrime + ", ");
                currInt = currInt.divide(currPrime);
            } else {
                currPrime = currPrime.add(two);
            }
        }while(currInt.compareTo(one)!=0);

    }


}
