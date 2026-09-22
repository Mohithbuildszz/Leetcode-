class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        
        int[] ans = new int[n - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();

        int left = 0;
        int right = 0;
        int index = 0;

        while (right < n) {
            // Remove smaller elements from back
            while (!deque.isEmpty() &&
                   nums[deque.peekLast()] < nums[right]) {
                deque.pollLast();
            }
            // Add current index
            deque.addLast(right);

            // Remove elements outside the window
            if (deque.peekFirst() < left) {
                deque.pollFirst();
            }

            // Window size = k
            if (right - left + 1 == k) {
                // Front contains maximum
                ans[index++] = nums[deque.peekFirst()];
                // Move window
                left++;
            }
            right++;
        }
        return ans;
    }
}