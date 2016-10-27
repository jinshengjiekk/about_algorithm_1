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
        int[] arr1 = {1, 1, 1, 2, 2, 2, 2, 3};
        int[] arr2 = {54, 32, 31, 31, 23, 23, 23, 23, 23, 23, 23, 21, 21, 10, 10, 10, 2, 1};
        int[] arr3 = {1, 2};
        int[] arr4 = {1};
        int[] arr5 = {1, 2, 3};

        System.out.println("****************removeDuplicate_1*******************");
        System.out.println(rdfs2.removeDuplicate_1(arr0));
        System.out.println(rdfs2.removeDuplicate_1(arr1));
        System.out.println(rdfs2.removeDuplicate_1(arr2));
        System.out.println(rdfs2.removeDuplicate_1(arr3));
        System.out.println(rdfs2.removeDuplicate_1(arr4));
        System.out.println(rdfs2.removeDuplicate_1(arr5));
        System.out.println("****************removeDuplicate_2*******************");
        System.out.println(rdfs2.removeDuplicate_2(arr0));
        System.out.println(rdfs2.removeDuplicate_2(arr1));
        System.out.println(rdfs2.removeDuplicate_2(arr2));
        System.out.println(rdfs2.removeDuplicate_2(arr3));
        System.out.println(rdfs2.removeDuplicate_2(arr4));
        System.out.println(rdfs2.removeDuplicate_2(arr5));
        System.out.println("****************removeDuplicate_3*******************");
        System.out.println(rdfs2.removeDuplicate_3(arr0));
        System.out.println(rdfs2.removeDuplicate_3(arr1));
        System.out.println(rdfs2.removeDuplicate_3(arr2));
        System.out.println(rdfs2.removeDuplicate_3(arr3));
        System.out.println(rdfs2.removeDuplicate_3(arr4));
        System.out.println(rdfs2.removeDuplicate_3(arr5));

    }

    /**
     * Remove duplicate int.
     * ===original===
     * 此方法相对简单明了，利用两个指针同向移动；
     *
     * @param nums the nums
     * @return the int 返回的是过滤后的长度，数组长度仍然没有变，后面的元素存在重复现象
     */
    public int removeDuplicate_1(int[] nums) {
        int l = nums.length;
        if (l == 0 || nums == null) {
            return 0;
        }
        int i = 1;
        int j = 0;
        int count = 1;
        for (; i < l; i++) {
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

        System.out.println(Arrays.toString(nums));
        return j + 1;
    }

    /**
     * Remove duplicate 2 int.
     * 此方法相对复杂难懂，利用双指针交叉移动；
     * 返回的数组满足要求，但是返回的长度不对！但是Accepted了。
     *
     * @param nums the nums
     * @return the int
     */
    public int removeDuplicate_2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
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
        System.out.println(Arrays.toString(nums));
        return cur;
    }

    /**
     * Remove duplicate 3 int.
     * 此方法返回的长度同样也是达不到要求；但是Accepted了。
     * @param nums the nums
     * @return the int
     */
    public int removeDuplicate_3(int[] nums) {
        int i = 0;
        for (int n : nums)
            if (i < 2 || n != nums[i - 2]) {
                nums[i++] = n;
            }
        System.out.println(Arrays.toString(nums));
        return i;
    }

}

