package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Tonghui Li
 * @createdTime 2020/3/23
 * @description
 */
public class CombinationSum_39 {
    public static void main(String[] args){
        Solution39 solution = new Solution39();
        int[] candidates = new int[]{2,3,6,7};
        int target = 7;
        System.out.println(solution.combinationSum(candidates,target));
    }
}

class Solution39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        Arrays.sort(candidates);
        getCombination(candidates,target,0,curr,res);
        return res;
    }

    public void getCombination(int[] candidates, int target, int pos, List<Integer> curr, List<List<Integer>> res){
        if(target==0){
            res.add(new ArrayList(curr));
            return;
        }
        for(int i=pos;i<candidates.length;i++){
            if(candidates[i]>target) break;
            curr.add(candidates[i]);
            getCombination(candidates,target-candidates[i],i,curr,res);
            curr.remove(curr.size()-1);
        }
    }
}
