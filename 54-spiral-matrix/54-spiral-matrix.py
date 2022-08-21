class Solution:
    def spiralOrder(self, matrix: List[List[int]]) -> List[int]:
        # O(m*n) time & O(1) space
        
        m = len(matrix)
        n = len(matrix[0])
        total = m * n
        
        output = [0] * total
        processed = 0
        min_row, max_row = 0, m - 1
        min_col, max_col = 0, n - 1
        
        while processed < total:
            # Top wall (Left to right) 
            for i in range(min_col, max_col + 1):
                if processed >= total: break
                    
                output[processed] = matrix[min_row][i]
                processed += 1
                
            min_row += 1
                
            # Right wall (Top to bottom)
            for i in range(min_row, max_row + 1):
                if processed >= total: break
                    
                output[processed] = matrix[i][max_col]
                processed += 1
                
            max_col -= 1
                
            # Bottom wall (Right to left)
            for i in range(max_col, min_col - 1, -1):
                if processed >= total: break
                    
                output[processed] = matrix[max_row][i]
                processed += 1
                
            max_row -= 1
            
            # Left wall (Bottom to top)
            for i in range(max_row, min_row - 1, -1):
                if processed >= total: break
                    
                output[processed] = matrix[i][min_col]
                processed += 1
                
            min_col += 1
            
        return output
            