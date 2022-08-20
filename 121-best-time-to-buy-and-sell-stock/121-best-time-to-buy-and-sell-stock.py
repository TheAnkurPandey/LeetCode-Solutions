class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        # O(n) time & O(1) space
        
        min_so_far = float('inf')
        max_profit = float('-inf')
        
        for i in range(len(prices)):
            if prices[i] < min_so_far:
                min_so_far = prices[i]
                
            curr_profit = prices[i] - min_so_far
            if curr_profit > max_profit:
                max_profit = curr_profit
                
        return max_profit
        