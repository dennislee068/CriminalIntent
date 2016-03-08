package com.bignerdranch.android.criminalintent;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class CrimeComparatorTest {
    private Comparator<Crime> comparator;

    private List<Crime> unsolvedCrimes, solvedCrimes, crimes;

    @Before
    public void setup(){
        comparator = new CrimeComparator();
        unsolvedCrimes = new ArrayList<>();
        solvedCrimes = new ArrayList<>();
        crimes = new ArrayList<>();
        for (boolean solved : new boolean[] {false, true}) {
            for (long time : new long[]{1000000000L, 1L, 0L}){
                Crime c = new Crime();
                c.setDate(new Date(time));
                c.setSolved(solved);
                crimes.add(c);
                (solved ? solvedCrimes : unsolvedCrimes).add(c);
            }
        }
    }
    @Test
    public void reflexive() {
        for (Crime c : crimes) {
            assertEquals(0, comparator.compare(c, c));
        }
    }

    @Test
    public void unsolvedBeforeSolved() {
        for (Crime u : unsolvedCrimes) {
            for (Crime s : solvedCrimes) {
                assertTrue(comparator.compare(u,s) < 0);
            }
        }
    }
}
