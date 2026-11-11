class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        long c1 = cost1;
        long c2 = cost2;
        long cb = costBoth;
        long n1 = need1;
        long n2 = need2;
        long case1 = n1 * c1 + n2 * c2;
        long common = Math.min(n1,n2);
        long case2 = common * cb + (n1-common) * c1 + (n2 - common) * c2;                                   
        long case3 = Math.max(n1, n2) * cb;
        long minOps = Math.min(case2,case3);
        return Math.min(case1, minOps);
    }
}