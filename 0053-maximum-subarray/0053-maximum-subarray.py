class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        # tc: O(n); sc: O(1)
        
        maxSubArraySum = float('-inf')
        maxSubArraySumEndingHere = 0
        for i, v in enumerate(nums):
            # nums[i] can be part of current subarray
            if maxSubArraySumEndingHere > 0:
                maxSubArraySumEndingHere += v
            # nums[i] is not part of current subarray
            else:
                maxSubArraySumEndingHere = v
                
            maxSubArraySum = max(maxSubArraySum, maxSubArraySumEndingHere)
            
        return maxSubArraySum
        