class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        // Sorting
        // O(nlogn) time & O(sort) space
        
        Arrays.sort(points, (p1, p2) -> p1[0] - p2[0]);  // Sort points by x axis
        
        int n = points.length;
        int maxWidth = Integer.MIN_VALUE;
        
        for (int i = 0; i < n - 1; i++) {
            int diff = points[i + 1][0] - points[i][0];
            if (diff > maxWidth) maxWidth = diff;  // Update maxWidth
        }
        
        return maxWidth;
    }
}