class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        from_index = 0
        curr_sum = 0
        partial = []
        solutions = []
        self.generate_combinations(candidates, target, 
                                   from_index, curr_sum, partial, solutions)
        
        return solutions
    
    def generate_combinations(self, candidates: List[int], target: int, 
                              from_index: int, curr_sum, partial: List[int], 
                              solutions: List[List[int]]) -> None:
        # Base case
        if curr_sum == target:
            solutions.append(partial[::])
            return
        # Cann't extend to complete solution
        if curr_sum > target:
            return
        
        # Recursive case
        upto = len(candidates)
        
        for curr_index in range(from_index, upto):
            item = candidates[curr_index]
            
            partial.append(item)  # Take move
            self.generate_combinations(candidates, target, curr_index,
                                       curr_sum + item, partial, solutions)
            partial.pop()  # Undo move
            
        return
        