import java.util.List;
import java.util.HashMap;

public class Solution {
    public static boolean sumPossible(int amount, List<Integer> numbers) {
        return sumPossible(amount, numbers, new HashMap<>());
    }

    public static boolean sumPossible(int amount, List<Integer> numbers, HashMap<Integer, Boolean> memo) {
        if (amount == 0) return true;
        if (amount < 0) return false;
        if (memo.containsKey(amount)) return memo.get(amount);
        for(int num : numbers) {
            int sub = amount - num;
            if(sumPossible(sub, numbers, memo)) {
                memo.put(amount, true);
                return true;
            }
        }

        memo.put(amount, false);

        return false;
    }
    public static void main(String[] args) {
        boolean sumPossible = sumPossible(4, List.of(1, 2, 3));;
        System.out.println("amount 4: " + sumPossible);
        boolean sumPossible2 = sumPossible(15, List.of(4, 6, 10));
        System.out.println("amount 15: " + sumPossible2);
    }
}
