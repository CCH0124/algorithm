## Big-O notation
n 表示輸入的複雜度，從小到大的順序

- Constant Time: `O(1)`

```
// i 並未依賴於 n
i = 0
while i < 11
  i = i + 1
```

- Logarithmic Time: `O(log(n))`

example:

```
// 二分搜索演算法
// O(log_2(n)) = O(log(n))
low = 0
high = n - 1
while low <= high
  mid = (low+high)/2
  if arr[mid] == value
    return mid
  else if arr[mid] < value
    low = mid + 1
  else if arr[mid] > value
    high = mid - 1
return -1
```

- Linear Time: `O(n)`

example 1:
```
// f(n) = n
// O(f(n)) = O(n)
i = 0
while i < n
  i = i + 1
```

example 2:
```
// f(n) = n/3
// O(f(n)) = O(n)
i = 0
while i < n
  i = i + 3
```

- Linearithkic Time: `O(nlog(n))`
- Quadric Time: `O(n^2)`

example 1:

```
// f(n) = n * n = n^2
// O(f(n)) = O(n^2)
for (i = 0; i < n; i++)
  for (j = 0; j < n; j++)

// 以第二層迴圈觀察
// 如果 i 是 0, 觸發 n 次
// 如果 i 是 1, 觸發 n-1 次
// 如果 i 是 2, 觸發 n-2 次，以此類推
// (n) + (n-1) + (n-2) + (n-3) + ... + 3 + 2 + 1 ，推導出 n(n+1)/2
// O(n(n+1)/2) = O(n^2/2 + n/2) = O(n^2)
for (i = 0; i < n; i++)
  for (j = i; j < n; j++)
```

example 2:

```
// f(n) = n * (3n + 2n) = 5n^2, O(f(n)) = O(n^2)
i = 0
while i < n
  while j < 3*n
    j = j + 1
  j = 0
  while j < 2 * n
    j = j + 1
  i = i + 1
```

- Cubic Time: `O(n^3)`
- Exponential Time: `O(b^n)`, b > 1
- Factorial Time: `O(n!)`

從一個集合找尋所有子集是 `O(2^n)`
從一個字串找尋所有排列 `O(n!)`
合併排序 `O(nlog(n))`
迭帶一個矩陣所有值 `O(nm)`
