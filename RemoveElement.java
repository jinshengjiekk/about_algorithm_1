import java.util.Arrays;

/**
 * Created by JINSHENGJIE on 16/10/14 .
 *      =================================================================================
 * Given an array and a value, remove all instances of that value in place and return the new length.
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 * Example:
 * Given input array nums = [3,2,2,3], val = 3
 * Your function should return length = 2, with the first two elements of nums being 2.
 *      =================================================================================
 */
public class RemoveElement {

    /**
     * @param nums
     * @param val
     * @return 返回的仅仅是原数组被删除选定元素后的表象长度，数组的长度仍然不变，元素会有变动，后面的元素会重复。
     */
    public static int removeElement(int[] nums, int val) {
        int length = nums.length;
        int i = 0;
        int j = 0;
        for (; i < length; i++) {
            if (nums[i] == val) {
                continue;
            }
            nums[j++] = nums[i];
        }
        System.out.println(Arrays.toString(nums));
        return j;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 5, 6, 1, 5, 7, 8, 45, 0};
        int target = 5;
        int resultLength = removeElement(arr, target);
        System.out.println(resultLength);
    }

}
