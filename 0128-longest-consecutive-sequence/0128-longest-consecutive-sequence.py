class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        # O(n) time & O(n) space
        
        is_start_of_seq = dict()
        
        # Assume all values in nums are start of sequence
        for val in nums:
            is_start_of_seq[val] = True
            
        for val in nums:
            prev_val = val - 1
            
            if prev_val in is_start_of_seq:
                is_start_of_seq[val] = False
                
        len_of_longest_seq = 0
        
        for val, is_start in is_start_of_seq.items():
            # Val is start of sequence
            if is_start:
                
                len_of_seq = 1
                next_val = val + 1
                
                while next_val in is_start_of_seq: 
                    len_of_seq += 1
                    next_val += 1
                    
                len_of_longest_seq = max(len_of_longest_seq, len_of_seq)
                
        return len_of_longest_seq
    