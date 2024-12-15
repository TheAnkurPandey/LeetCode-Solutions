class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        # tc: O(n); sc: O(1)
        
        n = len(nums)
        res = [1] * n
        
        # Calculating prefix multipliers
        prefix = 1
        for i, v in enumerate(nums):
            if i == 0: continue
            else:
                res[i] *= prefix * nums[i-1]
                prefix *= nums[i-1]
                
        # Calculating suffix multipliers
        suffix = 1
        for i, v in reversed(list(enumerate(nums))):
            if i == n-1: continue
            else:
                res[i] *= suffix * nums[i+1]
                suffix *= nums[i+1]
                
        return res
        