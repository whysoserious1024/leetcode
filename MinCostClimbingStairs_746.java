package leetcode;

/**
 * @author Tonghui Li
 * @createdTime 2020/6/8
 * @description
 */
public class MinCostClimbingStairs_746 {

}

class Solution{
    public int minCostClimbingStairs(int[] cost){
        int x1 = 0, x2 = 0;
        for (int i=cost.length-1;i>0;i--){
            int temp = x1;
            x1 = cost[i] + Math.min(x1,x2);
            x2 = temp;
        }
        return Math.min(x1,x2);
    }
}
