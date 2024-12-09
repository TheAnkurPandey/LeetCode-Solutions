class Solution:
    def longestMountain(self, arr: List[int]) -> int:
        # tc: O(n); sc: O(1)
        n = len(arr)
        currLongestLen = 0
        
        for index, val in enumerate(arr):
            isPeak = self.isMountainPeak(arr, index)
            if not isPeak: continue
            
            # Calculating left side length
            leftSideLen = 0
            leftPtr = index-1
            while(leftPtr > -1 and arr[leftPtr] < arr[leftPtr+1]):
                leftSideLen += 1
                leftPtr -= 1
                
            # Calculating right side length
            rightSideLen = 0
            rightPtr = index + 1
            while(rightPtr < n and arr[rightPtr] < arr[rightPtr-1]):
                rightSideLen += 1
                rightPtr += 1
            
            lenOfMountain = leftSideLen + 1 + rightSideLen
            
            currLongestLen = max(currLongestLen, lenOfMountain)
            
        return currLongestLen
            
    def isMountainPeak(self, arr: List[int], index: int):
        n = len(arr)
        
        # Corner can never be a peak
        if (index == 0 or index == n-1): return False
        
        # Element with smaller adjacent left & right elements forms the peak
        if (arr[index] > arr[index-1] 
            and arr[index] > arr[index+1]): return True
        else: return False
        
        