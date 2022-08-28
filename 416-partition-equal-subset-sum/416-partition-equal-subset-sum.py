class Solution:
    def canPartition(self, nums: List[int]) -> bool:
        # O(n*sum) time & O(n*sum) space
        
        count = len(nums)
        arr_sum = sum(nums)
        target = arr_sum // 2
        
        if arr_sum & 1: return False
        
        can_partition_dp = [[0] * (target + 1) for _ in range(count + 1)]
        
        for i in range(count + 1):
            for j in range(target + 1):
                
                # Target sum is 0
                if j == 0:
                    can_partition_dp[i][j] = True
                
                # No item left
                elif i == 0:
                    can_partition_dp[i][j] = False
                    
                else:
                    
                    # Ith item taken
                    remaining_sum = j - nums[i - 1]
                    if remaining_sum < 0:
                        ith_taken = False
                    else:
                        ith_taken = can_partition_dp[i - 1][remaining_sum]
                    
                    # Ith item not taken
                    ith_not_taken = can_partition_dp[i - 1][j]
                    
                    can_partition_dp[i][j] = ith_taken or ith_not_taken
        
        return can_partition_dp[count][target]