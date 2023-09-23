# Priority Queue with heaps
Priority Queue 是一種抽象的資料類型，因此可以用不同類型方式去實現，操作與 Queue 類似。但，不同之處在於每個元素都有優先權。因此，較高優先權的元素會先出來。

要使用這種資料類型，元素必須是一個可比較的資料，這表示其資料會以某種方式進行排序。

![](https://media.geeksforgeeks.org/wp-content/cdn-uploads/Priority-Queue-min-1024x512.png) From geeksforgeeks

對於 Priority Queue 他是要如何知道下個要刪除的最小資源是哪個 ? 如果使用排序會是沒效率，反倒是使用了 `heap` 概念。


`heap` 是一種基於樹的資料結構，滿足 `heap invariant`。如果 A 是 B 的父節點，則對於堆中的所有節點 A、B，A 相對於 B 進行排序。最終會有兩個類型的 `heap`，分別是 Max Heap、Min Heap。

Max Heap，父節點都大於子節點；Min Heap 反之。

![](https://media.geeksforgeeks.org/wp-content/cdn-uploads/20221220165711/MinHeapAndMaxHeap1.png) From geeksforgeeks

## 使用場景
- Dijkstra's Shortest Path 演算法
- 任何時間，都想要動態獲取最好或是最壞的元素
- Huffman coding 等

## 複雜度

PQ with binary heap

| 操作 | Big-O|
|---|---|
|Binary Heap construction|`O(n)`|
|Poll|`O(log(n))`|
|Peek|`O(1)`|
|Add|`O(log(n))`|
|Naive Removing|`O(n)`|
|Advanced removing with help from a hash table|`O(log(n))`|
|Naive contains|`O(n)`|
|Contains check with help of a hash table|`O(1)`|


## Priority Queue 實作方法
通常使用 `heap` 來實現，因為這提供了最佳的時間複雜度。Priority Queue 是一種抽象資料類型，用 heap 實作並不是 Priority Queue 的唯一方法。例如，可以使用未排序的列表，但這不會給我們最佳的時間。複雜度。

## Priority Queue 與 Binary Heap

Heap 有很多的類型，可以實作 Priority Queue 的方式包含
- Binary Heap
- Fibonacci Heap
- Binomial Heap
- Pairing Heap etc.


以 Binary heap 為例，Binary heap 是支援堆不變量(heap invariant)的 Binary tree。在 Binary tree 上父節點大於子節點，且每個節點下都有兩個子節點。

![](https://upload.wikimedia.org/wikipedia/commons/5/5e/Binary_tree_v2.svg) From wikipedia


另一個概念是完全二元樹(complete binary tree)，表示樹的每一層都會有完整的兩個元素，除了最後一層。而 Binary heap 是一個完全二元樹 (complete binary tree)。

![](https://media.geeksforgeeks.org/wp-content/uploads/20220308222049/68261-300x198.jpg) From geeksforgeeks


## Binary Heap 

以陣列表示 Binary Heap，可以如下圖

![](https://upload.wikimedia.org/wikipedia/commons/thumb/3/38/Max-Heap.svg/1200px-Max-Heap.svg.png) From wikipedia


Let i be the parent node index

Left child index: 2i + 1
Right child index: 2i + 2

Binary heap 是 Min heap 或 Max heap。


### Insert

1. 插入的元素被放置最後一個位置
2. 與父節點進行比較，以 Min heap 來說，應當父節點要比子節點小，如果小就交換
3. 重複第 2 步驟，直到滿足 Min heap 的狀態


### Poll

以 Min heap 來說會是拿取最小的值。

1. 取出最小元素及根節點，且當前根節點會與最後一個節點交換
2. 根節點與下面子節點進行比較，維持 Min heap 的狀態
3. 重複第 2 步驟，直到滿足  Min heap 的狀態'


### Remove

移除節點，與 Poll 很像，差在說 Poll 是拿根節點；Remove 則是任意節點

1. 找到要移除的物件，並和最後一個節點交換
2. 往上或往下與節點比較，維持 Min heap 的狀態
3. 重複第 2 步驟，直到滿足  Min heap 的狀態'

更有效率的執行移除可以使用 `Hashtable` 方式定位節點位置。`Hashtable` 為從鍵（節點值）到值（索引）的對應提供常數時間的查找和更新。

`Hashtable` 如何處理相同值 ? 不是將一個值映射到一個位置，而是將一個值映射到多個位置。這樣可以維護特定節點值（鍵）映射到的 Set 或 Tree Set。

```
            2
    7               2
11      7       13      2

```

Index Tree

```
            0
    1               2
3      4       5        6

```

Hashtable:

| Node Value(Key)| Postion(Value)|
|---|---|
|2|0, 2, 6|
|7|1, 4|
|11|3|
|13|5|

如果要刪除 Binary heap 中重複的節點，刪除哪個是不重要。只要最後能滿足 heap 的規則即可

### 參考來源
- [Binary Heap | GeeksforGeeks](https://www.youtube.com/watch?v=uZj0hetLFHU&t=2s&ab_channel=GeeksforGeeks)
- [binary-heap](https://www.shubo.io/binary-heap/) From shubo