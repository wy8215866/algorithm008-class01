import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null || !wordList.contains(endWord)) return 0;
        Queue<String> queue = new LinkedList<>();
        boolean[] visited = new boolean[wordList.size()];
        queue.add(beginWord);
        int depth = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            depth++;
            for(int i =0;i<size;i++){
                String item = queue.poll();
                for(int j = 0;j<wordList.size();j++){
                    if(visited[j]){
                        continue;
                    }
                    if(!canChange(item,wordList.get(j))){
                        continue;
                    }
                    if(wordList.get(j).equals(endWord)){
                        return depth +1;
                    }
                    visited[j] = true;
                    queue.offer(wordList.get(j));
                }
            }
        }
        return 0;
    }

    public boolean canChange(String str1,String str2){
        int count = 0;
        for(int i = 0;i<str2.length();i++){
            if(str1.charAt(i)!= str2.charAt(i)){
                count++;
            }
            if(count > 1){
                return false;
            }
        }
        return count==1;
    }

}

