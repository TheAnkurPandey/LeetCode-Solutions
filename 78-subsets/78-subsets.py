class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        depth = 0
        partial = []
        solutions = []
        self.generate_subsets(nums, depth, partial, solutions)
        return solutions
    
    def generate_subsets(self, nums: List[int], 
                         depth: int, partial: List[int], 
                         solutions: List[List[int]]) -> None:
        # O(2^n) time & O(n) space
        
        # Base case
        if depth == len(nums):
            solutions.append(partial[:])
            return
        
        
        # Rcursive case
        # Take move
        self.generate_subsets(nums, depth + 1, partial, solutions)
        # undo move
        
        partial.append(nums[depth])  # Take move
        self.generate_subsets(nums, depth + 1, partial, solutions)
        partial.pop()  # Undo move