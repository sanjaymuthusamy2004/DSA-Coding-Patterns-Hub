/*
# 🚀 Problem: 209. Minimum Size Subarray Sum  
🔗 [View Problem on LeetCode](https://leetcode.com/problems/minimum-size-subarray-sum/)  

## 📌 Problem Statement  
Given an array of positive integers `nums` and a positive integer `target`, return the minimal length of a subarray whose sum is greater than or equal to `target`.  
If no such subarray exists, return `0`.  

---

## 🔹 Examples  

Example 1:  
Input: target = 7, nums = [2,3,1,2,4,3]  
Output: 2  
Explanation: The subarray `[4,3]` has the minimal length.  

Example 2: 
Input: target = 4, nums = [1,4,4]  
Output: 1  

Example 3:  
Input: target = 11, nums = [1,1,1,1,1,1,1,1]  
Output: 0  

---

## 🏷 Pattern  
Sliding Window / Two Pointers  

---

## 💡 Approach  
1. Use two pointers start and end to represent the window.  
2. Expand the window by moving end and adding nums[end] to the sum.   
3. When the window sum is ≥ target, shrink the window from the left (start) while keeping the sum ≥ target, and update the minimum length.  
4. Repeat this process until the end of the array.  

---

## ⏳ Complexity Analysis  
- Time Complexity: O(N) — each element is visited at most twice.  
- Space Complexity: O(1) — only counters and pointers are used.  

---

## 🛠 Java Solution  
*/
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int minWindow = Integer.MAX_VALUE;
        int start = 0;

        for (int end = 0; end < nums.length; end++) {
            sum += nums[end];

            while (sum >= target) {
                minWindow = Math.min(minWindow, end - start + 1);
                sum -= nums[start];
                start++;
            }
        }

        return minWindow == Integer.MAX_VALUE ? 0 : minWindow;
    }
}
