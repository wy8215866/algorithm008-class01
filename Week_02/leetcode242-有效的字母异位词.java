import java.util.Arrays;

public class Solution {
    public boolean isAnagram(String s, String t) {
        //解法一:排序
        //两个字符串转化为字符数组,再判断是否相等
        if(s.length()!=s.length()){
                return false;
            }
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1,str2);
    }
}
