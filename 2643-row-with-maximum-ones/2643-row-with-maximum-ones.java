class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
       int rows = mat.length;
       int cols = mat[0].length;
       int maxOnes = 0;
       int ans = 0;
       for(int i=0;i<rows;i++){
         int count = 0;
      for(int j = 0; j < cols; j++){
                if(mat[i][j] == 1){
                    count++;
                }
            } 
             if(count > maxOnes){
                maxOnes = count;
                ans = i;
             }
    }
    return new int[]{ans, maxOnes};
     }
}