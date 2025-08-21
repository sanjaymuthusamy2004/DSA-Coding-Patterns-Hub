/*
# 🍎 Problem: 904. Fruit Into Baskets  
🔗 [View Problem on LeetCode](https://leetcode.com/problems/fruit-into-baskets/)  

## 📌 Problem Statement  
You are given an array `fruits` where `fruits[i]` is the type of fruit the `i-th` tree produces.  

Rules:  
1. You have  2 baskets , and each basket can only hold  one type  of fruit.  
2. Starting from any tree, you must pick  exactly one fruit  per tree as you move right.  
3. You must stop when a tree produces a fruit that cannot fit into your baskets.  

Return the  maximum number of fruits  you can collect.  

---

## 🔹 Examples  

 Example 1:   
Input: fruits = [1,2,1]  
Output: 3  
Explanation: Pick from all 3 trees.  

 Example 2:   
Input: fruits = [0,1,2,2]  
Output: 3  
Explanation: Best choice is trees `[1,2,2]`.  

 Example 3:   
Input: fruits = [1,2,3,2,2]  
Output: 4  
Explanation: Best choice is `[2,3,2,2]`.  

---

## 🏷 Pattern  
 Sliding Window + HashMap   

---

## 💡 Approach  
1. Use a sliding window with two pointers (`start`, `end`).  
2. Expand the window by adding fruits to a HashMap (key = fruit type, value = count).  
3. If the window has more than 2 types, shrink it from the left until only 2 remain.  
4. Track the  maximum window size  at each step.  

---

## ⏳ Complexity Analysis  
-  Time Complexity:  O(N) → each fruit is added/removed from the map at most once.  
-  Space Complexity:  O(1) → at most 2 fruit types in the HashMap.  

---

## 🛠 Java Solution  
*/
class Solution {
    public int totalFruit(int[] fruits) {
        int maxlength = 0;
        int start = 0, end = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        while (end < fruits.length) {
            // Add fruit at 'end' to the map
            map.put(fruits[end], map.getOrDefault(fruits[end], 0) + 1);
            end++;

            // Shrink window if more than 2 fruit types
            while (map.size() > 2) {
                map.put(fruits[start], map.get(fruits[start]) - 1);
                if (map.get(fruits[start]) == 0) {
                    map.remove(fruits[start]);
                }
                start++;
            }

            maxlength = Math.max(maxlength, end - start);
        }
        return maxlength;
    }
}
