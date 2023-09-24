# Union Find
Union Find 是一種資料結構，用於追蹤分成一個或多個不相交集合的元素。它有兩個主要操作：`find` 和 `union`。

## 場景
- Kruskal's minimum spanning tree 演算法
- Grid percolation
- Network connectivity 等

## 複雜度

| 操作 | Big-O|
|---|---|
|Construction|`O(n)`|
|Union|$\alpha(n)$|
|Find|$\alpha(n)$|
|Get component size|$\alpha(n)$|
|Check if connected|$\alpha(n)$|
|Count|`O(1)`|

$\alpha(n)$ - Amortized constant time

## Union Find 應用之 Kruskal's Minimum Spanning Tree
給定一個圖 $G = (V, E)$，我們希望在圖中找到一個 Minimum Spanning Tree（它可能不是唯一的）。Minimum Spanning Tree 是邊的子集，它以最小的總邊成本連接圖中的所有頂點。

![](https://www.geneseo.edu/~baldwin/csci242/spring2013/kruskal.png) From geneseo

基本上可以分成三部分：
1. 對邊進行升序的排序
2. 遍歷排序後的邊並查看該邊所屬的兩個節點，如果節點已經統一，不包括該邊，否則要包括它並統一節點
3. 當每條邊都被處理或所有頂點都被統一時，演算法就會終止。



## 參考資源

- [43mst](https://algs4.cs.princeton.edu/43mst/)