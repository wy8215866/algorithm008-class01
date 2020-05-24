import java.util.*;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List> res = new HashMap<>();
        for (String str:strs){
            char[] ss= str.toCharArray();
            Arrays.sort(ss);
            String key = String.valueOf(ss);
            if(!res.containsKey(key)){
                res.put(key,new ArrayList());
            }
            res.get(key).add(str);
        }
        return new ArrayList(res.values());
    }
}
