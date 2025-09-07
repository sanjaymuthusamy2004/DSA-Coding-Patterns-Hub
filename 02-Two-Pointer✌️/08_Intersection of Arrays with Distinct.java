/*
# 🔗 Problem: Intersection of Arrays with Distinct
Link : https://www.geeksforgeeks.org/problems/intersection-of-two-arrays2404/1

## 📌 Description
You are given two unsorted integer arrays `a[]` and `b[]`, each consisting of distinct elements.  
Your task is to return the count of elements in their intersection (common elements).  

The intersection of two arrays is defined as the set containing distinct common elements present in both arrays.

---

## 🧩 Examples

 Input:  
a = [89, 24, 75, 11, 23]  
b = [89, 2, 4]  

 Output:  
1  

 Explanation:  
`89` is the only common element.  

---

 Input:  
a = [1, 2, 4, 3, 5, 6]  
b = [3, 4, 5, 6, 7]  

 Output:  
4  

 Explanation:  
Common elements are `[3, 4, 5, 6]`.  

---

 Input:  
a = [20, 10, 30, 50, 40]  
b = [15, 25, 30, 20, 35]  

 Output:  
2  

 Explanation:  
Common elements are `[20, 30]`.  

---

## 🚀 Approach (Sorting + Two Pointers)

1. Sort both arrays.  
2. Use two pointers (`i`, `j`) to traverse both arrays.  
   - If `a[i] < b[j]`, move `i`.  
   - If `a[i] > b[j]`, move `j`.  
   - If equal, increment count and move both pointers.  
3. The count represents the size of intersection.  

---

## ⏱️ Complexity
- Time:  O(n log n + m log m) (due to sorting)  
- Space: O(1) (in-place, aside from sorting cost)  

---

## 💻 Solution (Java)
*/
class Solution {
    public static int intersectSize(int a[], int b[]) {
        Arrays.sort(a);
        Arrays.sort(b);

        int i = 0, j = 0, count = 0;

        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                i++;
            } else if (a[i] > b[j]) {
                j++;
            } else {
                count++;
                i++;
                j++;
            }
        }

        return count;
    }
}
