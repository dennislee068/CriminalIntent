package com.bignerdranch.android.criminalintent;

public class CrimeComparator implements java.util.Comparator<Crime> {

    @Override
    public int compare(Crime lhs, Crime rhs) {
        if (!lhs.isSolved() && rhs.isSolved()){
            return -1;
        }
        return 0;
    }
}
