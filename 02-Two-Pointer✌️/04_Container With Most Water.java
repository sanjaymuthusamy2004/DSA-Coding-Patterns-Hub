/*
# 🔗 Problem: Container With Most Water
Link : https://leetcode.com/problems/container-with-most-water/

## 📌 Description
You are given an integer array `height` of length `n`. There are `n` vertical lines drawn such that 
the two endpoints of the i-th line are `(i, 0)` and `(i, height[i])`.

Find two lines that, together with the x-axis, form a container, such that the container can store the
**maximum amount of water**.  
You may not slant the container.

---

## 🧩 Examples

 Input:  height = [1,8,6,2,5,4,8,3,7]  

 Output:  49  
 Explanation: Choosing lines at index 1 and 8 forms the container with area 49.  


 Input:  height = [1,1]  

 Output:  1  

---

## 🚀 Approach (Two Pointers)

- Use two pointers: `left` at the start and `right` at the end.  
- Compute area as:  
  `area = min(height[left], height[right]) * (right - left)`  
- Update `maxArea` whenever a larger area is found.  
- Move the pointer with the **smaller height** inward, because it limits the container height.  
- Continue until `left < right`.

---

## ⏱️ Complexity
- Time:  O(n) (each element is visited at most once)  
- Space: O(1) (constant extra space)  

---

## 💻 Solution (Java)
*/
class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        
        int maxArea = 0;

        while(left < right){
            // area = height * width
            int area = Math.min(height[left],height[right])  * (right - left);

            maxArea = Math.max(maxArea,area);

            if(height[left] < height[right])
                left++;
            else
                right--;
        }


        return maxArea;
    }
