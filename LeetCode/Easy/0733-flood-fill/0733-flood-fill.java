class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int orgColor = image[sr][sc];
        if(orgColor != color){
            dfs(image, sr, sc, orgColor, color);
        }
        return image;
    }
    public void dfs(int[][] image, int sr, int sc, int orgColor, int color){
        int n = image.length;
        int m = image[0].length;
        //condition check
        if(sr < 0 || sc < 0 || sr >= n || sc >= m || image[sr][sc] != orgColor){
            return;
        }

        image[sr][sc] = color;

        dfs(image, sr + 1, sc, orgColor, color);
        dfs(image, sr - 1, sc, orgColor, color);
        dfs(image, sr, sc + 1, orgColor, color);
        dfs(image, sr, sc - 1, orgColor, color);
    }
}