**Example 1:**
```
Input: asteroids = [5,10,-5]
Output: [5,10]
Explanation: The 10 and -5 collide resulting in 10. The 5 and 10 never collide.
```
**Example 2:**
```
Input: asteroids = [8,-8]
Output: []
Explanation: The 8 and -8 collide exploding each other.
```
**Example 3:**
```
Input: asteroids = [10,2,-5]
Output: [10]
Explanation: The 2 and -5 collide resulting in -5. The 10 and -5 collide resulting in 10.
```

依照條件：
- 如果兩顆小行星相遇，較小的一顆就會爆炸
- 如果兩者大小相同，則兩者都會爆炸
- 朝同一方向移動的兩顆小行星永遠不會相遇
  
```java
// https://leetcode.com/problems/asteroid-collision/description/?envType=study-plan-v2&envId=leetcode-75
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int i : asteroids) {
            // 同方向
            if (i > 0 ) {
                stack.push(i);
            } else {
                // < 0 進來
                while( !stack.isEmpty() && stack.peek() > 0 && stack.peek() < Math.abs(i)) {
                    stack.pop();
                }
                if (!stack.isEmpty() && stack.peek() == Math.abs(i)) {
                    stack.pop();
                } else if (stack.isEmpty() || stack.peek() < 0) {
                    // 同方向，且是負也不會碰撞
                    stack.push(i);
                }
            }
        }    
        return stack.stream().mapToInt(i->i).toArray();
    }
}
```
