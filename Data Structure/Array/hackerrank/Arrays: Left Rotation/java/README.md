```java

    /*
     * Complete the 'rotLeft' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER d
     */

    public static List<Integer> rotLeft(List<Integer> a, int d) {
    // Write your code here
        Queue<Integer> queue = new LinkedList<>(a);
        for (int i=0; i<d; i++) {
            queue.add(queue.remove());
        }
        
        return new ArrayList<>(queue);
    }

```
