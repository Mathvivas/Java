package br.maua;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public int solution(int[] arr) {
        int n = arr.length;
        // Set interface extends the Collection interface. An unordered collection or
        // list in which duplicates are not allowed.
        Set<Integer> set = new HashSet<>();

        for ( int item : arr ) {
            if (item > 0) {
                set.add(item);
            }
        }

        for ( int i = 1; i <= n; i++ ) {
            if ( !set.contains(i) ) {
                return i;
            }
        }
        return (n + 1);
    }
}
