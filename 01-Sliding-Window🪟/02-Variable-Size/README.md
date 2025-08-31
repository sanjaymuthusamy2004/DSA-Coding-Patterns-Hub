# 🪟 Variable-Size Sliding Window

**Idea:**  
Window size changes dynamically based on conditions (e.g., sum ≤ target, unique characters).

**Steps:**
1. Use two pointers (`start`, `end`).
2. Expand window until condition fails.
3. Shrink from start until condition is valid.
4. Track the best result.

**Time Complexity:** O(N)
