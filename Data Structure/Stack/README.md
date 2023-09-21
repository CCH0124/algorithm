# Stack

是一種 `one-ended` 線性的資料結構，主要透過 `push` 和 `pop` 進行 stack 的操作。

![](https://media.geeksforgeeks.org/wp-content/cdn-uploads/20230726165552/Stack-Data-Structure.png) From geeksforgeeks

以上圖來說，會對 stack 的頂部進行 `push` 和 `pop` 操作，且會有一個指標總是指向 stack 最頂端的元素。通常我們稱此行為是 `LIFO` 先進後出。

範例：

初始化的 stack 如下

```
[mulberry]
[bilberry]
[berry]
[blueberry]
```

1. 執行 pop()

```
[bilberry]
[berry]
[blueberry]
```

2. 執行 push(pomelo)


```
[pomelo]
[bilberry]
[berry]
[blueberry]
```

3. 執行 push(shaddock)

```
[shaddock]
[pomelo]
[bilberry]
[berry]
[blueberry]
```

4. 執行兩次 pop()

```
[bilberry]
[berry]
[blueberry]
```

## 場景
1. 文字編輯器的回退機制
2. 符號檢查，像是 `()` 等
3. 遞迴函式呼叫等

## 複雜度

| 操作| Big-O|
|---|---|
|Push|`O(1)`|
|Pop|`O(1)`|
|Peek|`O(1)`|
|Search|`O(n)`|
|size|`O(1)`|

## 實作概念
通常可以使用 Linked List 概念實作。


### push

```
push(4)
push(5)
push(6)
push(18)
```

初始化鍊表(Linked List)
```
null
```

1. push(4)

```
4 -> null
Head
```
2. push(5)

```
5 -> 4 -> null
Head
```

3. push(6)


```
6 -> 5 -> 4 -> null
Head
```

4. push(18)


```
18 -> 6 -> 5 -> 4 -> null
Head
```

### pop

```
pop()
pop()
```

1. pop()

```
null  6 -> 5 -> 4 -> null
      Head
```

2. pop()

```
null  null   5 -> 4 -> null
            Head

```