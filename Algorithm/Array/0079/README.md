Given an `m x n` grid of characters `board` and a string `word`, return `true` if `word` exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.

##### Example 1:
![](https://assets.leetcode.com/uploads/2020/11/04/word2.jpg)

```
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
Output: true
```

##### Example 2:
![](https://assets.leetcode.com/uploads/2020/11/04/word-1.jpg)
```
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
Output: true
```

##### Example 3:
![](https://assets.leetcode.com/uploads/2020/10/15/word3.jpg)

```
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
Output: false
```

##### Constraints:

- `m == board.length`
- `n = board[i].length`
- `1 <= m`, `n <= 6`
- `1 <= word.length <= 15`
- `board` and `word` consists of only lowercase and uppercase English letters.

題目是說在 `m x n` 棋盤上是否可以連續找到 `word` 字串中每個字符，這題很直觀的使用回溯進行實現。

```java
class Solution {
    public boolean exist(char[][] board, String word) {
        int c = board.length;
        int r = board[0].length;
        boolean[][] visited = new boolean[c][r];
        for (int i = 0; i < c; i++) {
            for (int j = 0; j < r; j++) {
                if (backtracing(board, word, i, j, 0, visited)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean backtracing(char[][] board, String word,int row, int col, int start, boolean[][] visited) {
        if (start == word.length()) return true; // 表示所有 word 字符都存在於棋盤中，且是連續
        if ( row >= board.length || col >= board[0].length || row < 0 || col < 0) return false; // 超出棋盤大小的操作
        if (visited[row][col]) return false; // 已被使用，避免同一字符存取同一個
        if (board[row][col] != word.charAt(start)) return false; // 當前棋盤上的字符不存在於當前 word 所要的字符
        visited[row][col] = true; // 當前面條件都通過表示當前棋盤是符合 word 中字符條件
        boolean res = backtracing(board, word, row, col+1, start + 1, visited) || // 當前的棋盤上下左右繼續比對是否符合 word 下個字符串
                        backtracing(board, word, row, col-1, start + 1, visited) ||
                        backtracing(board, word, row + 1, col, start + 1, visited) ||
                        backtracing(board, word, row - 1, col, start + 1, visited);
        visited[row][col] = false; // 避免迴路
        return res;
    }
}
```