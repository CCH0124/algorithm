Write an efficient algorithm that searches for a value in an `m x n` matrix. This matrix has the following properties:

- Integers in each row are sorted from left to right.
- The first integer of each row is greater than the last integer of the previous row.

##### Example 1:
![](https://assets.leetcode.com/uploads/2020/10/05/mat.jpg)

```
Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
Output: true
```

##### Example 2:
![](https://assets.leetcode.com/uploads/2020/10/05/mat2.jpg)

```
Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
Output: false
```

##### Constraints:

- `m == matrix.length`
- `n == matrix[i].length`
- `1 <= m, n <= 100`
- `-10^4 <= matrix[i][j], target <= 10^4`

題目是從二維陣列中找尋目標值，如果存在回傳 true，否則 fals。而陣列都是按照順序排列，因此很適合用二元搜尋。第一種解法是先定位可能的列，在從該列中進行搜尋。

```java
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0;
        for (int i=0; i<matrix.length;i++) {
            if (target >= matrix[i][0]  && target <= matrix[i][matrix[i].length-1]) {
                row = i;
                break;
            }
        }
        for (int i=0; i<matrix[row].length; i++) {
            if (matrix[row][i] == target) {
                return true;
            }
        }
        return false;
    }
}
```


```java
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0;
        for (int i=0; i<matrix.length;i++) {
            if (target >= matrix[i][0]  && target <= matrix[i][matrix[i].length-1]) {
                row = i;
                break;
            }
        }
        int res = Arrays.binarySearch(matrix[row], target);
        return !(res < 0);
    }
}
```