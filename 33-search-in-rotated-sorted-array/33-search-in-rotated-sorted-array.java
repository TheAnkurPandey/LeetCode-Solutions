class Solution {
    public int search(int[] nums, int target) {
        // Binary search
        // O(logn) time & O(1) space
        
        int leftPtr = 0;
        int rightPtr = nums.length - 1;
        
        while (leftPtr <= rightPtr) {
            int midPtr = leftPtr + (rightPtr - leftPtr) / 2;  // To avoid overflow
            
            if (target == nums[midPtr]) return midPtr;  // Target found
            
            // Mid is not target
            boolean isMidInLeftSortedPart = nums[leftPtr] <= nums[midPtr];
            if (isMidInLeftSortedPart) {  // midPtr is in left sorted part
                
                boolean isTargetInLeftHalf = nums[leftPtr] <= target && target < nums[midPtr];
                if (isTargetInLeftHalf) rightPtr = midPtr - 1;
                else leftPtr = midPtr + 1;
                
            } else {  // midPtr is in right sorted part
                
                boolean isTargetInRightHalf = nums[midPtr] < target && target <= nums[rightPtr];
                if (isTargetInRightHalf) leftPtr = midPtr + 1;
                else rightPtr = midPtr - 1;
            }
        }
        
        return -1;  // Not found
    }
}