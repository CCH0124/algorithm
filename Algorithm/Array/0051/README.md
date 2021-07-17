The n-queens puzzle is the problem of placing `n` queens on an `n x n` chessboard such that no two queens attack each other.

Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.

Each solution contains a distinct board configuration of the n-queens' placement, where `'Q'` and `'.'` both indicate a queen and an empty space, respectively.

##### Example 1:
![](https://assets.leetcode.com/uploads/2020/11/13/queens.jpg)

```
Input: n = 4
Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above
```

##### Example 2:
```
Input: n = 1
Output: [["Q"]]
``` 

##### Constraints:

- `1 <= n <= 9`


這題稍微有點看了 wiki 給的文章，並從圖片發現端倪，也就是棋盤上的任何一個棋子左有斜方和上下都不會存在旗子，只要針對這些條件進行檢測，就可以利用回溯的想法去列舉所有結果。


```java
class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> results = new ArrayList<>();
        
        char[][] res = new char[n][n];
        
        Arrays.stream(res).forEach(i -> Arrays.fill(i, '.'));
        backtrace(results, res, 0);
        
        return results;
    }
    private void backtrace(List<List<String>> results, char[][] res, int offset) {
        if (offset == res.length) {
            List<String> list = new ArrayList<>();
            for (char[] c : res){
                StringBuilder sb = new StringBuilder();
                for (char row : c) {
                    sb.append(row);
                }
                list.add(sb.toString());
            }
            results.add(list);
            return;
        }
        
        for (int i=0; i<res.length; i++) {
            if (vaild(res, offset, i)) {
                res[offset][i] = 'Q';
                backtrace(results, res , offset + 1);
                res[offset][i] = '.';
            }
            
            
        }
    }
    
    private boolean vaild(char[][] res, int row, int column) {
        for (int i = 0; i<row; i++) {
            if (res[i][column] == 'Q') {
                return false;
            }
        }  
        for (int i = row-1, j = column - 1; i>=0 && j>=0; i--, j--) {
            if (res[i][j] == 'Q') {
                return false;
            }
        }
        for (int i = row-1, j = column + 1; i>=0 && j<res.length; i--, j++) {
            if (res[i][j] == 'Q') {
                return false;
            }
        }
        
        return true;
        
    }
}
```