/*
# 🚀 Problem: 713. Subarray Product Less Than K  
🔗 [View Problem on LeetCode](https://leetcode.com/problems/subarray-product-less-than-k/)  

## 📌 Problem Statement  
Given an array of integers `nums` and an integer `k`, return the number of contiguous subarrays where the product of all the elements is strictly less than `k`.  

---

## 🔹 Examples  

 Example 1:   
Input: nums = [10,5,2,6], k = 100  
Output: 8  
Explanation: The subarrays are `[10], [5], [2], [6], [10,5], [5,2], [2,6], [5,2,6]`.  

 Example 2:   
Input: nums = [1,2,3], k = 0  
Output: 0  

---

## 🏷 Pattern  
Sliding Window / Two Pointers  

---

## 💡 Approach  
1. Use two pointers (`start`, `end`) to maintain a sliding window product.  
2. Multiply the current element into the product.  
3. If product ≥ k, shrink the window by dividing from the left.  
4. For each valid window, add `(end - start)` to the count (number of new subarrays ending at `end`).  

---

## ⏳ Complexity Analysis  
-  Time Complexity:  O(N) — each element is processed at most twice.  
-  Space Complexity:  O(1) — only variables for product, count, and pointers.  

---

## 🛠 Java Solution  
*/

class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) { 
        // Base case
        if(k <=1 ) return 0;

        int product = 1;
        int count = 0;

        int start = 0;
        int end = 0;
        
        while(end < nums.length){
           product *= nums[end];
           end++;

           while(product >= k){
                product /= nums[start];
                start++;
           }

           count += end - start;

        }
        return count;
    }
}
