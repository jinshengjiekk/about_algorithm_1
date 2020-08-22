package com.sennatech.algorithm;

import java.util.Arrays;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <pre>
 * ===original===
 *  ++ Easy ++
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 *
 * Example:
 *
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * </pre>
 */
//2016年2月26日下午9:38:48
public class MoveZeros {

    private static final Logger logger = LoggerFactory.getLogger(MoveZeros.class);

    public static void main(String[] args) {
        int[] array = {2, 3, 0, 6, 3, 5, 0, 3, 4, 0, 0, 5};
        moveZero1(array);
        moveZero2(array);
        moveZeros3(array);
    }

    /**
     * <pre>
     * 双指针移动，将0和第一个非0调换位置
     * 相当于将0逐渐向后冒泡
     *
     * void moveZeroes(vector<int>& nums) {
     *     for (int lastNonZeroFoundAt = 0, cur = 0; cur < nums.size(); cur++) {
     *         if (nums[cur] != 0) {
     *             swap(nums[lastNonZeroFoundAt++], nums[cur]);
     *         }
     *     }
     * }
     * Complexity Analysis
     *
     * Space Complexity : O(1). Only constant space is used.
     *
     * Time Complexity: O(n). However, the total number of operations are optimal. The total operations (array writes) that code does
     * is Number of non-0 elements.This gives us a much better best-case (when most of the elements are 0) complexity than last solution.
     * However, the worst-case (when all elements are non-0) complexity for both the algorithms is same.
     * </pre>
     */
    private static void moveZeros3(int[] array) {
        if (Objects.nonNull(array) && array.getClass().isArray()) {
            //j 始终代表以及遍历过的元素最后一个非零的指针
            for (int lastNonZeroFountAt = 0, cur = 0; cur < array.length; cur++) {
                if (array[cur] != 0) {
                    // 加了这一步判断将减少数据交换次数
                    if (lastNonZeroFountAt != cur) {
                        array[lastNonZeroFountAt] = array[cur];
                        array[cur] = 0;
                    } else {
                        lastNonZeroFountAt++;
                    }
                }
            }
        }
        logger.info("== moveZero3==");
        logger.info(Arrays.toString(array));
    }

    /**
     * <pre>
     * 遇到数值为O的数,将它后面的数统统往前移一位，最后一位补0。 ===》移动次数较多，有冗余移动，尤其是最后都为0的时候仍然去交换，直到最后一个数。
     *
     * -- 该方法有bug,对于连续的0，向前移一位后当前的位置还是0，得不到修正 --
     * </pre>
     */
    private static void moveZero1(int[] array) {
        int length = array.length;
        for (int i = 0; i < length; i++) {
            if (array[i] == 0) {
                if (length - 1 - i >= 0) {
                    System.arraycopy(array, i + 1, array, i, length - 1 - i);
                }
                array[length - 1] = 0;
            }
        }
        logger.info("== moveZero1-with-bug ==");
        logger.info(Arrays.toString(array));
    }

    /**
     * <pre>
     * 首先将数组中不为零的数值重新放在数组的前面，后面的不足数组长度的位置补零 ===> 此方法不足的地方在于不是将0移动到最后，而是统一在最后位置补0
     *
     * Space Complexity : O(1). Only constant space is used.
     * Time Complexity: O(n). However, the total number of operations are still sub-optimal. The total operations (array writes) that code does is nn (Total number of elements).
     * </pre>
     */
    private static void moveZero2(int[] array) {
        int f = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != 0) {
                array[f++] = array[i];
            }
        }
        for (int i = f; i < array.length; i++) {
            array[i] = 0;
        }
        logger.info("== moveZero2 ==");
        logger.info(Arrays.toString(array));
    }
}
