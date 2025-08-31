/*
# 🚀 Problem: 2461. Maximum Sum of Distinct Subarrays With Length K  
🔗 [View Problem on LeetCode](https://leetcode.com/problems/maximum-sum-of-distinct-subarrays-with-length-k/)

## 📌 Problem Statement
You are given an integer array `nums` and an integer `k`.  
Find the maximum subarray sum of all subarrays that:
1. Have length `k`, and  
2. Contain only distinct elements.  

If no subarray meets these conditions, return `0`.

---

## 🔹 Examples

Example 1:  
Input: nums = [1,5,4,2,9,9,9], k = 3  
Output: 15  
Explanation: The maximum sum comes from subarray `[4,2,9]`.

Example 2:  
Input: nums = [4,4,4], k = 3  
Output: 0  

---

## 🏷 Pattern  
Fixed Sliding Window + HashSet

---

## 💡 Approach (Sliding Window + HashSet)
1. Use a sliding window of size `k`.  
2. Maintain a `HashSet` to ensure all elements are distinct.  
3. Keep track of the window sum and update the maximum when conditions are met.  
4. Slide the window, removing the left element and adding the new right element.

---

## ⏳ Complexity Analysis
- **Time Complexity:** O(N) – Each element is added/removed from the set once.  
- **Space Complexity:** O(K) – For storing distinct elements in the current window.

---

## 🛠 Java Solution
```java
*/
class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        
        HashMap<Integer,Integer> map = new HashMap<>();
        long sum = 0;
        long maxSum = 0;
        // First window
        for(int i = 0; i < k; i++){
            map.put(nums[i], map.getOrDefault(nums[i],0) + 1);
            sum += nums[i];
        }
        if(map.size() == k) maxSum = sum;

        int start = 0;
        int end = k;

        // Sliding the window
        while(end < nums.length){
             map.put(nums[start], map.get(nums[start]) -  1);
             sum = sum - nums[start];
             if(map.get(nums[start]) == 0) map.remove(nums[start]);
             start++;

             map.put(nums[end], map.getOrDefault(nums[end],0) + 1);
             sum = sum + nums[end];
             end++;

             if(map.size() == k)
                maxSum = Math.max(maxSum, sum);

        }

        return maxSum;
    }
}
