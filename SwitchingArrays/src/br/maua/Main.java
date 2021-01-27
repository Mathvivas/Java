package br.maua;

/*
An array is called "switching" if the odd and even elements are equal.

Example:

[2,4,2,4] is a switching array because the members in even positions (indexes 0 and 2) and odd positions (indexes 1 and 3) are equal.

If A = [3,7,3,7, 2, 1, 2], the switching sub-arrays are:

== > [3,7,3,7] and [2,1,2]

Therefore, the longest switching sub-array is [3,7,3,7] with length = 4.

As another example if A = [1,5,6,0,1,0], the the only switching sub-array is [0,1,0].

Another example: A= [7,-5,-5,-5,7,-1,7], the switching sub-arrays are [7,-1,7] and [-5,-5,-5].
 */

public class Main {

    public static void main(String[] args) {

    }

    public int Solve(int[] arr) {
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
