/*
# 🚀 Problem: 1456. Maximum Number of Vowels in a Substring of Given Length  
🔗 [View Problem on LeetCode](https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/)

## 📌 Problem Statement
You are given a string `s` and an integer `k`.  
Return the maximum number of vowels in any substring of `s` with length `k`.

Vowels are `'a'`, `'e'`, `'i'`, `'o'`, and `'u'`.

---

## 🔹 Examples

Example 1:  
Input: s = "abciiidef", k = 3  
Output: 3  
Explanation: `"iii"` contains 3 vowels.

Example 2:  
Input: s = "aeiou", k = 2  
Output: 2  
Explanation: Every substring of length 2 contains 2 vowels.

Example 3:  
Input: s = "leetcode", k = 3  
Output: 2  
Explanation: `"lee"`, `"eet"`, and `"ode"` contain 2 vowels.

---

## 🏷 Pattern  - Sliding Window

---

## 💡 Approach
1. Count vowels in the first `k` characters.  
2. Use a sliding window:
   - Remove the leftmost character from the count if it's a vowel.  
   - Add the new rightmost character if it's a vowel.  
3. Keep track of the **maximum vowel count** seen.

---

## ⏳ Complexity Analysis
- Time Complexity: O(N) — each character is processed once.  
- Space Complexity: O(1) — only counters and pointers are used.

---

## 🛠 Java Solution
```java
*/
class Solution {
    public int maxVowels(String s, int k) {
        int currentVowel = 0;

        // First window
        for(int i = 0; i < k; i++ ){
            char vowel = s.charAt(i);

            if(isVowel(vowel)){
                currentVowel++;
            }
        }

        int maxVowel = currentVowel;

        int start = 0;
        int end = k;

        while(end < s.length()){
            char vowels = s.charAt(start);
            if(isVowel(vowels) ){
                currentVowel = currentVowel - 1;
            }
             start++;
             char vowelEnd = s.charAt(end);
            if(isVowel(vowelEnd)){
                currentVowel++;
            }
            end++;

            maxVowel = Math.max(maxVowel, currentVowel);


        }
        return maxVowel;
    }

    public static boolean isVowel(char vowel){
        if(vowel == 'a' || vowel == 'e' || vowel == 'i' || vowel == 'o' || vowel == 'u' )
            return true;
        
        return false;
    }
}
