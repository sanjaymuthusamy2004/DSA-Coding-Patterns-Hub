/*
# 🔗 Problem: Union of two sorted arrays
Link : https://www.geeksforgeeks.org/problems/union-of-two-sorted-arrays-1587115621/1

## 📌 Description
You are given two sorted arrays ` nums1` and ` nums2`, which may contain duplicate elements.  
Your task is to return the  union  of the two arrays in  sorted order , containing only  distinct elements .

Union of two arrays can be defined as the set containing all distinct elements present in either of the arrays.

---

## 🧩 Examples
  
 Input:   
a = [1, 2, 3, 4, 5]
b = [1, 2, 3, 6, 7]
  
 Output:   
[1, 2, 3, 4, 5, 6, 7]


 Input:   
a = [2, 2, 3, 4, 5]
b = [1, 1, 2, 3, 4]

 Output:   
[1, 2, 3, 4, 5]


 Input:   
a = [1, 1, 1, 1, 1]
b = [2, 2, 2, 2, 2]

 Output:   
[1, 2]


---

## 🚀 Approach (Two Pointers)
  
- Use  two pointers  `i` and `j` to traverse both arrays simultaneously.  
- Compare elements at ` nums1` and ` nums2`.  
  - If smaller, add it to result (if not duplicate).  
  - If larger, add the other element.  
  - If equal, add one and move both pointers.  
- Add remaining elements from both arrays (avoiding duplicates).  

This ensures sorted distinct union.

---

## ⏱️ Complexity
-  Time:  O(n + m)  
-  Space:  O(n + m) (for result)  

---

## 💻 Solution (Java)
*/
class Solution {
    public static ArrayList<Integer> findUnion(int nums1[], int nums2[]) {
        int i = 0, j = 0;
        ArrayList<Integer> union = new ArrayList<>();

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                if (union.size() == 0 || union.get(union.size() - 1) != nums1[i]) {
                    union.add(nums1[i]);
                }
                i++;
            } else if (nums1[i] > nums2[j]) {
                if (union.size() == 0 || union.get(union.size() - 1) != nums2[j]) {
                    union.add(nums2[j]);
                }
                j++;
            } else {
                if (union.size() == 0 || union.get(union.size() - 1) != nums1[i]) {
                    union.add(nums1[i]);
                }
                i++;
                j++;
            }
        }

        // Remaining elements in nums1
        while (i < nums1.length) {
            if (union.size() == 0 || union.get(union.size() - 1) != nums1[i]) {
                union.add(nums1[i]);
            }
            i++;
        }

        // Remaining elements in nums2
        while (j < nums2.length) {
            if (union.size() == 0 || union.get(union.size() - 1) != nums2[j]) {
                union.add(nums2[j]);
            }
            j++;
        }

        return union;
    }
}
