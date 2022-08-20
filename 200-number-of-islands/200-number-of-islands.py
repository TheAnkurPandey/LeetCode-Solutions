class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        # O(m*n) time & O(m*n) space
        
        m = len(grid)
        n = len(grid[0])
        visited = [[False] * n for i in range(m)]
        
        num_of_islands = 0
        for i in range(m):
            for j in range(n):
                if grid[i][j] == '0': continue
                if visited[i][j]: continue
                
                self.depthFirstTraversal(i, j, grid, visited)
                num_of_islands += 1
                
        return num_of_islands
    
                    
    def depthFirstTraversal(self, 
                            src_i: int, src_j: int,
                            grid: List[List[str]], 
                            visited: List[List[bool]]) -> None:
        # Base case
        if src_i < 0 or src_i >= len(grid): return  # Out of boundary
        if src_j < 0 or src_j >= len(grid[0]): return  # Out of boundary
        if grid[src_i][src_j] == '0': return  # Water
        if visited[src_i][src_j]: return  # Visited
        
        visited[src_i][src_j] = True
    
        # Recursive case
        self.depthFirstTraversal(src_i - 1, src_j, grid, visited)  # North
        self.depthFirstTraversal(src_i, src_j + 1, grid, visited)  # East
        self.depthFirstTraversal(src_i + 1, src_j, grid, visited)  # South
        self.depthFirstTraversal(src_i, src_j - 1, grid, visited)  # West
                    
        
        