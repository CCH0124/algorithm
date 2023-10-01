import java.util.HashMap;

class Fibonacci {
    public static int fib(int n) {
        return fib(n, new HashMap<>());
    }

    public static int fib(int n, HashMap<Integer, Integer> memo) {
        // base case
        if ( n == 0 || n == 1) {
            return n;
        }
        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        int res = fib(n-1, memo) + fib(n-2, memo);
        memo.put(n, res);

        return res;
    }

    public static void main(String[] args) {
        System.out.println("fib(10): " + fib(10));
        System.out.println("fib(40): " + fib(40));
        System.out.println("fib(60): " + fib(60));
        // fib(10): 55
        // fib(40): 102334155
        // fib(60): 1820529360
    }
}