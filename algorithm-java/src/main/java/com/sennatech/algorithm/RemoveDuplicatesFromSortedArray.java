package com.sennatech.algorithm;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <pre>
 * ============================================================================================================================
 * Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.
 *
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 *
 * Example 1:
 *
 * Given nums = [1,1,2],
 *
 * Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
 *
 * It doesn't matter what you leave beyond the returned length.
 * Example 2:
 *
 * Given nums = [0,0,1,1,1,2,2,3,3,4],
 *
 * Your function should return length = 5, with the first five elements of nums being modified to 0, 1, 2, 3, and 4 respectively.
 *
 * It doesn't matter what values are set beyond the returned length.
 * Clarification:
 *
 * Confused why the returned value is an integer but your answer is an array?
 *
 * Note that the input array is passed in by reference, which means modification to the input array will be known to the caller as well.
 *
 * Internally you can think of this:
 *
 * // nums is passed in by reference. (i.e., without making a copy)
 * int len = removeDuplicates(nums);
 *
 * // any modification to nums in your function would be known by the caller.
 * // using the length returned by your function, it prints the first len elements.
 * for (int i = 0; i < len; i++) {
 *     print(nums[i]);
 * }
 * =============================================================================================================================
 * </pre>
 *
 * @author Created by JINSHENGJIE on 16/10/14 .
 */
public class RemoveDuplicatesFromSortedArray {

    private static final Logger logger = LoggerFactory.getLogger(RemoveDuplicatesFromSortedArray.class);

    public static void main(String[] args) {
        int[] sortedArray1 = {1, 2, 4, 4, 4, 4, 5, 5, 5, 5, 6, 6, 7, 8, 9};
        int[] zeroArr1 = {};
        removeDuplicates1(sortedArray1);
        removeDuplicates1(zeroArr1);

        int[] sortedArray2 = {1, 2, 4, 4, 4, 4, 5, 5, 5, 5, 6, 6, 7, 8, 9};
        int[] zeroArr2 = {};
        removeDuplicates2(sortedArray2);
        removeDuplicates2(zeroArr2);

        int[] sortedArray3 = {1, 2, 4, 4, 4, 4, 5, 5, 5, 5, 6, 6, 7, 8, 9};
        int[] zeroArr3 = {};
        removeDuplicates3(sortedArray3);
        removeDuplicates3(zeroArr3);

        int[] sortedArray4 = {1, 2, 4, 4, 4, 4, 5, 5, 5, 5, 6, 6, 7, 8, 9};
        int[] zeroArr4 = {};
        removeDuplicates4(sortedArray4);
        removeDuplicates4(zeroArr4);
    }

    /**
     * <pre>
     * Approach 1: Two Pointers
     * Algorithm
     *
     * Since the array is already sorted, we can keep two pointers i and j, where i is the slow-runner while j is the fast-runner.
     * As long as nums[i] = nums[j], we increment j to skip the duplicate.
     *
     * When we encounter nums[j]!=nums[i],the duplicate run has ended so we must copy its value to nums[i+1]. i is then
     * incremented and we repeat the same process again until j reaches the end of array.
     *
     * public int removeDuplicates(int[] nums) {
     *     if (nums.length == 0) return 0;
     *     int i = 0;
     *     for (int j = 1; j < nums.length; j++) {
     *         if (nums[j] != nums[i]) {
     *             i++;
     *             nums[i] = nums[j];
     *         }
     *     }
     *     return i + 1;
     * }
     *
     * Complexity analysis
     *
     * Time complexity : O(n). Assume that n is the length of array. Each of i and j traverses at most n steps.
     *
     * Space complexity : O(1).
     * </pre>
     */
    @SuppressWarnings("UnusedReturnValue")
    private static int removeDuplicates4(int[] sortedArray) {
        if (sortedArray.length == 0) {
            return 0;
        }
        int j = 0;
        for (int i = 0; i < sortedArray.length; i++) {
            if (sortedArray[j] != sortedArray[i]) {
                j++;
                sortedArray[j] = sortedArray[i];
            }
        }
        logger.info("== removeDuplicates4 ==");
        logger.info(Arrays.toString(sortedArray));
        logger.info("length = {}", j + 1);
        return j + 1;
    }

    /**
     * ===original===
     *
     * @return the int  返回的仅仅是原数组被删除选定元素后的表象长度，数组的长度仍然不变，元素会有变动，后面的元素会重复。
     */
    @SuppressWarnings("UnusedReturnValue")
    private static int removeDuplicates1(int[] sortedArray) {
        int length = sortedArray.length;
        if (length == 0) {
            return 0;
        }
        int i = 0;
        int j = 1;
        for (; i < length; i++, j++) {
            if (sortedArray[--j] == sortedArray[i]) {
                continue;
            }
            sortedArray[++j] = sortedArray[i];
        }
        logger.info("== removeDuplicates1 ==");
        logger.info(Arrays.toString(sortedArray));
        logger.info("length = {}", j);
        return j;
    }

    /**
     * ===original===
     *
     * @return the int 返回的仅仅是原数组被删除选定元素后的表象长度，数组的长度仍然不变，元素会有变动，后面的元素会重复。
     */
    @SuppressWarnings("UnusedReturnValue")
    private static int removeDuplicates2(int[] arr) {
        int l = arr.length;
        if (l == 0) {
            return 0;
        }
        int i = 1;
        int j = 0;
        for (; i < l; i++) {
            if (arr[i] != arr[j]) {
                arr[++j] = arr[i];
            }
        }
        logger.info("== removeDuplicates2 ==");
        logger.info(Arrays.toString(arr));
        logger.info("length = {}", j + 1);

        return j + 1;
    }

    /**
     * @return the int  返回的仅仅是原数组被删除选定元素后的表象长度，数组的长度仍然不变，元素会有变动，后面的元素会重复
     */
    @SuppressWarnings("UnusedReturnValue")
    private static int removeDuplicates3(int[] arr) {
        int i = 0;
        for (int n : arr) {
            if (i < 1 || n != arr[i - 1]) {
                arr[i++] = n;
            }
        }
        logger.info("== removeDuplicates3 ==");
        logger.info(Arrays.toString(arr));
        logger.info("length = {}", i);
        return i;
    }

}
