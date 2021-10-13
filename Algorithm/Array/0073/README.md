Given an `m x n` integer matrix `matrix`, if an element is `0`, set its entire row and column to `0`'s, and return the matrix.
You must do it [in place](https://en.wikipedia.org/wiki/In-place_algorithm).

##### Example 1:
![](https://assets.leetcode.com/uploads/2020/08/17/mat1.jpg)

```
Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
Output: [[1,0,1],[0,0,0],[1,0,1]]
```
##### Example 2:
![](https://assets.leetcode.com/uploads/2020/08/17/mat2.jpg)

```
Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
```

##### Constraints:

- `m == matrix.length`
- `n == matrix[0].length`
- `1 <= m, n <= 200`
- `-2^31 <= matrix[i][j] <= 2^31 - 1`
 

##### Follow up:

- A straightforward solution using `O(mn)` space is probably a bad idea.
- A simple improvement uses `O(m + n)` space, but still not the best solution.
- Could you devise a constant space solution?

很直接地記錄為 0 的列和欄，最後再把紀錄的列和欄進行迭代補 0。但時間有點久，應該可以優化。

```java
class Solution {
    public void setZeroes(int[][] matrix) {
        Set<Integer> col = new HashSet<>();
        Set<Integer> row = new HashSet<>();
        for (int i=0; i<matrix.length; i++){
            for (int j=0; j<matrix[i].length; j++){
                if (matrix[i][j] == 0) {
                    row.add(i);
                    col.add(j);
                }
            }    
        }
        for (int i=0; i<matrix.length; i++){
            for (int j=0; j<matrix[i].length; j++){
                if (row.contains(i) || col.contains(j)) {
                    matrix[i][j] = 0;
                }
            }    
        }
    }
}
```