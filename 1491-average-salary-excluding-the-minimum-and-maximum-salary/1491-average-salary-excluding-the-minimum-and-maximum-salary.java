class Solution {
    public double average(int[] salary) {
        // O(n) time & O(1) space
        
        Arrays.sort(salary);
        
        double sum = 0;
        int n = salary.length - 2;
        for(int i = 1; i <= n; i++) sum+= salary[i];
        
        double avg = sum / n;
        
        return avg;
    }
}