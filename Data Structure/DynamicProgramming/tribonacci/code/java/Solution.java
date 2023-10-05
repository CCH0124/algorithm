package DynamicProgramming.tribonacci.code.java;
import java.util.HashMap;

public class Solution {

    public static int tribonacci(int n) {
        return tribonacci(n, new HashMap<>());
    }

    public static int tribonacci(int n, HashMap<Integer, Integer> memo) {
        if (n == 0 || n == 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }

        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        int res = tribonacci(n - 3, memo) + tribonacci(n - 2, memo) + tribonacci(n - 1, memo);

        memo.put(n, res);

        return res;
    }

    public static void main(String[] args) {
        System.out.println("trib(5) = " + tribonacci(5));
        System.out.println("trib(8) = " + tribonacci(8));
        System.out.println("trib(20) = " + tribonacci(20));
    }
    
}
