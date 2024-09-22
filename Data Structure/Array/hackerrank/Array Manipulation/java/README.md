```java
// Complete the arrayManipulation function below.
    static long arrayManipulation(int n, int[][] queries) {
        long [] arr = new long[n];
        for(int i=0; i<queries.length; i++){
            int a = queries[i][0];
            int b = queries[i][1];
            long k = queries[i][2];
            arr[a-1] += k;
            if (b < n) {
                arr[b] -= k;
            }
        }
        for (int i=1; i<arr.length; i++){
            arr[i] = arr[i-1] + arr[i]; 
        }
        return Arrays.stream(arr).max().getAsLong();
        // return 0;
    }

```
