import java.util.*;
class WordLadder2{
    public static  ArrayList<ArrayList<String>> findSequences(String startWord, String targetWord, String[] wordList) {
        Set<String> st = new HashSet<>();
        int len = wordList.length;

        for (int i = 0; i < len; i++) {
            st.add(wordList[i]);
        }

        Queue<ArrayList<String>> q = new LinkedList<>();
        ArrayList<String> ls = new ArrayList<>();
        ls.add(startWord);
        q.add(ls);

        ArrayList<String> usedOnLevel = new ArrayList<>();
        usedOnLevel.add(startWord);

        int level = 0;
        ArrayList<ArrayList<String>> ans = new ArrayList<>();

        while (!q.isEmpty()) {
            ArrayList<String> vec = q.peek();
            q.remove();

            // Erase all the words that have been used in previous levels
            if (vec.size() > level) {
                level++;
                for (String it : usedOnLevel) {
                    st.remove(it);
                }
                usedOnLevel.clear();
            }

            String word = vec.get(vec.size() - 1);

            // Reached target word
            if (word.equals(targetWord)) {
                if (ans.size() == 0) {
                    ans.add(vec);
                } else if (ans.get(0).size() == vec.size()) {
                    ans.add(vec);
                }
                continue;
            }

            for (int i = 0; i < word.length(); i++) {
                for (char c = 'a'; c <= 'z'; c++) {
                    char[] replacedCharArray = word.toCharArray();
                    replacedCharArray[i] = c;
                    String replacedWord = new String(replacedCharArray);

                    if (st.contains(replacedWord)) {
                        vec.add(replacedWord);
                        ArrayList<String> temp = new ArrayList<>(vec); // Java works by reference
                        q.add(temp);
                        usedOnLevel.add(replacedWord);
                        vec.remove(vec.size() - 1);
                    }
                }
            }
        }

        return ans;
    }
    public static void main(String[] args) {
        String startWord = "hit";
        String targetWord = "cog";
        String[] wordList = {"hot", "dot", "dog", "lot", "log", "cog"};

        ArrayList<ArrayList<String>> results = findSequences(startWord, targetWord, wordList);

        System.out.println("All shortest transformation sequences:");
        for (ArrayList<String> path : results) {
            System.out.println(path);
        }
    }
}