class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        # O(n) time & O(1) space
        
        max_profit_upto_i = 0
        for i in range(1, len(prices)):
            if prices[i] > prices[i - 1]:
                max_profit_upto_i += prices[i] - prices[i - 1]
                
        return max_profit_upto_i