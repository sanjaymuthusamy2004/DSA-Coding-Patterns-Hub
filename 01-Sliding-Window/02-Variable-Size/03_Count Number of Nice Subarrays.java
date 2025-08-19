/*
# 🚀 Problem: 1248. Count Number of Nice Subarrays  
🔗 [View Problem on LeetCode](https://leetcode.com/problems/count-number-of-nice-subarrays/)  

## 📌 Problem Statement  
Given an array of integers `nums` and an integer `k`.  
A continuous subarray is called nice if there are exactly `k` odd numbers in it.  

Return the number of nice subarrays.  

---

## 🔹 Examples  

 Example 1: 
Input: nums = [1,1,2,1,1], k = 3  
Output: 2  
Explanation: Subarrays `[1,1,2,1]` and `[1,2,1,1]` have exactly 3 odd numbers.  

 Example 2:   
Input: nums = [2,4,6], k = 1  
Output: 0  
Explanation: No odd numbers are present.  

 Example 3:   
Input: nums = [2,2,2,1,2,2,1,2,2,2], k = 2  
Output: 16  

---

## 🏷 Pattern  
Sliding Window / Prefix Counting  

---

## 💡 Approach  
1. Use the  atMost(k)  trick:  
   - Count subarrays with at most `k` odd numbers.  
   - Count subarrays with at most `k-1` odd numbers.  
2. The difference gives the count of subarrays with  exactly `k` odd numbers .  

---

## ⏳ Complexity Analysis  
-  Time Complexity:  O(N) — each element is processed once.  
-  Space Complexity:  O(1) — only counters and pointers used.  

---

## 🛠 Java Solution  
*/
class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
      return atMost(nums,k) - atMost(nums,k-1);
    }

    public int atMost(int[] nums, int k){
        int oddCount = 0;
        int subArrayCount = 0;

        int start = 0;
        int end = 0;
        while(end < nums.length){
            if(nums[end] % 2 == 1)
                oddCount++;
            end++;

           
            while(oddCount > k){
                if(nums[start] % 2 == 1) oddCount--;
                start++;
               
               
            }
            subArrayCount += end - start + 1;
        }

        return subArrayCount;
    }
}
