```java
/*
     * Complete the 'minimumBribes' function below.
     *
     * The function accepts INTEGER_ARRAY q as parameter.
     */

    public static void minimumBribes(List<Integer> q) {
    // Write your code here
        int res = 0;
        for (int i=q.size()-1; i>=0; i--) {
            int target = i + 1;
            // System.out.println(q);
            if (q.get(i) != target) {
                if (q.get(i-1) == target) {
                    res+=1;
                    int temp = q.get(i);
                    q.set(i, q.get(i-1));
                    q.set(i-1, temp);
                    // System.out.println(q);
                } else if (q.get(i-2) == target) {
                    res += 2;
                    int temp = q.get(i-2);
                    q.set(i-2, q.get(i-1));
                    q.set(i-1, temp);
                    // System.out.println(q);
                    temp = q.get(i-1);
                    q.set(i-1, q.get(i));
                    q.set(i, temp);
                    // System.out.println(q);
                } else {
                    System.out.println("Too chaotic");
                    return;
                }
            }
        }
        
        System.out.println(res);
        
    }

```
