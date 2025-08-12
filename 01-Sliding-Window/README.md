# 🪟 Sliding Window Pattern

## 📌 Overview
The **Sliding Window** pattern is a technique used to reduce the complexity of problems that involve arrays or strings.  
Instead of recalculating results for overlapping sections, we **"slide"** a fixed-size or variable-size window across the data to reuse computations.

This pattern is very useful when:
- You need to find subarrays/substrings with specific conditions (sum, length, character set, etc.)
- You need to calculate running values efficiently
- You want to avoid nested loops and reduce time complexity

---

## 📖 How It Works
1. **Initialize** a window (start and end pointers)
2. **Expand** the window to include new elements
3. **Shrink** the window when a condition is violated
4. **Track** the result while sliding

---

## ⏳ Time Complexity
- **Best case**: O(N) – each element is visited at most twice (once when added, once when removed)

---

## 🛠 Steps to Solve Sliding Window Problems
1. Identify if the problem deals with **contiguous elements**
2. Choose **fixed-size** or **variable-size** window
3. Keep track of the **current state** (sum, count, set, etc.)
4. Move the window **forward** while updating the result

---

## 📌 Tips
- Fixed-size windows often involve simple sums/averages.
- Variable-size windows are common in substring problems.
- Watch out for **edge cases**: empty input, K > array size, special characters.

---
