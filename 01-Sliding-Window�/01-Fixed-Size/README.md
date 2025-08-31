# 🪟 Fixed-Size Sliding Window

**Idea:**  
Used when the window length `K` is constant.  
Instead of recalculating for each window, reuse the previous result by adding the new element and removing the old one.

**Steps:**
1. Set window size `K`.
2. Calculate the first window result.
3. Slide right → Add next element, remove the first.
4. Keep track of max/min/sum as needed.

**Time Complexity:** O(N)

