package leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Tonghui Li
 * @createdTime 2020/4/3
 * @description
 */
public class BinarySearch {
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] nums = stringToIntegerArray(line);
            line = in.readLine();
            int target = Integer.parseInt(line);

            int ret = new Solution704().search(nums, target);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}

class Solution704 {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        int mid = (left+right)/2;
        while(nums[mid]!=target){
            if(left==right || left == right-1){
                mid = -1;
                break;
            }
            if(nums[mid]>target){
                right = mid;
            }else{
                left = mid;
            }
            mid = (left+right)/2;
        }
        return mid;
    }
}
