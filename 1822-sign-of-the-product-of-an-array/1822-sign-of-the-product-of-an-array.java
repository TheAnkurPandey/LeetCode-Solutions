class Solution {
    public int arraySign(int[] nums) {
        // O(n) time & O(1) space
        
        int signOfProduct = 1;
        
        for (int i = 0; i < nums.length; i++) {
            signOfProduct *= signFunction(nums[i]);
        }
        
        return signOfProduct;
    }
    
    private int signFunction(int num) {
        return num > 0 ? 1 : (num == 0 ? 0 : -1);
    }
}