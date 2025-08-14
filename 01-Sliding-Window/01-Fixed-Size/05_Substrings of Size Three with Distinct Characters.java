/*
# 🚀 Problem: 1876. Substrings of Size Three with Distinct Characters  
🔗 [View Problem on LeetCode](https://leetcode.com/problems/substrings-of-size-three-with-distinct-characters/)

## 📌 Problem Statement
A string is good if there are no repeated characters.  
Given a string s, return the number of good substrings of length three in s.  
Note: If there are multiple occurrences of the same substring, every occurrence should be counted.

---

## 🔹 Examples

Example 1:  
Input: s = "xyzzaz"  
Output: 1  
Explanation: Substrings of size 3 → "xyz", "yzz", "zza", "zaz"  
Only "xyz" is good.

Example 2:  
Input: s = "aababcabc"  
Output: 4  
Explanation: Substrings of size 3 → "aab", "aba", "bab", "abc", "bca", "cab", "abc"  
Good substrings are "abc", "bca", "cab", "abc".

---

## 💡 Approach (Sliding Window - Fixed Size)
1. Use a window of size 3 and check if all characters in it are distinct.
2. Move the window one step at a time.
3. Count the number of windows that have unique characters.

---

## ⏳ Complexity Analysis
- Time Complexity: O(N) – We scan the string once and check 3 characters per window.
- Space Complexity: O(1) – Only a few variables are used.

---

## 🛠 Java Solution
```java
  */
class Solution {
    public int countGoodSubstrings(String s) {
        int count = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        // Base case
        if(s.length() < 3) return 0;

        // First window
        for(int i = 0; i < 3; i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0) + 1);
        }
        if(map.size()==3) count++;

        int start = 0;
        int end = 3;

        while(end < s.length()){
            // Remove the older element
            map.put(s.charAt(start),map.get(s.charAt(start)) -1 );
            if(map.get(s.charAt(start) ) == 0 ){
                map.remove(s.charAt(start));
            }
            start++;

            // add the new element
            map.put(s.charAt(end), map.getOrDefault(s.charAt(end),0) + 1);
            end++;
            if(map.size() == 3) count++;
        }

        return count;
    }
}
