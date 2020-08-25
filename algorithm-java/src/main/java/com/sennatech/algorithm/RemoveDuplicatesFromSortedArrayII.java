package com.sennatech.algorithm;

import java.util.Arrays;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <pre>
 *     ++ Medium ++
 * ===================================================================================================
 * Given a sorted array nums, remove the duplicates in-place such that duplicates appeared at most twice and return the new length.
 *
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 *
 * Example 1:
 *
 * Given nums = [1,1,1,2,2,3],
 *
 * Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3 respectively.
 *
 * It doesn't matter what you leave beyond the returned length.
 * Example 2:
 *
 * Given nums = [0,0,1,1,1,1,2,3,3],
 *
 * Your function should return length = 7, with the first seven elements of nums being modified to 0, 0, 1, 1, 2, 3 and 3 respectively.
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
 * ===================================================================================================
 * </pre>
 *
 * @author Created by JINSHENGJIE on 16/10/17 .
 */
public class RemoveDuplicatesFromSortedArrayII {

    private static final Logger logger = LoggerFactory.getLogger(RemoveDuplicatesFromSortedArrayII.class);

    @SuppressWarnings("Duplicates")
    public static void main(String[] args) {
        int[] array0 = {};
        int[] array1 = {1, 1, 1, 2, 2, 2, 2, 3};
        int[] array2 = {54, 32, 31, 31, 23, 23, 23, 23, 23, 23, 23, 21, 21, 10, 10, 10, 2, 1};
        int[] array3 = {1, 2};
        int[] array4 = {1};
        int[] array5 = {1, 2, 3};

        int[] arr0 = Arrays.copyOf(array0, array0.length);
        int[] arr1 = Arrays.copyOf(array1, array1.length);
        int[] arr2 = Arrays.copyOf(array2, array2.length);
        int[] arr3 = Arrays.copyOf(array3, array3.length);
        int[] arr4 = Arrays.copyOf(array4, array4.length);
        int[] arr5 = Arrays.copyOf(array5, array5.length);

        removeDuplicate1(arr0);
        removeDuplicate1(arr1);
        removeDuplicate1(arr2);
        removeDuplicate1(arr3);
        removeDuplicate1(arr4);
        removeDuplicate1(arr5);

        int[] arr00 = Arrays.copyOf(array0, array0.length);
        int[] arr11 = Arrays.copyOf(array1, array1.length);
        int[] arr22 = Arrays.copyOf(array2, array2.length);
        int[] arr33 = Arrays.copyOf(array3, array3.length);
        int[] arr44 = Arrays.copyOf(array4, array4.length);
        int[] arr55 = Arrays.copyOf(array5, array5.length);
        removeDuplicate2(arr00);
        removeDuplicate2(arr11);
        removeDuplicate2(arr22);
        removeDuplicate2(arr33);
        removeDuplicate2(arr44);
        removeDuplicate2(arr55);

        int[] arr000 = Arrays.copyOf(array0, array0.length);
        int[] arr111 = Arrays.copyOf(array1, array1.length);
        int[] arr222 = Arrays.copyOf(array2, array2.length);
        int[] arr333 = Arrays.copyOf(array3, array3.length);
        int[] arr444 = Arrays.copyOf(array4, array4.length);
        int[] arr555 = Arrays.copyOf(array5, array5.length);
        removeDuplicate3(arr000);
        removeDuplicate3(arr111);
        removeDuplicate3(arr222);
        removeDuplicate3(arr333);
        removeDuplicate3(arr444);
        removeDuplicate3(arr555);
    }

    /**
     * ===original===
     * 此方法相对简单明了，利用两个指针同向移动；
     * <p>
     * 返回的是过滤后的长度，数组长度仍然没有变，后面的元素存在重复现象
     */
    private static void removeDuplicate1(int[] nums) {
        if (Objects.isNull(nums)) {
            return;
        }
        int length = nums.length;
        if (length == 0) {
            return;
        }
        int i = 1;
        int j = 0;
        int count = 1;
        for (; i < length; i++) {
            if (nums[i] == nums[j]) {
                if (count < 2) {
                    nums[++j] = nums[i];
                    count++;
                }
            } else {
                nums[++j] = nums[i];
                count = 1;
            }
        }
        logger.info("-- removeDuplicate1 --");
        logger.info("array = {}", Arrays.toString(nums));
        logger.info("length = {}", j + 1);
    }

    /**
     * 此方法相对复杂难懂，利用双指针交叉移动；
     */
    private static void removeDuplicate2(int[] nums) {
        if (Objects.isNull(nums) || nums.length == 0) {
            return;
        }
        int cur = 0;
        int i, j;
        for (i = 0; i < nums.length; ) {
            for (j = i; j < nums.length; j++) {
                if (nums[j] != nums[i]) {
                    break;
                }
                if (j - i < 2) {
                    nums[cur++] = nums[i];
                }
            }
            i = j;
        }
        logger.info("-- removeDuplicate2 --");
        logger.info("array = {}", Arrays.toString(nums));
        logger.info("length = {}", cur);
    }

    /**
     * 牛逼
     */
    private static void removeDuplicate3(int[] nums) {
        int i = 0;
        for (int n : nums) {
            if (i < 2 || n != nums[i - 2]) {
                nums[i++] = n;
            }
        }
        logger.info("-- removeDuplicate3 --");
        logger.info("array = {}", Arrays.toString(nums));
        logger.info("length = {}", i);
    }

}

