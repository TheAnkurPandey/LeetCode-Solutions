class Solution {
    public boolean validMountainArray(int[] arr) {
        // O(n) time & O(1) space
        
        int n = arr.length;
        
        // Traverse left side of mountain
        int left = 0;
        while (left < n - 1 && arr[left] < arr[left + 1]) left++;
        
        // Traverse right side of mountain
        int right = n - 1;
        while (right > 0 && arr[right - 1] > arr[right]) right--;
        
        // True if we found the peak      
        return 0 < left && left == right && right < n - 1;
    }
}