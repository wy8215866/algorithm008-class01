

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int sum = 0;
        while(n!=0){
            sum++;
            n&=(n-1);
        }
        return sum;
    }
}


