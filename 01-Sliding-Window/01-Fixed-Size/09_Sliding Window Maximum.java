/*
# 🚀 Problem: 239. Sliding Window Maximum  
🔗 [View Problem on LeetCode](https://leetcode.com/problems/sliding-window-maximum/)

## 📌 Problem Statement
You are given an integer array `nums` and an integer `k`.  
A sliding window of size `k` moves from left to right across `nums`, one position at a time.  
Return an array containing the maximum value in each sliding window.

---

## 🔹 Examples

Example 1:  
Input: nums = [1,3,-1,-3,5,3,6,7], k = 3  
Output: [3,3,5,5,6,7]  

Example 2:  
Input: nums = [1], k = 1  
Output: [1]  

---

## 🏷 Pattern  
**Sliding Window + Monotonic Deque**

---

## 💡 Approach (Monotonic Deque)
1. Use a deque to store indices of elements in decreasing order of values.  
2. The front of the deque always holds the index of the current maximum.  
3. For each step:
   - Remove indices from the back if their values are less than or equal to the current element.  
   - Remove the front index if it’s outside the window.  
   - Add the current index to the deque.  
   - Once the first `k` elements are processed, append the deque's front value to the result.

---

## ⏳ Complexity Analysis
- Time Complexity: O(N) – Each element is pushed and popped at most once.  
- Space Complexity: O(K) – For the deque storing indices.

---

## 🛠 Java Solution
```java
*/

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        int[] result = new int[nums.length - k + 1];

        Deque<Integer> q = new ArrayDeque<>();

        for(int i = 0; i < nums.length; i++){
            // Remove the element from the front of the deque if they exceeds K value
            while(!q.isEmpty() && q.peek() < i - k + 1){
                q.poll();
            }

            // Remove the element from the back of the deque if they are smaller than the current element
            while(!q.isEmpty() && nums[i] >= nums[q.peekLast()]){
                q.pollLast();
            }

            // Add the current Index to the deque
            q.offer(i);

            // Add the maximum element in the current window to the result array
            if(i - k + 1 >= 0){
                result[i - k + 1] = nums[q.peek()];
            }
        }

        return result;
    }
}
