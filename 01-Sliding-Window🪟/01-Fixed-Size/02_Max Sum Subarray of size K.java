/*
# 🚀 Problem: Max Sum Subarray of Size K  
🔗 [View Problem on GeeksforGeeks](https://www.geeksforgeeks.org/problems/max-sum-subarray-of-size-k5313/1)

## 📌 Problem Statement
Given an array of integers `arr[]` and a number `k`.  
Return the **maximum sum** of any subarray of size `k`.  

A **subarray** is a contiguous part of any given array.

---

## 🔹 Examples

Example 1:  
Input: `arr = [100, 200, 300, 400]`, `k = 2`  
Output: `700`  
Explanation: `300 + 400 = 700` → maximum sum.

Example 2:  
Input: `arr = [100, 200, 300, 400]`, `k = 4`  
Output: `1000`  
Explanation: `100 + 200 + 300 + 400 = 1000`.

Example 3:  
Input: `arr = [100, 200, 300, 400]`, `k = 1`  
Output: `400`  
Explanation: Single element `400` is maximum.

---

## 💡 Approach (Fixed-Size Sliding Window)
1. Calculate the sum of the first `k` elements.
2. Slide the window one element at a time:  
   - Add the new element entering the window.  
   - Subtract the element leaving the window.  
3. Keep track of the maximum sum seen so far.

---

## ⏳ Complexity Analysis
- **Time Complexity:** O(N) – Single pass through the array.
- **Space Complexity:** O(1) – Only a few extra variables.

---

## 🛠 Java Solution
```java

*/
class Solution {
    public int maximumSumSubarray(int[] arr, int k) {
        
        int current_max = 0;
        for(int i = 0; i < k ;i++){
            current_max += arr[i];
        }
      
        int max_so_far = current_max;
        
        int start = 0;
        int end = k;
        
        while(end < arr.length){
            current_max -= arr[start];
            start++;
            
            current_max += arr[end];
            end++;
            
            max_so_far = Math.max(max_so_far, current_max);
        }
        
        return max_so_far;
        
        
    }
}
