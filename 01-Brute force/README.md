## 暴力法
### 選擇排序和氣泡排序
選擇排序，[code](SelectionSort.java)
```java=
SelectionSort(A[0..n-1])
    for i <- 0 to n - 2 do 
        min <- i
        for j <- i+1 to n-1 do
            if A[j] < A[min] min <- j
        swap A[i] and A[min]
```
氣泡排序，[code](BubbleSort.java)
```java=
BubbleSort(A[0..n-1])
    for i <- 0 to n - 2 do
        if A[j+1] < A[j] swap A[j] and A[j+1] 
```

輸入：可排序陣列
輸出：非降序排序陣列
### 循序搜尋和暴力字串配對
循序搜尋，[code](SequentialSearch2.java)
```java=
SequentialSearch(A[0..n], K)
    A[n] <- K
    i <- 0
    while A[i] != K do
        i <- i + 1
        if i < n return i
        else return -1
```

輸入：一個 n 個元素的陣列 A 和一個搜尋鍵值 K
輸出：第一個值等於 K 的元素位置，若找不到則回傳 -1

暴力字串配對，[code](BruteForceStringMatch.java)
```java=
BruteForceStringMatch(T[0..n-1], P[0..m-1])
    for i <- 0 to n-m do
        j <- 0
        while j < m and P[j] == T[i+j] do
            j <- j+1
            if j == m return i
    return -1
```

### 用暴力演算法解決最近配對和凸面多邊體問題
最近配對問題
```java=
BruteForceClosestPoints(P)
    dmin <- MAX
    for i <- to n-1 do
        for j <- i+1 to n do
            d <- sqrt((x_i - x_j)^2 +(y_i - y_j)^2)
            if d < dmin
                dmin <- d; index1 <- i; index <- j
    return index1, index2
```
### 窮盡搜尋法
旅行業務員問題
背包問題
指定問題

