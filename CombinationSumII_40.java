package leetcode;

import java.util.*;

/**
 * @author Tonghui Li
 * @createdTime 2020/3/23
 * @description
 */
public class CombinationSumII_40 {
    public static void main(String[] args){
        Solution40 solution = new Solution40();
        int[] candidates = new int[]{10,1,2,7,6,1,5};
        int target = 8;
        System.out.println(solution.combinationSum2(candidates,target));
    }
}

class Solution40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Set<List<Integer>> ans = new HashSet<>();
        List<Integer> curr = new ArrayList<>();
        Arrays.sort(candidates);
        find(candidates,target,0,curr,ans);
        return new ArrayList<>(ans);
    }

    public void find(int[] candidates, int target, int pos, List<Integer> curr, Set<List<Integer>> ans){
        if(target==0){
            ans.add(new ArrayList<Integer>(curr));
            return;
        }
        for(int i=pos;i<candidates.length;i++){
            if(candidates[i]>target) return;
//            if (i>pos && candidates[i]==candidates[i-1]) continue;
            curr.add(candidates[i]);
            find(candidates,target-candidates[i],i+1,curr,ans);
            curr.remove(curr.size()-1);
        }
    }
}
