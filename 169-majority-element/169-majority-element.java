class Solution {
    public int majorityElement(int[] nums) {
        // O(n) time & O(1) space
        
        int n = nums.length;
        
        // Find candidate majority element
        int majorityElementIdx = 0;
        int majorityElementCount = 1;
        
        for(int i = 1; i < n; i++) {
            if(nums[majorityElementIdx] == nums[i]) majorityElementCount++;
            else majorityElementCount--;
            
            if(majorityElementCount == 0) {
                majorityElementIdx = i;
                majorityElementCount = 1;
            }
        }        
        
        // Check if it is majority element
        majorityElementCount = 0;
        for(int item : nums) {
            if(item == nums[majorityElementIdx]) majorityElementCount++;
        }
        
        if(majorityElementCount <= n/2) return -1;
        else return nums[majorityElementIdx];
    }
}