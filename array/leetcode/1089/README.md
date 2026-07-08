---
title: "Duplicate Zeros"
date: 2026/07/06
tags: ["array", "two pointers"]
draft: false
---

# 1089. Duplicate Zeros

Given a fixed-length integer array `arr`, duplicate each occurrence of zero, shifting the remaining elements to the right.

**Note** that elements beyond the length of the original array are not written. Do the above modifications to the input array in place and do not return anything.

**Example 1:**
```
Input: arr = [1,0,2,3,0,4,5,0]
Output: [1,0,0,2,3,0,0,4]
Explanation: After calling your function, the input array is modified to: [1,0,0,2,3,0,0,4]
```
**Example 2:**
```
Input: arr = [1,2,3]
Output: [1,2,3]
Explanation: After calling your function, the input array is modified to: [1,2,3]
``` 

**Constraints:**

- 1 <= arr.length <= $10^4$
- 0 <= arr[i] <= 9

## Solution

### case01

每次遇到 0 就用一個 for 迴圈把後面的元素全部往後移一格。

**java**

```java
class Solution {
    public void duplicateZeros(int[] arr) {
        for(int i=0; i<arr.length;i++) {
            if (arr[i] == 0) {
                for(int j=arr.length - 1; j > i ;j--) {
                    arr[j] = arr[j-1];
                }
                i++;
            }
        }
    }
}
```

Time Complexity: `O(n^2)`
Space Complexity: `O(1)`

> 外層迴圈：`for(int i=0; i<arr.length; i++)` 會從頭到尾掃描一遍陣列，這部分是 $O(n)$。
> 內層迴圈：當遇到 `arr[i] == 0` 時，會觸發 `for(int j=arr.length - 1; j > i ;j--)`。
> 這個迴圈會把第 i 個位置後面的所有元素一個一個往後搬移。如果 0 出現在陣列很前面（例如 index 0），內層迴圈就要跑將近 $n$ 次。
> 總體來說，最壞情況下（例如全都是 0 的陣列），時間複雜度會趨近於 $O(n^2)$。

### case02

既然case01 暴力解往後移很花時間，我們可以換個角度想。如果我們知道*複製完所有 0 之後，哪些數字會被擠出陣列，哪些數字能活下來*，我們就可以直接從後往前把活下來的數字填到它們最終該去的位置。

```java
class Solution {
    public void duplicateZeros(int[] arr) {
        int n = arr.length;
        int possibleZeros = 0;
        int lengthToKeep = n - 1;

        // Step 1: 找出哪些元素在複製 0 之後還能留在陣列中
        for (int i = 0; i <= lengthToKeep - possibleZeros; i++) {
            if (arr[i] == 0) {
                // 特殊邊界情況：如果這個 0 剛好是最後一個能塞進陣列的元素，但空間只夠放它自己，不夠複製
                if (i == lengthToKeep - possibleZeros) {
                    arr[n - 1] = 0; // 直接把最後一個位置放 0
                    lengthToKeep--; // 邊界縮小
                    break;
                }
                possibleZeros++;
            }
        }

        int last = lengthToKeep - possibleZeros; // 最後一個能活下來的元素的原始位置
        for (int i = last; i >= 0; i--) {
            if (arr[i] == 0) {
                arr[i + possibleZeros] = 0;
                possibleZeros--;
                arr[i + possibleZeros] = 0;
            } else {
                arr[i + possibleZeros] = arr[i];
            }
        }
    }
}
```

Time Complexity: `O(n)`
Space Complexity: `O(1)`


**go**

```go
func duplicateZeros(arr []int)  {
    n := len(arr)
    possibleZeros := 0
    lengthToKeep := n - 1
    
    for i := 0; i <= lengthToKeep - possibleZeros; i++ {
        if arr[i] == 0 {
            if i == lengthToKeep - possibleZeros {
                arr[n-1] = 0    // 1. 既然空間只夠放一個 0，那就直接把陣列最後一格填 0
                lengthToKeep--  // 2. 最後一格既然已經填好了，後面的倒序填空就不用管最後一格了
                break           // 3. 事情辦完了，提早結束第一階段的掃描
            }
            possibleZeros++
        }
    }
    
    last := lengthToKeep - possibleZeros
    for i := last; i >= 0; i-- {
        if arr[i] == 0 {
            arr[i + possibleZeros] = 0
            possibleZeros--
            arr[i + possibleZeros] = 0
        } else {
            arr[i + possibleZeros] = arr[i]
        }
    }
}
```