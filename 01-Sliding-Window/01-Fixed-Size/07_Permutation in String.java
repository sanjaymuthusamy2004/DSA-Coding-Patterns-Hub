/*
# 🚀 Problem: 567. Permutation in String  
🔗 [View Problem on LeetCode](https://leetcode.com/problems/permutation-in-string/)

## 📌 Problem Statement
Given two strings `s1` and `s2`, return `true` if `s2` contains a permutation of `s1`, otherwise return `false`.  

In other words, return `true` if one of `s1`'s permutations is a substring of `s2`.

---

## 🔹 Examples

Example 1:  
Input: s1 = "ab", s2 = "eidbaooo"  
Output: true  
Explanation: s2 contains "ba", which is a permutation of "ab".  

Example 2:  
Input: s1 = "ab", s2 = "eidboaoo"  
Output: false  

---

## 🏷 Pattern  
**Fixed Sliding Window**

---

## 💡 Approach (Sliding Window + Frequency Count)
1. Count frequency of characters in s1.  
2. Use a window of size `s1.length()` to slide over s2.  
3. Compare frequency arrays at each step.  
4. If they match, return `true`; if no match after traversal, return `false`.

---

## ⏳ Complexity Analysis
- **Time Complexity:** O(N) – One pass over s2, constant-size frequency checks.  
- **Space Complexity:** O(1) – Two arrays of size 26.

---

## 🛠 Java Solution
```java
*/

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // Base case
        if(s1.length() > s2.length()) return false;

        int[] s1array = new int[26];
        int[] s2array = new int[26];
        
        // First window
        for(int i = 0 ; i < s1.length(); i++){
            s1array[s1.charAt(i) - 'a']++;
            s2array[s2.charAt(i) - 'a']++;
        }

        if(Arrays.equals(s1array, s2array)) return true;

        int start = 0;
        int end = s1.length();

        // Sliding the winow
        while(end < s2.length()){
            s2array[s2.charAt(start) - 'a']--;
            start++;
            s2array[s2.charAt(end) - 'a']++;
            end++;

            if(Arrays.equals(s1array, s2array)) return true;

        }

        return false;
    }
}
