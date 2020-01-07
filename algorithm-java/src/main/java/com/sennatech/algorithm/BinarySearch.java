package com.sennatech.algorithm;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//2016年2月26日下午9:19:46

/**
 * ===original===
 * <p>
 * 对一个有序数组进行二分查找
 *
 * @author JINSHENGJIE
 */
public class BinarySearch {

    private static final Logger logger = LoggerFactory.getLogger(BinarySearch.class);

    public static void main(String[] args) {
        int[] array = {1, 3, 6, 5, 7, 34, 2, 8, 9, 12, 67, 98, 46, 23, 4};
        Arrays.sort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ",");
        }
        logger.info("================排序后查找===================");
        logger.info(String.valueOf(binarySearch(array, 46)));
        logger.info(String.valueOf(binarySearchByRecurive(array, 3, array.length - 3, 23)));
    }

    /**
     * 非递归方式
     *
     * @param a
     * @param n
     * @return
     */
    private static int binarySearch(int[] a, int n) {

        int low = 0;
        int high = a.length - 1;
        int mid = (a.length - 1) / 2;
        if (n == a[mid]) {
            return mid;
        }
        while (low <= high) {
            /*mid = (high+low)/2
            此方法可能会造成最后的结果为负值，也就是high+low最后的结果会大于int的最大值2^31 - 1
            */

            // mid = ((high -low) >>1) +low;
            mid = ((high - low) >>> 1) + low;

            // mid = (high - low) / 2 + low;
            if (n < a[mid]) {
                high = mid - 1;
            } else if (n > a[mid]) {
                low = mid + 1;
            } else {
                return mid; // 相等的情况放在最后，毕竟数组中不相等的情况更多。否则每次循环都要进行判断想等，耗时耗资源
            }
        }

        return -1;
    }

    /**
     * 递归方式二分查找
     *
     * @param array
     * @param low
     * @param high
     * @param key
     * @return
     */
    private static int binarySearchByRecurive(int[] array, int low, int high, int key) {
        if (low <= high) {
            int mid = ((high - low) >> 1) + low;
            if (array[mid] == key) {
                return mid;
            } else if (array[mid] > key) {
                return binarySearchByRecurive(array, low, mid - 1, key);
            } else if (array[mid] < key) {
                return binarySearchByRecurive(array, mid - 1, high, key);
            }
        }
        return -1;

    }
}
