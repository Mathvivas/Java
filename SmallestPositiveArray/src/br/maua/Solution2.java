package br.maua;

import java.util.Arrays;

public class Solution2 {

    public int Solution2(int[] arr) {
        Arrays.sort(arr);
        int min = 1;
        int cap = arr.length;

        for ( int i = 0; i < cap; i++ ) {
            if ( arr[i] == min ) {
                min++;
            }
        }

        return min;
    }
}
