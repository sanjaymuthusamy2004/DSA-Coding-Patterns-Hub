/*
# 🚀 Problem: Count Distinct Elements in Every Window  
🔗 [View Problem on GeeksforGeeks](https://www.geeksforgeeks.org/problems/count-distinct-elements-in-every-window/)

## 📌 Problem Statement
Given an integer array arr[] and an integer k,  
find the count of distinct elements in every subarray (window) of size k.

---

## 🔹 Examples

Example 1:  
Input: arr = [1, 2, 1, 3, 4, 2, 3], k = 4  
Output: [3, 4, 4, 3]  
Explanation:  
- Window [1, 2, 1, 3] → 3 distinct elements  
- Window [2, 1, 3, 4] → 4 distinct elements  
- Window [1, 3, 4, 2] → 4 distinct elements  
- Window [3, 4, 2, 3] → 3 distinct elements  

Example 2:  
Input: arr = [4, 1, 1], k = 2  
Output: [2, 1]  

Example 3:  
Input: arr = [1, 1, 1, 1, 1], k = 3  
Output: [1, 1, 1]  

---

## 💡 Approach (Fixed-Size Sliding Window + HashMap)
1. Use a HashMap to store the frequency of elements in the current window.
2. For the first window, fill the map and record the distinct count.
3. Slide the window:
   - Remove the frequency of the outgoing element (reduce count or remove if zero).
   - Add the new incoming element.
4. Store the distinct count after each slide.

---

## ⏳ Complexity Analysis
- Time Complexity: O(N) – Each element is added/removed from HashMap at most once.
- Space Complexity: O(K) – HashMap stores at most k elements.

---

## 🛠 Java Solution
```java
*/
import java.util.*;

class Solution {
    ArrayList<Integer> countDistinct(int arr[], int k) {
        // code here
        ArrayList<Integer> result = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        
        // Find first K window size distinct element
        for(int i = 0; i < k; i++){
            map.put(arr[i], map.getOrDefault(arr[i],0)+1);
        }
        result.add(map.size());
        
        int start = 0;
        int end = k;
        while(end  < arr.length){
          // Remove outgoing element
            map.put(arr[start], map.get(arr[start]) - 1);
           
            
            if(map.get(arr[start]) == 0){
                map.remove(arr[start]);
            }
             start++;
          // Add incoming element
            map.put(arr[end], map.getOrDefault(arr[end],0)+1);
            end++;
            
            result.add(map.size());
        }
        return result;
    }
}
