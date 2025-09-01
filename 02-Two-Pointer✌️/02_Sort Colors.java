/*
# 🎯 Problem: Sort Colors
Link : https://leetcode.com/problems/sort-colors/description/

## 📌 Description
Given an array `nums` with `n` objects colored  red ,  white , or  blue ,  
sort them  in-place  so that objects of the same color are adjacent, with the colors in the order:  
-  0 → Red   
-  1 → White   
-  2 → Blue   

You must solve it without using the library's sort function.

---

## 🧩 Example
 Input:  nums = [2,0,2,1,1,0]

 Output:   [0,0,1,1,2,2]


 Input:   nums = [2,0,1]

 Output:   [0,1,2]


---

## 🚀 Approach 
- Maintain  3 pointers :  
  - `start` → boundary for `0`s  
  - `end` → boundary for `2`s  
  - `mid` → current element  

- Traverse the array:  
  - If `nums[mid] == 0` → swap with `start`, move both forward.  
  - If `nums[mid] == 1` → just move `mid`.  
  - If `nums[mid] == 2` → swap with `end`, move `end` backward.  

This ensures all 0s → left, 1s → middle, 2s → right.

---

## ⏱️ Complexity
-  Time:  O(N) (single pass)  
-  Space:  O(1) (in-place sorting)  

---

## 💻 Solution (Java)

*/
class Solution {
    public void sortColors(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int mid = 0;

        while(mid <= end){
            switch(nums[mid]){
                case 0 : 
                    swap(nums, start, mid);
                    start++;
                    mid++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    swap(nums, mid, end);
                    end--;
            }
        }
    }

    private void swap(int[] nums, int pos1, int pos2){
        int temp = nums[pos1];
        nums[pos1] = nums[pos2];
        nums[pos2] = temp;
    }
}
