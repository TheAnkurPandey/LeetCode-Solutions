class Solution {
    public int nearestValidPoint(int x, int y, int[][] points) {
        // O(n) time & O(1) space
        
        int numOfPoints = points.length;
        int closestPoint = -1;
        int closestDist = Integer.MAX_VALUE;
        
        for (int i = 0; i < numOfPoints; i++) {
            
            int px = points[i][0];
            int py = points[i][1];
            
            if (px != x && py != y) continue;
                
            int manhattanDist = 0;
            manhattanDist = Math.abs(px - x) + Math.abs(py - y);
            
            if (manhattanDist < closestDist) {
                closestDist = manhattanDist;
                closestPoint = i;
            }
        }
        
        return closestPoint;
    }
}