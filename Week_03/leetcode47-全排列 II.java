import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        if(nums == null||nums.length==0){
            return res;
        }
        Arrays.sort(nums);
        backTrack(nums,new boolean[nums.length],new LinkedList());
        return res;
    }

    public void backTrack(int[] nums,boolean[] used,LinkedList<Integer> p){
        if(nums.length ==p.size()){
            res.add(new LinkedList(p));
            return ;
        }

        for(int i =0;i<nums.length;i++){
            if (used[i]) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }

            p.add(nums[i]);
            used[i] = true;
            backTrack(nums,used,p);
            used[i] = false;
            p.removeLast();
        }
    }
}

