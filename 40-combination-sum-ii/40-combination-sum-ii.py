class Solution:
    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        candidates.sort()
        
        start_index = 0
        curr_sum = 0
        partial = []
        solutions = []
        self.generate_combinations(candidates, target, 
                                   start_index, curr_sum, partial, solutions)
        
        return solutions
    
    def generate_combinations(self, candidates: List[int], target: int, 
                              start_index: int, curr_sum, partial: List[int], 
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
        
        for curr_index in range(start_index, upto):
            # To avoid duplicates
            if curr_index > start_index and \
            candidates[curr_index] == candidates[curr_index - 1]:
                continue
                
            item = candidates[curr_index]
            
            partial.append(item)  # Take move
            self.generate_combinations(candidates, target, curr_index + 1,
                                       curr_sum + item, partial, solutions)
            partial.pop()  # Undo move
            
        return
    