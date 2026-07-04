```java
class Result {

    /*
     * Complete the 'countSwaps' function below.
     *
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static void countSwaps(List<Integer> a) {
    // Write your code here
        int count = 0;
        for(int i=0; i<a.size(); i++) {
            for (int j=0; j<a.size()-1; j++) {
                if (a.get(j) > a.get(j+1)) {
                    int temp = a.get(j+1);
                    a.set(j+1, a.get(j));
                    a.set(j, temp);
                    count++;
                }
            }
        }
        System.out.printf("Array is sorted in %d swaps.\n", count);
        System.out.printf("First Element: %d\n", a.get(0));
        System.out.printf("Last Element: %d\n", a.get(a.size()-1));
    }

}
```
