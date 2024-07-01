**Example 1:**
```
Input: senate = "RD"
Output: "Radiant"
Explanation: 
The first senator comes from Radiant and he can just ban the next senator's right in round 1. 
And the second senator can't exercise any rights anymore since his right has been banned. 
And in round 2, the first senator can just announce the victory since he is the only guy in the senate who can vote.
```
**Example 2:**
```
Input: senate = "RDD"
Output: "Dire"
Explanation: 
The first senator comes from Radiant and he can just ban the next senator's right in round 1. 
And the second senator can't exercise any rights anymore since his right has been banned. 
And the third senator comes from Dire and he can ban the first senator's right in round 1. 
And in round 2, the third senator can just announce the victory since he is the only guy in the senate who can vote.
``` 


```java
# https://leetcode.com/problems/dota2-senate/description/?envType=study-plan-v2&envId=leetcode-75
# https://medium.com/@cindy20303705/leetcode-649-dota2-senate-%E8%A7%A3%E6%B3%95-dcb9933a853c
class Solution {
    public String predictPartyVictory(String senate) {
        int n = senate.length();
        Queue<Integer> radiants = new LinkedList<>();
        Queue<Integer> dires = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            char c = senate.charAt(i);
            if (c == 'R') {
                radiants.offer(i);
            } else {
                dires.offer(i);
            }
        }
        
        while( !radiants.isEmpty() && !dires.isEmpty()) {
            int r = radiants.poll();
            int d = dires.poll();
            if (r < d) {
                radiants.offer(r + n);
            } else {
                dires.offer(d + n);
            }
        }


        return radiants.isEmpty() ? "Dire" : "Radiant";

    }
}
```
