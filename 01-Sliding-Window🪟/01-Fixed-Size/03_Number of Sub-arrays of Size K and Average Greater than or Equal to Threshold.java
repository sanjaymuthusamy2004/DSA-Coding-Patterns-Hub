/*
# 🚀 Problem: 1343. Number of Sub-arrays of Size K and Average Greater than or Equal to Threshold  
🔗 [View Problem on LeetCode](https://leetcode.com/problems/number-of-sub-arrays-of-size-k-and-average-greater-than-or-equal-to-threshold/)

## 📌 Problem Statement
Given an array of integers `arr` and two integers `k` and `threshold`,  
return the number of sub-arrays of size `k` whose average is greater than or equal to `threshold`.

---

## 🔹 Examples

Example 1: 
Input: `arr = [2,2,2,2,5,5,5,8]`, `k = 3`, `threshold = 4`  
Output: `3`  
Explanation: Sub-arrays `[2,5,5]`, `[5,5,5]`, and `[5,5,8]` have averages `4`, `5`, and `6` respectively.

Example 2:
Input: `arr = [11,13,17,23,29,31,7,5,2,3]`, `k = 3`, `threshold = 5`  
Output: `6`  
Explanation: The first 6 sub-arrays have averages > 5.

---

## 💡 Approach (Fixed-Size Sliding Window)
1. Calculate the sum of the first `k` elements.
2. Slide the window by one position at a time:
   - Add the new element entering the window.
   - Subtract the element leaving the window.
3. For each window, check if `(sum / k) >= threshold`.
4. Count how many windows satisfy the condition.

---

## ⏳ Complexity Analysis
- **Time Complexity:** O(N) – Single pass over the array.
- **Space Complexity:** O(1) – Only extra variables for sum and counter.

---

## 🛠 Java Solution
```java
*/

class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int sum = 0;
        int count = 0;

        for(int i = 0; i < k; i++){
            sum += arr[i];
        }

         
        if(sum / k  >= threshold) count++;

        int start = 0;
        int end = k;
        while(end < arr.length){
            
            sum  = sum -  arr[start];
            start++;

            sum = sum +  arr[end];
            end++;

            if(sum / k  >= threshold) count++;
            
        }

        return count ;
    }
}
