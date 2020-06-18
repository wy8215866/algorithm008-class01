import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/find-all-anagrams-in-a-string/discuss/92015/ShortestConcise-JAVA-O(n)-Sliding-Window-Solution
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        ArrayList<Integer> list = new ArrayList<>();
        if(s==null||s.length()==0||p==null||p.length()==0) return list;
        int[] hash = new int[256];
        for(char c:p.toCharArray()){
            hash[c]++;
        }
        int left = 0,right=0,count=p.length();
        while(right<s.length()){
            //move right everytime,if the character exists in p hash,decrease the count
            if(hash[s.charAt(right++)]-- >=1) count--;
            //when the count is down to 0,means we foundthe right anagram
            //then add window's left to result list
            if(count==0) list.add(left);
//if we find the window's size equals to p, then we have to move left (narrow the window) to find the new match window
            if(right-left==p.length()&&hash[s.charAt(left++)]++ >=0) count ++;

        }
        return list;
    }
}