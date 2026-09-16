class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int top = 0;
        int bottom = n - 1;
        int left = 0;
        int right = n - 1;
        int nums = 1;
        while(left<=right&&top<=bottom){
            for(int i=left;i<=right;i++){
                matrix[top][i] = nums++;
            }
            top++;
      for (int i=top;i<=bottom;i++){
                matrix[i][right]=nums++;
            }
            right--;
        if(top<=bottom){
            for (int j =right;j>=left;j--) {
                  matrix[bottom][j] = nums++;
                }
             bottom--;
        }
        if(left<=right){
            for(int i=bottom;i>=top;i--){
                matrix[i][left] = nums++;
            }
            left++;
            }
        }
        return matrix;
    }
}