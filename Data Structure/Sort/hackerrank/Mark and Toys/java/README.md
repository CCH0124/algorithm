```java
class Result {

    /*
     * Complete the 'maximumToys' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY prices
     *  2. INTEGER k
     */

    public static int maximumToys(List<Integer> prices, int k) {
    // Write your code here
        Collections.sort(prices);
        int count = 0;
        for (int i=0; i<prices.size(); i++) {
            if (k > 0) {
                k-=prices.get(i);
                if (k >0){
                    count++;
                    }
            } else {
                break;
            }
        }
        
        return count;
    }

}
```
