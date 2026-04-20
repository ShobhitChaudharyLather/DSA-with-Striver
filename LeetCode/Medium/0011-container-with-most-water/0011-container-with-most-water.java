class Solution {
    public int maxArea(int[] height) {
        int n=height.length;
        int s=0;
        int e=n-1;
        int area=0;
        while(s<e){
            int h=(int)Math.min(height[s],height[e]);
            area=(int)Math.max(area,h*(e-s));
            if(height[s]<height[e]){
                s++;
            }
            else{
                e--;
            }
        }
        return area;
    }
}