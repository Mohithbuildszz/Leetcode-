class Solution {
    public int maxLength(int[] nums) {
        int n = nums.length;
        int answer = 0;
       for (int i = 0; i < n; i++) {
        long product = 1;
        long greatestCommonFactor = 0;
        long lcm = 1;
    for (int j = i; j < n; j++) {
        product *= nums[j];
        greatestCommonFactor = gcd(greatestCommonFactor, nums[j]);
         lcm = lcm(lcm, nums[j]);
        if(product == lcm * greatestCommonFactor){
            answer = Math.max(answer, j-i+1);
        }
    }
}
return answer;
    } private long gcd(long a,long b){
        return b == 0 ? a : gcd(b, a%b);
} 
            private long lcm(long a, long b) {
            return (a / gcd(a, b)) * b;
        }
}