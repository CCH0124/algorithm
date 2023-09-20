# Linked List
可以儲存數據節點的順序列表，每個數據會指向其它節點。

```
data -> data -> data -> null
```

## 場景
- List
- Queue
- Stack 
- 循環的 List 等

## 元素
- Head 表示起始節點位置
- Tail 結束節點位置
- Pointer 指向其它節點
- Node 是一個物件包含了值和指標

```
# Pointer 如同 -> 符號
  1 -> 12 -> 22 -> 32 -> 42

Head                    Tail
```

## Singly and Doubly Linked List

Singly Linked List 只有指向下一個節點的 Pointer；Doubly Linked List 則會反向多指向上一個節點。

| | 優點| 缺點|
|---|---|---|
|Singly Linked List | 較少的記憶體| 無法存取前面的節點|
|Doubly Linked List | 可以前後存取| 記憶體使用更多|

以下面為 Singly Linked List 例子，

```
Head              Tail
  5 -> 10 -> 15 -> 13
 tra
```

1. 要插入一個 11 到第三個位置

透過 tra 進行遍歷到 10，此時將 11 的節點指向 tra 的下個節點，再將 tra 的下個節點指向 11 節點。

```
newNode = Node(11);
newNode.next = tra.next;
tra.next = newNode;
```

2. 要刪除 15 節點

透過 tra 進行遍歷到 10，此時檢查下個節點的值，如果是要刪除，再將 tra 的下個節點指向 tra 的下下個節點。

```
if (tra.next.data == 15)
  tra.next = tra.next.next
```


以下面為 Doubly Linked List 例子

```
Head                  Tail
  5 <-> 10 <-> 15 <-> 13
 tra
```

1. 要插入一個 11 到第三個位置
透過 tra 進行遍歷到 10，將 11 節點的下個節點指向 tra 的下個節點，tra 下個節點指向 11 節點，再將 11 節點的前節點指向 tra，最後把 11 節點的下個節點也就是 15，將 15 節點的前節點指向 11 節點。

```
newNode = Node(11);
newNode.next = tra.next; // 11 -> 15
tra.next = newNode;  // 10 -> 11
newNode.prev = tra; // 10 <-> 11
newNode.next.prev = newNode; // 11 <-> 15
```

2. 要刪除 15 節點

```
tra.next.prev = tra.prev;
tra.prev.next = tra.next;
```

## 複雜度

| | Singly Linked List | Doubly Linked List|
|---|---|---|
|search |`O(n)`|`O(n)`|
|Insert at head|`O(1)`|`O(1)`|
|Insert at tail|`O(1)`|`O(1)`|
|Remove at head|`O(1)`|`O(1)`|
|Remove at tail|`O(n)`|`O(1)`|
|Remove in middle|`O(n)`|`O(n)`|

對於 Head 和 Tail 的資料插入是不需要遍歷的，移除 Head 也是。