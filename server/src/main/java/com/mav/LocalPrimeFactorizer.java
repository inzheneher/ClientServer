package com.mav;

import java.util.HashSet;
import java.util.Set;

class LocalPrimeFactorizer implements PrimeFactorizer {

    @Override
    public Set<Integer> factorize(Integer numberToFactorize) {
        Set<Integer> primefactors = new HashSet<>();
        long copyOfInput = numberToFactorize;

        for (int i = 2; i <= copyOfInput; i++) {
            if (copyOfInput % i == 0) {
                primefactors.add(i);
                copyOfInput /= i;
                i--;
            }
        }
        return primefactors;
    }
}
