class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        if(!set.contains(endWord)){
            return 0;
        }
        //
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        int steps = 1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                String word = q.poll();
                if(word.equals(endWord)){
                    return steps;
                }
                char[] arr = word.toCharArray();
                for(int j = 0; j < arr.length; j++){
                    char org = arr[j];
                    for(char ch = 'a'; ch <= 'z'; ch++){
                        arr[j] = ch;
                        String newWord = new String(arr);
                        if(set.contains(newWord)){
                            q.offer(newWord);
                            set.remove(newWord);
                        }
                    }
                    arr[j] = org;
                }
            }
            steps++;
        }
        return 0;
    }
}