/*
# 🔗 Problem: Squares of a Sorted Array
Link : https://leetcode.com/problems/squares-of-a-sorted-array/

## 📌 Description
You are given an integer array `nums` sorted in **non-decreasing order**.  
Return an array of the squares of each number, also sorted in **non-decreasing order**.

---

## 🧩 Examples

 Input:  
nums = [-4, -1, 0, 3, 10]  

 Output:  
[0, 1, 9, 16, 100]  

 Explanation: After squaring → [16, 1, 0, 9, 100],  
Sorting → [0, 1, 9, 16, 100].  


 Input:  
nums = [-7, -3, 2, 3, 11]  

 Output:  
[4, 9, 9, 49, 121]  

---

## 🚀 Approach (Two Pointers)

- Since `nums` is sorted, the largest squares will be at the extremes (leftmost or rightmost).  
- Use two pointers:  
  - `start` → beginning of array  
  - `end` → end of array  
- Compare squares of both ends and fill results from **right to left**.  
- Decrement index until complete.

---

## ⏱️ Complexity
- Time:  O(n) (each element processed once)  
- Space: O(n) (result array)  

---

## 💻 Solution (Java)
*/

class Solution {
    public int[] sortedSquares(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        int[] result = new int[nums.length];
        int currentIndex = nums.length - 1;

        while(start <= end){
            if(nums[start] * nums[start] > nums[end] * nums[end]){
                result[currentIndex] = nums[start] * nums[start] ;
                start++;
            }
            else{
                result[currentIndex] = nums[end] * nums[end] ;
                end--;
            }
                

            currentIndex--;
        }

        return result;
    }
}
