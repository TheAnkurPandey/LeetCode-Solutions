class Solution {
    public void setZeroes(int[][] matrix) {
        setZerosSolA(matrix);
    }
    
    private void setZerosSolA(int[][] matrix) {
        // O(m*n*(m + n)) time & O(m*n) space
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        int[][] clone = new int[m][n];
        
        // Clone initialisation
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                clone[row][col] = matrix[row][col];
            }
        }
        
        // Setting zeros in clone
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (matrix[row][col] == 0) {
                    setZerosInRow(clone, row);  // O(n)
                    setZerosInCol(clone, col);  // O(m)
                }
            }
        }
        
        // Set value in orignal matrix
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                matrix[row][col] = clone[row][col];
            }
        }
    }
    
    private void setZerosInRow(int[][] matrix, int row) {
        int n = matrix[0].length;
        for (int c = 0; c < n; c++) matrix[row][c] = 0;
    }
    
    private void setZerosInCol(int[][] matrix, int col) {
        int m = matrix.length;
        for (int r = 0; r < m; r++) matrix[r][col] = 0;
    }
}