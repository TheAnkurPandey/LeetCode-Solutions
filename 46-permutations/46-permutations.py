class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        length = len(nums)
        used = [False] * length
        partial = []
        solutions =[]
        
        self.generate_permute(nums, used, partial, solutions)
        
        return solutions
    
    def generate_permute(self, nums: List[int], 
                         used: List[bool], partial: List[int], 
                         solutions:List[List[int]]) -> None:
        # O(n!) time & O(n) space
        
        # Base case
        if len(partial) == len(nums):
            solutions.append(partial[::])
            return
        
        # Recursive case
        length = len(nums)
        for i in range(length):
            # Already part of partial
            if used[i]:
                continue
            
            # Take move
            used[i] = True
            partial.append(nums[i])
            
            self.generate_permute(nums, used, partial, solutions)
            
            # Undo move
            partial.pop()
            used[i] = False
            
        return
    