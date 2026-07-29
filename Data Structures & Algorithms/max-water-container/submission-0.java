class Solution {
    public int maxArea(int[] heights) {
        int n = heights.length;
        int l = 0; 
        int r = n-1;
        int maxArea = 0;
        while(l<r){
            int area = (r-l)*Math.min(heights[r],heights[l]);
            maxArea = Math.max(maxArea,area);
            if(heights[r]==heights[l]){
                r--;
                l++;
            }
            else if(heights[r]>heights[l]){
                l++;
            }
            else{
                r--;
            }
        }
        return maxArea;
    }
}
