class Solution:
    def solve(self, board: List[List[str]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        max_x, max_y = len(board), len(board[0])
        
        # Traverse topmost row
        for src_y in range(max_y):
            self.boundary_dfs(board, 0, src_y)
            
        # Traverse rightmost column
        for src_x in range(max_x):
            self.boundary_dfs(board, src_x, max_y - 1)
            
        # Traverse bottomost row
        for src_y in range(max_y):
            self.boundary_dfs(board, max_x - 1, src_y)
            
        # Traverse leftmost column
        for src_x in range(max_x):
            self.boundary_dfs(board, src_x, 0)
            
        # Update board
        for i in range(max_x):
            for j in range(max_y):
                if board[i][j] == 'O':
                    board[i][j] = 'X'
                elif board[i][j] == 'B':
                    board[i][j] = 'O'
                
    
    
    def boundary_dfs(self, board: List[List[str]], src_x: int, src_y: int):
        # O(m*n) time & O(1) space
        
        min_x, min_y = 0, 0
        max_x, max_y = len(board) - 1, len(board[0]) - 1
        
        # Base case
        if src_x < min_x or src_x > max_x: return  # Out of board
        if src_y < min_y or src_y > max_y: return  # Out of board
        
        if board[src_x][src_y] == 'X': return  # Invalid node
        if board[src_x][src_y] == 'B': return  # Visited node
        
        board[src_x][src_y] = 'B'
        
        # Recursive case
        self.boundary_dfs(board, src_x - 1, src_y)  # Top
        self.boundary_dfs(board, src_x, src_y + 1)  # Left
        self.boundary_dfs(board, src_x + 1, src_y)  # Bottom
        self.boundary_dfs(board, src_x, src_y - 1)  # Right