class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int i=0, j=0;
        int maxLen = 0;
        int n = fruits.length;
        while(j<n){
            map.put(fruits[j],map.getOrDefault(fruits[j],0)+1);
            while(map.size()>2){
                int fruit = fruits[i];
                map.put(fruit,map.get(fruit)-1);
                if(map.get(fruit) == 0) map.remove(fruit);
                i++;
            }
            maxLen = Math.max(maxLen, j-i+1);
            j++;
        }
        return maxLen;
    }
}