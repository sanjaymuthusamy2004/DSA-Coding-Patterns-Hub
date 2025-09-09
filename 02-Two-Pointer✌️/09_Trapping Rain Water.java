/*
# 🔗 Problem: Trapping Rain Water
Link : https://leetcode.com/problems/trapping-rain-water/

## 📌 Description
You are given an array `height[]` of non-negative integers where each value represents the height of a bar in an elevation map (width = 1).  
You need to compute how much water can be trapped between the bars after it rains.

---

## 🧩 Examples

 Input:  
height = [0,1,0,2,1,0,1,3,2,1,2,1]  

 Output:  
6  

 Explanation:  
Water is trapped between the bars, total = `6` units.  

---

 Input:  
height = [4,2,0,3,2,5]  

 Output:  
9  

 Explanation:  
Total water trapped = `9` units.  

---

## 🚀 Approach (Two Pointers)

- Maintain two pointers `left` and `right`.  
- Track `leftMax` and `rightMax` as the tallest bars seen so far.  
- At each step:
  - If `leftMax <= rightMax`, water trapped depends on `leftMax`. Move `left`.  
  - Else, water trapped depends on `rightMax`. Move `right`.  
- Keep adding trapped water for each index.  

---

## ⏱️ Complexity
- Time: **O(n)** (single pass)  
- Space: **O(1)** (constant extra space)  

---

## 💻 Solution (Java)
*/

class Solution {
    public int trap(int[] height) {
        int left = 1;
        int right = height.length - 2;

        int leftMax = height[0];
        int rightMax = height[height.length - 1];

        int result = 0;

        while (left <= right) {
            if (leftMax <= rightMax) {
              
                result += Math.max(0, leftMax - height[left]);
              
                leftMax = Math.max(leftMax, height[left]);
              
                left++;
              
            } 
            else {
              
                result += Math.max(0, rightMax - height[right]);
              
                rightMax = Math.max(rightMax, height[right]);
              
                right--;
            }
        }
        return result;
    }
}
