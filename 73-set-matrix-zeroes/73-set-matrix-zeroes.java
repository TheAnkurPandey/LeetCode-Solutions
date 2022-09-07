class Solution {
    public void setZeroes(int[][] matrix) {
        // setZeroesSolA(matrix);
        setZeroesSolB(matrix);
    }
    
    private void setZeroesSolA(int[][] matrix) {
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
                    setZeroesInRow(clone, row);  // O(n)
                    setZeroesInCol(clone, col);  // O(m)
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
    
    private void setZeroesInRow(int[][] matrix, int row) {
        int n = matrix[0].length;
        for (int c = 0; c < n; c++) matrix[row][c] = 0;
    }
    
    private void setZeroesInCol(int[][] matrix, int col) {
        int m = matrix.length;
        for (int r = 0; r < m; r++) matrix[r][col] = 0;
    }
    
    private void setZeroesSolB(int[][] matrix) {
        // O(m*n) time & O(m + n) space
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        boolean[] rowZerosMarker = new boolean[m];
        boolean[] colZerosMarker = new boolean[n];
        
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (matrix[r][c] == 0) {
                    rowZerosMarker[r] = true;
                    colZerosMarker[c] = true;
                }
            }
        }
        
        // Setting row as zeros
        for (int r = 0; r < m; r++) {
            if (rowZerosMarker[r]) {
                for (int c = 0; c < n; c++) matrix[r][c] = 0;
            }
        }
        
        // Setting col as zeros
        for (int c = 0; c < n; c++) {
            if (colZerosMarker[c]) {
                for (int r = 0; r < m; r++) matrix[r][c] = 0;
            }
        } 
    }
}