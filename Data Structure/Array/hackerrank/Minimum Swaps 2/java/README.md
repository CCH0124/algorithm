```java
// Complete the minimumSwaps function below.
    static int minimumSwaps(int[] arr) {
        int res = 0;
        for(int i=0; i<arr.length; i++) {
            int target = i + 1;
            if (arr[i] != target) {
                for(int j=i+1; j<arr.length; j++) {
                    
                        if (arr[j] == target) {
                            int temp = arr[i];
                            arr[i] = target;
                            arr[j] = temp;
                            res++;
                        }
                    }
            }
        }
        
        return res;

    }

```
