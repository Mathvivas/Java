package br.maua;

public class Solve {
    public int solve(int[] arr) {
        if ( arr.length == 1 ) return 1;

        int even = arr[0];
        int odd = arr[1];
        int start = 0;
        int maxLen = 0;

        for ( int i = 2; i < arr.length; ++i ) {

            if ( (i % 2 == 0 && arr[i] != even) || (i % 2 == 1 && arr[i] != odd) ) {
                maxLen = Math.max(maxLen, i - start);
                start = i - 1;
                if ( i % 2 == 0 ) {
                    even = arr[i];
                    odd = arr[i - 1];
                } else {
                    even = arr[i - 1];
                    odd = arr[i];
                }
            }
        }

        return Math.max(maxLen, arr.length - start);
    }
}