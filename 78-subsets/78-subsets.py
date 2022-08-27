class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        # Way - 1
        # depth = 0
        # partial = []
        # solutions = []
        # self.generate_subsets(nums, depth, partial, solutions)
        # return solutions
        
        # Way - 2
        choosen = []
        remaining = nums[:]
        solutions = []
        self.generate_subsets_2(choosen, remaining, solutions)
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
        
    def generate_subsets_2(self, 
                         choosen: List[int], remaining: List[int], 
                         solutions: List[List[int]]) -> None:
        # O(2^n) time & O(n) space
        
        # Base case
        if not remaining:
            solutions.append(choosen[:])
            return 
        
        # Recursive case
        item = remaining.pop(0)  # Take move
        
        # Take move
        self.generate_subsets_2(choosen, remaining, solutions)
        # undo move
        
        choosen.append(item)  # Take move
        self.generate_subsets_2(choosen, remaining, solutions)
        choosen.pop()  # Undo move
        
        remaining.insert(0, item)  # undo move
        