/*
# 🔠 Problem : Longest Substring Without Repeating Characters
  🔠  Problem Link : https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
  
## 📌 Problem Statement  
You are given a string `s`. You need to find the  length of the longest substring  that contains  all distinct characters .  

---

## 🔹 Examples  

 Example 1:   
Input: s = "geeksforgeeks"  
Output: 7  
Explanation: `"eksforg"` is the longest substring with all distinct characters.  

 Example 2:   
Input: s = "aaa"  
Output: 1  
Explanation: `"a"` is the longest substring with all distinct characters.  

 Example 3:   
Input: s = "abcdefabcbb"  
Output: 6  
Explanation: `"abcdef"` is the longest substring with all distinct characters.  

---

## 🏷 Pattern  
 Sliding Window + HashMap   

---

## 💡 Approach  
1. Use a sliding window with two pointers (`start`, `end`).  
2. Maintain a HashMap storing the  last index  of each character.  
3. If a character repeats, move `start` .
4. Update the maximum length at each step.  

---

## ⏳ Complexity Analysis  
-  Time Complexity:  O(N) → each character is visited at most twice.  
-  Space Complexity:  O(26) = O(1) → since only lowercase English letters.  

---

## 🛠 Java Solution  
*/
class Solution {
    public int longestUniqueSubstr(String s) {
        // code here
        HashMap<Character,Integer> map = new HashMap<>();

        int maxLength = Math.min(s.length(),1);

        int start = 0;
        int end = 0;

        while(end < s.length()){
            if( !map.containsKey(s.charAt(end)) ){
                map.put(s.charAt(end),end);
                end++;
            }else{
                while(! map.containsKey(s.charAt(end))){
                    start++;
                }
                map.remove(s.charAt(start));
                start++;
            }

            maxLength = Math.max(maxLength,end-start);

        }
        return maxLength;
    }
}
