package br.maua;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetExample {
    public static void main(String agrs[]) {

        Integer[] arr = {22, 45, 33, 66, 55, 34, 77};
        Integer[] arr2 = {33, 2, 83, 45, 3, 12, 55};

        Set<Integer> set1 = new HashSet<Integer>();
        set1.addAll(Arrays.asList(arr));

        Set<Integer> set2 = new HashSet<Integer>();
        set2.addAll(Arrays.asList(arr2));

        // Finding Union of set1 and set2
        Set<Integer> union = new HashSet<Integer>(set1);
        union.addAll(set2);
        System.out.println("Union of set1 and set2 is: ");
        System.out.println(union);
    }
}
