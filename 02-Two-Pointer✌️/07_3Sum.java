/*
# 🔗 Problem: 3Sum
Link : https://leetcode.com/problems/3sum/

## 📌 Description
Given an integer array `nums`, return all unique triplets `[nums[i], nums[j], nums[k]]`  
such that:
- `i != j`, `i != k`, `j != k`
- `nums[i] + nums[j] + nums[k] == 0`

The solution set must not contain duplicate triplets.

---

## 🧩 Examples

 Input:  
nums = [-1,0,1,2,-1,-4]  

 Output:  
[[-1,-1,2], [-1,0,1]]  

 Explanation:  
Triplets that sum to `0`:  
- (-1) + 0 + 1 = 0  
- (-1) + (-1) + 2 = 0  

---

 Input:  
nums = [0,1,1]  

 Output:  
[]  

 Explanation: No triplet sums to zero.  

---

 Input:  
nums = [0,0,0]  

 Output:  
[[0,0,0]]  

 Explanation: The only triplet sums to zero.  

---

## 🚀 Approach (Sorting + Two Pointers)

1. **Sort** the array.  
2. Fix one number (`nums[i]`).  
3. Use **two pointers** (`left` and `right`) to find pairs such that:  
   - `nums[i] + nums[left] + nums[right] == 0`.  
   - Move pointers inward based on sum.  
4. Use a **HashSet** (or skip duplicates smartly) to avoid duplicate triplets.  

---

## ⏱️ Complexity
- Time:  **O(n²)** (sorting + two pointer traversal for each element)  
- Space: **O(k)** (number of unique triplets, or O(1) if we output directly)  

---

## 💻 Solution (Java)
*/
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        if (nums == null || n < 3) return new ArrayList<>();

        Arrays.sort(nums);
        HashSet<List<Integer>> result = new HashSet<>();

        for (int i = 0; i < n - 2; i++) {
            int left = i + 1, right = n - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                } else if (sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }

        return new ArrayList<>(result);
    }
}
