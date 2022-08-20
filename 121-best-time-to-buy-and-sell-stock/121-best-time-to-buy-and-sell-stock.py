class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        # O(n) time & O(1) space
        
        min_so_far = float('inf')
        max_profit = float('-inf')
        
        for i in range(len(prices)):
            min_so_far = min(prices[i], min_so_far)
                
            curr_profit = prices[i] - min_so_far
            max_profit = max(curr_profit, max_profit)
                
        return max_profit
        