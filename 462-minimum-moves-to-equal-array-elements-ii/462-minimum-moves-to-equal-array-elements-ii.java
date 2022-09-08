class Solution {
    public int minMoves2(int[] nums) {
        // O(n) time & O(1) space
        
        // Assuming K is the target after doing operation & array is sorted
        // nums[i] + x = nums[-i - 1] - y = K
        // x + y = nums[-i - 1] - nums[i]; Steps to make opposite elements equal
        // Answer lie in mid
        
        Arrays.sort(nums);  // Sorting the array
        
        int minSteps = 0;
        int leftPtr = 0;
        int rightPtr = nums.length - 1;
        
        while (leftPtr < rightPtr) {
            int steps = nums[rightPtr--] - nums[leftPtr++];
            minSteps += steps;
        }
        
        return minSteps;
    }
}