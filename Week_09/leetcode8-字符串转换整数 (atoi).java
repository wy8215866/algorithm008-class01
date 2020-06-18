//https://leetcode.com/problems/string-to-integer-atoi/discuss/4643/Java-Solution-with-4-steps-explanations
class Solution {
    public int myAtoi(String str) {
        if(str.length()==0) return 0;
        //1.empty string
        int index = 0,sign = 1,total = 0;
        //2.remove spaces
        while(index<str.length()&&str.charAt(index)==' '){
            index ++;
        }
        if (index == str.length()) return 0;
        //3.handle signs
        if(str.charAt(index)=='+'||str.charAt(index)=='-'){
            sign = str.charAt(index) == '+'?1:-1;
            index ++;
        }
        //4.convert number and avoid overflow
        while(index<str.length()){
            int digit = str.charAt(index)- '0';
            if(digit<0||digit>9) break;

            //check if total will be overflow after 10 times and add digit
            if(Integer.MAX_VALUE/10<total||Integer.MAX_VALUE/10==total&&Integer.MAX_VALUE%10<digit)
                return sign == 1? Integer.MAX_VALUE:Integer.MIN_VALUE;

            total = 10*total + digit;
            index++;
        }
        return total*sign;
    }
}
