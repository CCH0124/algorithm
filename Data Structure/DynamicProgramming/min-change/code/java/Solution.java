import java.util.List;
import java.util.HashMap;

public class Solution {
    public static int minChange(int amount, List<Integer> coins) {
        return minChange(amount, coins, new HashMap<>());
    }

    public static int minChange(int amount, List<Integer> coins, HashMap<Integer, Integer> memo) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }

        if (memo.containsKey(amount)) return memo.get(amount);

        int minCoins = -1;
        for (int coin : coins) {
            int sub = amount - coin;
            int subCoin = minChange(sub, coins, memo);
            if (subCoin != -1) {
                int numCoin = subCoin + 1;
                if (minCoins == -1 || numCoin < minCoins) {
                    minCoins = numCoin;
                }
            }
        }

        memo.put(amount, minCoins);

        return minCoins;
    }
    public static void main(String[] args) {
        int minChange1 = minChange(4, List.of(1, 2, 3));;
        System.out.println("amount 4 : " + minChange1);
        int minChange2 = minChange(5, List.of(1, 2, 3));
        System.out.println("amount 5 : " + minChange2);
        int minChange3 = minChange(28, List.of(1, 5, 10));
        System.out.println("amount 28 : " + minChange3);
    }    
}
