class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int n = nums1.length;
        int m = nums2.length;
        int[] ans = new int[Math.max(m,n)];
        int left = 0;
        int right = 0;
        int count = 0;
        while(left<n && right<m){
            if(nums1[left] == nums2[right]){
                if(count == 0 || nums1[left] != ans[count-1]){
                    ans[count++] = nums1[left];
                }
                    left++;
                    right++;
            } else if(nums1[left]<nums2[right] ){
                left++;
            }else {
                right++;
            }
        }
        return Arrays.copyOf(ans, count);
    }
}