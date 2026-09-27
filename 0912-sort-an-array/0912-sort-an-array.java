class Solution {
    public int[] sortArray(int[] nums) {
        mergeSortHelper(nums,0,nums.length-1);
        return nums;
    }
    private void mergeSortHelper(int[] nums,int left,int right) {
        // Base condition
        if (left >= right) {
            return;
        }
        int mid = left+(right-left)/2;
        mergeSortHelper(nums,left,mid);   // Sort left half
        mergeSortHelper(nums,mid+1,right); // Sort right half
        merge(nums,left,mid,right); // Merge both halves
    }   private void merge(int[] nums,int left,int mid,int right) {
        int[] temp = new int[right-left+1];
        int i = left;
        int j = mid + 1;
        int k = 0;
        while (i<=mid && j<=right) { // Compare both halves
            if (nums[i] <= nums[j]) {
                temp[k] = nums[i];
                i++;
            } else {
                temp[k] = nums[j];
                j++;
            }
            k++;
        }
        while(i<=mid) { // Remaining left elements
            temp[k] = nums[i];
            i++;
            k++;
        }
        while(j<=right) {         // Remaining right elements
            temp[k] = nums[j];
            j++;
            k++;
        }
        for(int x=0;x<temp.length;x++) {   // Copy temp back to nums
            nums[left+x] = temp[x];
        }
    }
}