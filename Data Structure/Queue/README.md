# Queue
是一個線性的資料結構，就愈現實中排隊是一樣概念，其有兩個主要操作分別是 `dequeue` 和 `enqueue`。

![](https://media.geeksforgeeks.org/wp-content/cdn-uploads/20230726165642/Queue-Data-structure1.png) From geeksforgeeks

每個 Queue 都會有 Front 和 Back，從 Front 移除是 `dequeue`，從 Back 插入元素是 `enqueue`

## 場景
1. 電影院、餐廳
2. Web 服務器請求管理等


## 複雜度

| 操作| Big-O|
|---|---|
|enqueue|`O(1)`|
|dqueue|`O(1)`|
|Peek|`O(1)`|
|contains|`O(n)`|
|Removal|`O(n)`|
|isEmpty|`O(1)`|

## 實作範例

與 Stack 雷同，可以使用鍊表(Linked List)完成，並同時有 Tail 和 Head 指標

假設有一個 Queue 目前是

```
Front -> 55, -1, 33, 17, 11 <- Back
```

進行以下操作
```
enqueue(12)
dequeue()
dequeue()
enqueue(7)
dequeue()
enqueue(-6)
```

1. enqueue(12)

```
55, -1, 33, 17, 11, 12
```

2. dequeue()


```
-1, 33, 17, 11, 12
```

3. dequeue()


```
33, 17, 11, 12
```

4. enqueue(7)


```
33, 17, 11, 12, 7
```

5. dequeue()

```
17, 11, 12, 7
```

6. enqueue(-6)
```
17, 11, 12, 7, -6
```


### BFS example

```
Let Q be a Queue
Q.enqueue(start_node)
start_node.visited = true

while Q is not empty Do
    node = Q.dequeue()
    For neig in neighbours(node):
      If neig has not been visited:
        neig.visited = true
        Q.enqueue(neig)
```