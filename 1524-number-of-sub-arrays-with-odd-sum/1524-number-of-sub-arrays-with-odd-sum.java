
class Solution {
    public int numOfSubarrays(int[] arr) {
       final int MOD = 1_000_000_007;
        int n = arr.length;
        int sum = 0;
        int even = 1;
        int odd = 0;
        long result = 0;
        for(int i=0;i<n;i++){
            sum += arr[i];
            if(sum % 2 != 0){
                result += even;
                odd++;
            } else {
                result += odd;
                even++;
            }
        }
    return (int)(result % MOD);
    }
}
