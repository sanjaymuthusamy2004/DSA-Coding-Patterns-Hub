/*
# 🚀 Problem: 438. Find All Anagrams in a String  
🔗 [View Problem on LeetCode](https://leetcode.com/problems/find-all-anagrams-in-a-string/)

## 📌 Problem Statement
Given two strings s and p, return an array of all the start indices of p's anagrams in s.  
You may return the answer in any order.

---

## 🔹 Examples

Example 1:  
Input: s = "cbaebabacd", p = "abc"  
Output: [0, 6]  
Explanation:  
- Substring at index 0 → "cba" → anagram of "abc"  
- Substring at index 6 → "bac" → anagram of "abc"

Example 2:  
Input: s = "abab", p = "ab"  
Output: [0, 1, 2]  
Explanation:  
- Substring at index 0 → "ab" → anagram of "ab"  
- Substring at index 1 → "ba" → anagram of "ab"  
- Substring at index 2 → "ab" → anagram of "ab"

---

## 💡 Approach (Sliding Window + Frequency Count)
1. Count frequency of each character in p.  
2. Maintain a sliding window of length `p.length()` over s.  
3. Keep track of frequency in current window and compare with p's frequency.  
4. If they match, record the start index.

---

## ⏳ Complexity Analysis
- Time Complexity: O(N) – One pass over s with constant-time frequency comparison.  
- Space Complexity: O(1) – Frequency arrays of fixed size (26 letters).

---

## 🛠 Java Solution
```java
*/

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        ArrayList<Integer> list = new ArrayList<>();
        if(p.length() > s.length()) return list;
        
        int[] phash = new int[26];
        int[] shash = new int[26];
        
        // First Window
        for(int i = 0; i < p.length();i++){
            phash[p.charAt(i) - 'a']++;
            shash[s.charAt(i) - 'a']++;
        }

        if(Arrays.equals(phash,shash)){
            list.add(0);
        }

        int start = 0;
        int end = p.length();

        while(end < s.length()){
            // Removing the old character
           shash[s.charAt(start) - 'a']--;
           start++;
            // Adding the new character
           shash[s.charAt(end) - 'a']++;
           end++;

            if(Arrays.equals(phash,shash))
                list.add(start); 
        }

        return list;
    }

}
