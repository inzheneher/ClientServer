package com.mav;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class LocalPrimeFactorizerTest {

    private LocalPrimeFactorizer primeFactorizer = new LocalPrimeFactorizer();

    private Set<Integer> list(int... factors){
        Set<Integer> listOfFactors = new HashSet<>();

        for(int i : factors){
            listOfFactors.add(i);
        }
        return listOfFactors;
    }

    @Test
    public void testOne() {
        assertEquals(list(), primeFactorizer.factorize(1));
    }

    @Test
    public void testTwo() {
        assertEquals(list(2), primeFactorizer.factorize(2));
    }

    @Test
    public void testThree() {
        assertEquals(list(3), primeFactorizer.factorize(3));
    }

    @Test
    public void testFour() {
        assertEquals(list(2), primeFactorizer.factorize(4));
    }

    @Test
    public void testSeventyTwo() {
        assertEquals(list(2,3), primeFactorizer.factorize(72));
    }
}
