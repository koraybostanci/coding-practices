package com.coding.practicemakesperfect.algorithms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * https://leetcode.com/problems/two-sum/
 *
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Example:
 *   Given nums = [2, 7, 11, 15], target = 9,
 *   Because nums[0] + nums[1] = 2 + 7 = 9,
 *   return [0, 1].
 */
public class P01_TwoSum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> used = new HashMap();

        for(int i=0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (used.containsKey(diff)) {
                int[] result = new int[2];
                result[0] = used.get(diff);
                result[1] = i;
                return result;
            }
            if (!used.containsKey(nums[i])) {
                used.put(nums[i], i);
            }
        }

        return null;
    }

    @Test
    public void testSuccess() {
        int[] nums = {1,2,7,16,4};
        int[] result = twoSum(nums, 11);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(2,result[0]);
        Assertions.assertEquals(4,result[1]);
    }

    @Test
    public void testFail() {
        int[] nums = {1,2,7,16,4};
        int[] result = twoSum(nums, 50);

        Assertions.assertNull(result);
    }

}
