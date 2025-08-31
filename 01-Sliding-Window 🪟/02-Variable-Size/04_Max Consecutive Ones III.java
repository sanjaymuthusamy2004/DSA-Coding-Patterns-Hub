/*
# 🚀 Problem: 1004. Max Consecutive Ones III  
🔗 [View Problem on LeetCode](https://leetcode.com/problems/max-consecutive-ones-iii/)  

## 📌 Problem Statement  
Given a binary array `nums` and an integer `k`, return the  maximum number of consecutive 1's  in the array if you can flip at most `k` zeroes.  

---

## 🔹 Examples  

 Example 1:   
Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2  
Output: 6  
Explanation: Flip 2 zeros → longest subarray `[1,1,1,0,0,1,1,1,1,1,1]` has length 6.  

 Example 2:   
Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3  
Output: 10  
Explanation: Flip 3 zeros → longest subarray has length 10.  

---

## 🏷 Pattern  
 Sliding Window / Two Pointers   

---

## 💡 Approach  
1. Maintain a sliding window `[left, right]`.  
2. Track the number of `1`s in the window (`maxOnes`).  
3. If the number of zeros in the window (`windowSize - maxOnes`) exceeds `k`, shrink the window from the left.  
4. Track the maximum window size that satisfies the condition.  

---

## ⏳ Complexity Analysis  
-  Time Complexity:  O(N) — each element is visited at most twice.  
-  Space Complexity:  O(1) — only counters and pointers are used.  

---

## 🛠 Java Solution  
*/
class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0, right = 0;
        int maxOnes = 0, maxWindowSize = 0;

        while (right < nums.length) {
            if (nums[right] == 1) {
                maxOnes++;
            }

            while ((right - left + 1) - maxOnes > k) {
                if (nums[left] == 1) {
                    maxOnes--;
                }
                left++;
            }

            maxWindowSize = Math.max(maxWindowSize, right - left + 1);
            right++;
        }
        return maxWindowSize;
    }
}
