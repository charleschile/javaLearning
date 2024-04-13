package solutions;

import java.util.HashMap;
import java.util.Map;

public class solution1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hash = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            if (hash.containsKey(target - x)) {
                return new int[] {i, hash.get(target - x)};
            }
            hash.put(nums[i], i);
        }
        return new int[0];
    }

    public static void main(String[] args) {
        solution1 s1 = new solution1();
        int[] nums = {2, 7, 11, 15};
        int target = 10;
        int[] result = s1.twoSum(nums, target);
        if (result.length > 0) {
            System.out.println(result[0] + ", " + result[1]);
        }
        else {
            System.out.println("null!");
        }

    }
}
