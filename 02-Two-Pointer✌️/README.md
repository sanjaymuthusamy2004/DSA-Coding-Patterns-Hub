# 🔀 Two Pointer Pattern

## 📌 Introduction
The **Two Pointer** technique uses two indices to traverse arrays or strings efficiently.  
It eliminates the need for nested loops, reducing complexity to **O(N)** in many problems.  

---

## 🎯 When to Use
- ✅ Finding pairs/triplets in arrays  
- ✅ Palindrome checking  
- ✅ Sliding window problems (subarrays/substrings)  
- ✅ Removing duplicates or rearranging arrays  

---

## ⚡ Types of Two Pointers
1. **👉 Opposite Ends** — Start from both ends and move towards the center  
   (e.g., Pair Sum, Palindrome Check)  
2. **👉 Same Direction** — Both pointers move forward  
   (e.g., Sliding Window, Removing Duplicates)  

---

## ⏱️ Complexity
- **Time:** O(N)  
- **Space:** O(1)  

---

## 📝 Example Template
```java
int left = 0, right = arr.length - 1;
while (left < right) {
    // logic here
    left++;
    right--;
}

