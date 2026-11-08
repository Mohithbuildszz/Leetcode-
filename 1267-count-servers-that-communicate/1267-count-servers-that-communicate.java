
class Solution {
    public int countServers(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == 1) {

                    boolean canCommunicate = false;

                    // Check the same row
                    for (int k = 0; k < n; k++) {
                        if (k != j && grid[i][k] == 1) {
                            canCommunicate = true;
                            break;
                        }
                    }

                    // Check the same column
                    for (int k = 0; k < m; k++) {
                        if (k != i && grid[k][j] == 1) {
                            canCommunicate = true;
                            break;
                        }
                    }

                    if (canCommunicate) {
                        count++;
                    }
                }
            }
        }

        return count;
    }
}
