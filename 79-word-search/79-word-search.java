class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        
        boolean isExist = false;
        boolean[][] visited = new boolean[m][n];
        
        // Taking each cell of board as start of word
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                
                int startIndex = 0;
                isExist = backtrackSearch(board, row, col, word, startIndex, visited);
                
                if (isExist) return true;  // Found the word, No need to search any more
            }
        }
        
        return false;  // Word not found
    }
    
    private boolean backtrackSearch(char[][] board, 
                                   int row, int col, 
                                   String word, int startIndex, 
                                   boolean[][] visited) {
        // Backtracking
        // O(m*n) time & O(m*n) space
        
        // Base case (Backtrack)
        // Entire string processed, No mimatch found
        if (startIndex == word.length()) return true;
        
        if (row < 0 || row >= board.length) return false;  // Row out of bound
        if (col < 0 || col >= board[0].length) return false;  // Column out of bound
        if (visited[row][col]) return false;  // Already visited
        if (board[row][col] != word.charAt(startIndex)) return false;  // Mismatch found
        
        
        // Take move
        visited[row][col] = true; // Set it visited
        
        // Recursive case
        boolean top = backtrackSearch(board, row - 1, col, word, startIndex + 1, visited);
        boolean right = top || 
            backtrackSearch(board, row, col + 1, word, startIndex + 1, visited);  // Right
        boolean bottom = right || 
            backtrackSearch(board, row + 1, col, word, startIndex + 1, visited);  // Bottom
        boolean left = bottom || 
            backtrackSearch(board, row, col - 1, word, startIndex + 1, visited);  // Left
        boolean wordExist = left;
        
        // Undo move
        visited[row][col] = false;
        
        return wordExist;
    }
}