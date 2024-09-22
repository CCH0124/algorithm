```java
class Result {

    /*
     * Complete the 'hourglassSum' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY arr as parameter.
     */

    public static int hourglassSum(List<List<Integer>> arr) {
    // Write your code here
        int max = -9 * 7;
        for (int i=0; i<arr.size()-2;i++) {
            for (int j=0; j<arr.size()-2; j++) {
                int top = arr.get(i).get(j) + arr.get(i).get(j+1) + arr.get(i).get(j+2);
                int middle = arr.get(i+1).get(j+1);
                int bottom = arr.get(i+2).get(j) + arr.get(i+2).get(j+1) + arr.get(i+2).get(j+2);
                max = Math.max(max, top + middle + bottom);
            }
        }
        
        return max;
    }

}

```
