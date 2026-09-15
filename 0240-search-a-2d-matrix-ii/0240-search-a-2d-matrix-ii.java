class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m= matrix[0].length;
        int[] row = new int[n];
        int[] cols = new int[m];
        boolean result = false;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j] == target){
                    result = true;
                    return result;
                }
            }
        }
        return false;
    }
}