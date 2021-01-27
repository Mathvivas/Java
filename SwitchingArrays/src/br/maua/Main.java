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
        int[] arr = {3, 7, 3, 7, 2, 1, 2};
        int[] arr2 = {2, 4, 2, 4};
        int[] arr3 = {5, 5, 5, 5, 5};
        int[] arr4 = {1, 2, 3, 4, 5};

        Solve solve = new Solve();

        System.out.println(solve.solve(arr));
        System.out.println("\n" + solve.solve(arr2));
        System.out.println("\n" + solve.solve(arr3));
        System.out.println("\n" + solve.solve(arr4));

    }
}
