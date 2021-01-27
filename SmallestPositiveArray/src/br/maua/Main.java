package br.maua;

public class Main {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        int[] arr2 = {-1, -3};
        int[] arr3 = {1, 3, 6, 4, 1, 2};

        Solution solution = new Solution();

        System.out.println(solution.solution(arr));
        System.out.println(solution.solution(arr2));
        System.out.println(solution.solution(arr3));

        Solution2 solution2 = new Solution2();

        System.out.println("\n" + solution2.Solution2(arr));
        System.out.println(solution2.Solution2(arr2));
        System.out.println(solution2.Solution2(arr3));
    }
}
