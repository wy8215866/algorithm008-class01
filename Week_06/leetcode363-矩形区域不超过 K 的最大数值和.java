

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

class Solution {

    public int maxSumSubmatrix(int[][] matrix, int k) {
        if (matrix.length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int result = Integer.MIN_VALUE;
        for (int left = 0; left < n; left++) {
            int[] sums = new int[m];
            for (int right = left; right < n; right++) {
                for (int i = 0; i < m; i++) {
                    sums[i] += matrix[i][right];
                }

                TreeSet<Integer> set = new TreeSet<Integer>();
                set.add(0);
                int currSum = 0;
                for (int sum : sums) {
                    currSum = currSum + sum;
                    Integer num = set.ceiling(currSum - k);
                    if (num != null) result = Math.max(result, currSum - num);
                    set.add(currSum);
                }
            }
        }
        return result;
    }

}


