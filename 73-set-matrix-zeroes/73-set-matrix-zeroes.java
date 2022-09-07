class Solution {
    public void setZeroes(int[][] matrix) {
        // setZeroesSolA(matrix);
        // setZeroesSolB(matrix);
        setZeroesSolC(matrix);
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
        
        // Getting value of zerosmarker for row & column
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
    
    private void setZeroesSolC(int[][] matrix) {
        // O(m + n) time & O(1) space
        
        int rMax = matrix.length;  // # Rows
        int cMax = matrix[0].length;  // # Columns
        
        int firstRowMarker = 1;
        
        // Getting values of row & column markers
        // Marker fields are already scanned before setting its value based on other values
        for (int r = 0; r < rMax; r++) {
            for (int c = 0; c < cMax; c++) {
                if (matrix[r][c] == 0) {
                    if (r == 0) firstRowMarker = 0;
                    else matrix[r][0] = 0;  // Set the row marker to 0
                    matrix[0][c] = 0;  // Set the col marker to 0
                }
            }
        }
        
        // Setting value of Matrix based on marker
        // Caution: make sure marker field are set to zeros at the end
        for (int r = 1; r < rMax; r++) {
            if (matrix[r][0] == 0) {
                for (int c = 1; c < cMax; c++) matrix[r][c] = 0;
            }
        }
        
        for (int c = 0; c < cMax; c++) {
            if (matrix[0][c] == 0) {  // Set entire column as zero
                for (int r = 1; r < rMax; r++) matrix[r][c] = 0;
            }
        }        
        
        if (firstRowMarker == 0) {  // Set entire first row as zero
            for (int c = 0; c < cMax; c++) matrix[0][c] = 0;
        }
    }
}