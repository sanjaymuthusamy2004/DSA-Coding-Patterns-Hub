/*
# 🚀 643. Maximum Average Subarray I
      Link : https://leetcode.com/problems/maximum-average-subarray-i/description/

## 📌 Problem Statement
You are given an integer array `nums` consisting of `n` elements, and an integer `k`.  

Find a contiguous subarray whose length is equal to `k` that has the maximum average value and return this value.  
Any answer with a calculation error less than `10^-5` will be accepted.

---

## 🔹 Example
**Example 1**  
Input: nums = [1, 12, -5, -6, 50, 3], k = 4  
Output: 12.75000  
Explanation: Maximum average is `(12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75`  

**Example 2**  
Input: nums = [5], k = 1  
Output: 5.00000  

---

## 💡 Approach (Fixed-Size Sliding Window)
1. First, calculate the sum of the first `k` elements.
2. Slide the window by one element at a time:
   - Add the new element entering the window.
   - Remove the first element that is leaving the window.
3. Keep track of the **maximum sum** seen so far.
4. Divide the maximum sum by `k` to get the maximum average.

---

## ⏳ Complexity Analysis
- **Time Complexity:** O(N) — each element is visited once.
- **Space Complexity:** O(1) — constant extra memory.

---

## 🛠 Java Solution
*/
  
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double sum = 0;
      
        // Find the sum for first K size 
        for(int i = 0 ; i < k; i++){
            sum += nums[i];
        }

        double maxSum = sum;
        int end = k;
        int start = 0;

        // Run the loop till it reaches the size of array
        while(end < nums.length){
            // Remove the old value
            sum  = sum - nums[start]; 
            // Add the new value
            sum  = sum + nums[end];
            start++;
            end++;

            maxSum = Math.max(maxSum , sum);
        }

        return maxSum / k;

    }
}
