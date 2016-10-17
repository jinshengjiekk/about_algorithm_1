package java_example;

import java.util.Arrays;

/**
 * Created by JINSHENGJIE on 16/10/17 .
 * ===================================================================================================
 * Follow up for "Remove Duplicates":
 * What if duplicates are allowed at most twice?
 * For example,
 * Given sorted array nums = [1,1,1,2,2,3],
 * Your function should return length = 5,
 * with the first five elements of nums being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new length.
 * ===================================================================================================
 */
public class RemoveDuplicatesFromSortedArrayII {

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArrayII rdfs2 = new RemoveDuplicatesFromSortedArrayII();
        int[] arr0 = {};
        int[] arr1 = {1, 1, 1, 2, 2, 3};
        int[] arr2 = {54, 32, 31, 31, 23, 23, 23, 23, 23, 23, 23, 21, 21, 10, 10, 10, 2, 1};
        int[] arr3 = {1, 2};
        int[] arr4 = {1};
        System.out.println(rdfs2.removeDuplicate(arr0));
        System.out.println(rdfs2.removeDuplicate(arr1));
        System.out.println(rdfs2.removeDuplicate(arr2));
        System.out.println(rdfs2.removeDuplicate(arr3));
        System.out.println(rdfs2.removeDuplicate(arr4));

    }

    /**
     * Remove duplicate int.
     * ===original===
     *
     * @param arr the arr
     * @return the int 返回的是过滤后的长度，数组长度仍然没有变，后面的元素存在重复现象
     */
    public int removeDuplicate(int[] arr) {
        int l = arr.length;
        if (l == 0) {
            return 0;
        }
        int i = 0;
        int j = 1;
        for (; i < l; i++, j++) {
            if (arr[i] == arr[--j] && j >= 1 && arr[i] == arr[j - 1]) {
                continue;
            }
            if (j == 0) {
                arr[j++] = arr[i];
            } else if (j < l - 1) {
                arr[++j] = arr[i];
            }
        }

        System.out.println(Arrays.toString(arr));
        return j;
    }

}
