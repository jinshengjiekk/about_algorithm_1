package java_example;

import java.util.Arrays;

/**
 * Created by JINSHENGJIE on 16/10/14 .
 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 * For example,
 * Given input array nums = [1,1,2],
 * Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the new length.
 * Subscribe to see which companies asked this question
 */
public class RemoveDuplicatesFromSortedArray {
    /**
     * Remove duplicates int.
     *
     * @param sortedArray the sorted arrays
     * @return the int
     */
    public int removeDuplicates(int[] sortedArray) {
        int length = sortedArray.length;
        int i = 0;
        int j = 1;
        for (; i < length ; i++, j++) {
            if (sortedArray[--j] == sortedArray[i]) {
                continue;
            }
            sortedArray[++j] = sortedArray[i];
        }
        System.out.println(Arrays.toString(sortedArray));
        return j;
    }

    public static void main(String[] args) {
        int[] sortedArray = {1, 2, 4, 4, 4, 4, 5, 5, 5, 5, 6, 6, 7, 8, 9};
        RemoveDuplicatesFromSortedArray rdfs = new RemoveDuplicatesFromSortedArray();
        System.out.println(rdfs.removeDuplicates(sortedArray));
    }
}
