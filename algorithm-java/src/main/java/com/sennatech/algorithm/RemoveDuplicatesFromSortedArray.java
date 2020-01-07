package com.sennatech.algorithm;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by JINSHENGJIE on 16/10/14 .
 * ============================================================================================================================
 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 * For example,
 * Given input array nums = [1,1,2],
 * Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the new length.
 * Subscribe to see which companies asked this question
 * =============================================================================================================================
 */
public class RemoveDuplicatesFromSortedArray {

    private static final Logger logger = LoggerFactory.getLogger(RemoveDuplicatesFromSortedArray.class);

    public static void main(String[] args) {
        int[] sortedArray1 = {1, 2, 4, 4, 4, 4, 5, 5, 5, 5, 6, 6, 7, 8, 9};
        int[] zeroArr1 = {};
        RemoveDuplicatesFromSortedArray rdfs = new RemoveDuplicatesFromSortedArray();
        logger.info("************************removeDuplicates1*********************");
        logger.info(String.valueOf(rdfs.removeDuplicates1(sortedArray1)));
        logger.info(String.valueOf(rdfs.removeDuplicates1(zeroArr1)));

        logger.info("************************removeDuplicates2*********************");
        int[] sortedArray2 = {1, 2, 4, 4, 4, 4, 5, 5, 5, 5, 6, 6, 7, 8, 9};
        int[] zeroArr2 = {};
        logger.info(String.valueOf(rdfs.removeDuplicates2(sortedArray2)));
        logger.info(String.valueOf(rdfs.removeDuplicates2(zeroArr2)));

        logger.info("************************removeDuplicates3*********************");
        int[] sortedArray3 = {1, 2, 4, 4, 4, 4, 5, 5, 5, 5, 6, 6, 7, 8, 9};
        int[] zeroArr3 = {};
        logger.info(String.valueOf(rdfs.removeDuplicates3(sortedArray3)));
        logger.info(String.valueOf(rdfs.removeDuplicates3(zeroArr3)));
    }

    /**
     * Remove duplicates int.
     * ===original===
     *
     * @param sortedArray the sorted arrays
     * @return the int  返回的仅仅是原数组被删除选定元素后的表象长度，数组的长度仍然不变，元素会有变动，后面的元素会重复。
     */
    public int removeDuplicates1(int[] sortedArray) {
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
        logger.info(Arrays.toString(sortedArray));
        return j;
    }

    /**
     * Remove duplicates 2 int.
     * ===original===
     *
     * @param arr the arr
     * @return the int 返回的仅仅是原数组被删除选定元素后的表象长度，数组的长度仍然不变，元素会有变动，后面的元素会重复。
     */
    public int removeDuplicates2(int[] arr) {
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
        logger.info(Arrays.toString(arr));
        return j + 1;
    }

    /**
     * Remove duplicates 3 int.
     *
     * @param arr the arr
     * @return the int  返回的仅仅是原数组被删除选定元素后的表象长度，数组的长度仍然不变，元素会有变动，后面的元素会重复
     */
    public int removeDuplicates3(int[] arr) {
        int i = 0;
        for (int n : arr) {
            if (i < 1 || n != arr[i - 1]) {
                arr[i++] = n;
            }
        }
        logger.info(Arrays.toString(arr));
        return i;
    }

}
