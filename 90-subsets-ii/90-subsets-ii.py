class Solution:
    def subsetsWithDup(self, nums: List[int]) -> List[List[int]]:
        nums.sort()  # Sorting
        
        depth = 0
        partial = []
        solutions = []
        self.generate_subsets(nums, depth, partial, solutions, False)
        
        return solutions
    
    def generate_subsets(self, nums: List[int], 
                         depth: int, partial: List[int], 
                         solutions: List[List[int]], choosenPrev: bool) -> None:
        # O(2^n) time & O(n) space
        
        # Base case
        if depth == len(nums):
            solutions.append(partial[:])
            return
        
        # Recursive case
        # Take a move            
        self.generate_subsets(nums, depth + 1, partial, solutions, False)
        # Undo a move
        
        # Early backtracking
        if not choosenPrev and depth > 0 and nums[depth] == nums[depth - 1]:
            return
        
        partial.append(nums[depth])  # Take a move
        self.generate_subsets(nums, depth + 1, partial, solutions, True)
        partial.pop()  # Undo a move
        
        return