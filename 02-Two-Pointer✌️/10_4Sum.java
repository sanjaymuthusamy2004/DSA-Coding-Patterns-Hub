/*
# 🔗 Problem: 4Sum
Link : https://leetcode.com/problems/4sum/

## 📌 Description
You are given an integer array `nums` and an integer `target`.  
Your task is to return all the **unique quadruplets** `[nums[a], nums[b], nums[c], nums[d]]` such that:

- `0 <= a, b, c, d < n`
- `a, b, c, and d` are distinct
- `nums[a] + nums[b] + nums[c] + nums[d] == target`

The solution set must not contain duplicate quadruplets.

---

## 🧩 Examples

 Input:  
nums = [1,0,-1,0,-2,2], target = 0  

 Output:  
[[-2,-1,1,2], [-2,0,0,2], [-1,0,0,1]]  


 Input:  
nums = [2,2,2,2,2], target = 8  

 Output:  
[[2,2,2,2]]  

---

## 🚀 Approach (Sorting + Two Pointers)

1. Sort the array.  
2. Fix the first two numbers using indices `i` and `j`.  
3. Use **two pointers** (`left`, `right`) to find remaining two numbers.  
4. If the sum equals target, store the quadruplet in a set (to avoid duplicates).  
5. Adjust pointers based on whether the sum is less than or greater than target.  
6. Return all unique quadruplets.

---

## ⏱️ Complexity
- Time: **O(n³)** (three nested loops with two-pointer search)  
- Space: **O(k)** for storing results (where `k` = number of unique quadruplets)  

---

## 💻 Solution (Java)
*/
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {

        HashSet<List<Integer>> HS = new HashSet<>();
        Arrays.sort(nums);

        int n = nums.length;
        if (nums == null || n < 4) return new ArrayList<>();

        for (int i = 0; i < n - 3; i++) {
            for (int j = i + 1; j < n - 2; j++) {

                int left = j + 1;
                int right = n - 1;

                while (left < right) {
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];

                    if (sum == target) {
                        HS.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        left++;
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return new ArrayList<>(HS);
    }
}
