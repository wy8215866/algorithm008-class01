class Solution {
    public boolean validPalindrome(String s) {
        for(int i=0,j = s.length()-1;i < j;i++,j--){
            if(s.charAt(i)!=s.charAt(j)){
                //分两种情况，右减一，左减一
                return isValid(s,i,j-1)||isValid(s,i+1,j);
            }
        }
        return true;

    }

    public boolean isValid(String s,int l,int r){
        while(l < r){
            if(s.charAt(l++)!=s.charAt(r--)){
                return false;
            }
        }
        return true;
    }
}