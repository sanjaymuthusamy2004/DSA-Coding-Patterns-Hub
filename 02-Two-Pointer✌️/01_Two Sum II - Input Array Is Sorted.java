/*
# 🚀 Problem: Two Sum - Input Array is Sorted  
🔗 [View Problem on LeetCode](https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/)

---

## 📌 Problem Statement  
You are given a  sorted  array of integers `nums` and an integer `target`.  
Return the  1-based indices  of the two numbers such that they add up to `target`.  
You must use exactly  one solution , and  each input would have exactly one solution .  
You may not use the same element twice.

---

## 🔹 Examples

 Example 1:   
Input: `nums = [2, 7, 11, 15]`, `target = 9`  
Output: `[1, 2]`  
Explanation: `nums[0] + nums[1] = 2 + 7 = 9`

 Example 2:   
Input: `nums = [1, 2, 3, 4, 4, 9, 56, 90]`, `target = 8`  
Output: `[4, 5]`  
Explanation: `nums[3] + nums[4] = 4 + 4 = 8`

---

## 💡 Approach (Two-Pointer Technique)

1. Initialize two pointers:  
   - `left` at the start (index `0`)  
   - `right` at the end (index `nums.length - 1`)

2. Use a `while` loop while `left < right`:
   - Calculate the sum: `nums[left] + nums[right]`
   - If the sum equals the target, return `[left + 1, right + 1]` (since output is 1-based)
   - If the sum is greater than the target, move `right` pointer left
   - If the sum is less than the target, move `left` pointer right

3. If no pair is found (though the problem guarantees one), return `[-1, -1]`

---

## ⏳ Complexity Analysis

-  Time Complexity:  O(N) – At most one pass through the array  
-  Space Complexity:  O(1) – Constant extra space used

---

## 🛠 Java Solution
*/

class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int total = nums[left] + nums[right];

            if (total == target) 
                return new int[]{left + 1, right + 1}; // 1-based index
            else if (total > target)
                right--;
            else
                left++;
        }

        return new int[]{-1, -1}; // Should never happen if input guarantees one solution
    }
}
