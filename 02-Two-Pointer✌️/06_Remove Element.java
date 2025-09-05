/*
# 🔗 Problem: Remove Element
Link : https://leetcode.com/problems/remove-element/

## 📌 Description
You are given an integer array `nums` and an integer `val`.  
Remove all occurrences of `val` **in-place** and return the new length `k`.  

The first `k` elements of `nums` should contain the elements not equal to `val`.  
The order of elements may change, and values beyond `k` do not matter.  

---

## 🧩 Examples

 Input:  
nums = [3,2,2,3], val = 3  

 Output:  
2, nums = [2,2,_,_]  

 Explanation: Function returns `k = 2`, and the first two elements of nums are `2`.  
It doesn’t matter what is left beyond index `k`.  


 Input:  
nums = [0,1,2,2,3,0,4,2], val = 2  

 Output:  
5, nums = [0,1,4,0,3,_,_,_]  

 Explanation: Function returns `k = 5`.  
The first 5 elements can be `[0, 1, 4, 0, 3]` in any order.  

---

## 🚀 Approach (Two Pointers)

- Use two pointers `i` (for traversal) and `j` (for placement).  
- Traverse the array:  
  - If `nums[i] != val`, place it at `nums[j]` and increment `j`.  
- Return `j` as the count of non-`val` elements.  

This works in-place without extra space.

---

## ⏱️ Complexity
- Time:  O(n) (single traversal of array)  
- Space: O(1) (in-place)  

---


*/

class Solution {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        int j = 0;
        
        while (i < nums.length) {
            if (nums[i] != val) {
                nums[j] = nums[i];
                j++;
            }
            i++;
        }
        
        return j;
    }
}
