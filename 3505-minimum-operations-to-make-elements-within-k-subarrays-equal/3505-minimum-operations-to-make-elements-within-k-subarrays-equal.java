
import java.util.*;
class Solution {
    public long minOperations(int[] nums, int x, int k) {
        int n = nums.length;
        int m = n - x + 1;
        long[] cost = new long[m];
        WindowCost window = new WindowCost(x);

        for (int i = 0; i < x; i++) {
            window.add(nums[i]);
        }
        cost[0] = window.getCost();

        for (int i = 1; i < m; i++) {
            window.remove(nums[i - 1]);
            window.add(nums[i + x - 1]);
            cost[i] = window.getCost();
        }

        long INF = Long.MAX_VALUE / 4;
        long[][] dp = new long[k + 1][n + 1];

        for (int j = 0; j <= k; j++) {
            Arrays.fill(dp[j], INF);
        }
        for (int i = 0; i <= n; i++) {
            dp[0][i] = 0;
        }

        for (int j = 1; j <= k; j++) {
            for (int i = 1; i <= n; i++) {
                dp[j][i] = dp[j][i - 1];

                if (i >= x) {
                    int start = i - x;
                    if (dp[j - 1][i - x] != INF) {
                        dp[j][i] = Math.min(dp[j][i], dp[j - 1][i - x] + cost[start]);
                    }
                }
            }
        }
        return dp[k][n];
    }

    class WindowCost {
        TreeMap<Integer, Integer> left = new TreeMap<>();
        TreeMap<Integer, Integer> right = new TreeMap<>();
        long leftSum = 0;
        long rightSum = 0;
        int leftSize = 0;
        int rightSize = 0;
        int targetLeft;

        WindowCost(int x) {
            targetLeft = (x + 1) / 2;
        }

        void add(int num) {
            if (left.isEmpty() || num <= left.lastKey()) {
                addOne(left, num);
                leftSize++;
                leftSum += num;
            } else {
                addOne(right, num);
                rightSize++;
                rightSum += num;
            }
            rebalance();
        }

        void remove(int num) {
            if (left.containsKey(num)) {
                removeOne(left, num);
                leftSize--;
                leftSum -= num;
            } else {
                removeOne(right, num);
                rightSize--;
                rightSum -= num;
            }
            rebalance();
        }

        void rebalance() {
            while (leftSize > targetLeft) {
                int val = left.lastKey();
                removeOne(left, val);
                leftSize--;
                leftSum -= val;
                addOne(right, val);
                rightSize++;
                rightSum += val;
            }

            while (leftSize < targetLeft && rightSize > 0) {
                int val = right.firstKey();
                removeOne(right, val);
                rightSize--;
                rightSum -= val;
                addOne(left, val);
                leftSize++;
                leftSum += val;
            }
        }

        long getCost() {
            long median = left.lastKey();
            long leftCost = median * leftSize - leftSum;
            long rightCost = rightSum - median * rightSize;
            return leftCost + rightCost;
        }

        void addOne(TreeMap<Integer, Integer> map, int val) {
            map.put(val, map.getOrDefault(val, 0) + 1);
        }

        void removeOne(TreeMap<Integer, Integer> map, int val) {
            int count = map.get(val);
            if (count == 1) {
                map.remove(val);
            } else {
                map.put(val, count - 1);
            }
        }
    }
}
