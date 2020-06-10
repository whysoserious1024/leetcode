package leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author Tonghui Li
 * @createdTime 2020/6/9
 * @description
 */
public class LASGD_1218 {
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
            int[] arr = stringToIntegerArray(line);
            line = in.readLine();
            int difference = Integer.parseInt(line);

            int ret = new Solution_1218().longestSubsequence(arr, difference);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}

class Solution_1218 {
    public int longestSubsequence(int[] arr, int difference) {
        Map<Integer, Integer> m = new HashMap<>();
        int longest = 1;
        for (int i : arr){
            int n = i - difference;
            if (m.containsKey(n)){
                m.put(i,m.get(n)+1);
                longest = Math.max(longest,m.get(i));
            }else {
                m.put(i,1);
            }
        }
        return longest;
    }
}
