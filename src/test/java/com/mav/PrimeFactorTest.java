package com.mav;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;


public class PrimeFactorTest {

    private Set list(int... factors){
        Set listOfFactors = new HashSet();

        for(int i : factors){
            listOfFactors.add(i);
        }
        return listOfFactors;
    }

    @Test
    public void testOne() {
        assertEquals(list(), Client.primeFactors(1));
    }

    @Test
    public void testTwo() {
        assertEquals(list(2), Client.primeFactors(2));
    }

    @Test
    public void testThree() {
        assertEquals(list(3), Client.primeFactors(3));
    }

    @Test
    public void testFour() {
        assertEquals(list(2), Client.primeFactors(4));
    }

    @Test
    public void testSeventyTwo() {
        assertEquals(list(2,3), Client.primeFactors(72));
    }
}