class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
      int low = 0;
      int high = cols - 1;
      while(low <= high){
        int mid = (low + high) / 2;
        int rowsss = maxii(mat,mid);
        int left = mid - 1 >= 0 ? mat[rowsss][mid-1] : Integer.MIN_VALUE;
        int right = mid + 1 < cols ? mat[rowsss][mid+1] : Integer.MIN_VALUE;
        if(mat[rowsss][mid] > left && mat[rowsss][mid] > right){
            return new int[]{rowsss,mid};
        } else if (left > mat[rowsss][mid]){
            high = mid - 1;
        } else {
            low = mid + 1;
        }
      }
      return new int[]{-1,-1}; 
    } public int maxii(int[][] mat,int cols){
        int n = mat.length;
        int max = Integer.MIN_VALUE;
        int index = -1;
        for(int i=0;i<n;i++){
            if(mat[i][cols] > max){
                max = mat[i][cols];
                index = i;
            }
        }
        return index;
    }
}