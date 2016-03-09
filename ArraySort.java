package com.jsj.array;

import java.util.Date;
import java.util.Random;

/**
 * 排序测试类
 * 
 * 排序算法的分类如下：
 * 
 * 1.插入排序（直接插入排序、折半插入排序、希尔排序）；
 * 
 * 2.交换排序（冒泡泡排序、快速排序）；
 * 
 * 3.选择排序（直接选择排序、堆排序）；
 * 
 * 4.归并排序；
 * 
 * 5.基数排序。
 * 
 * 
 * 
 * 关于排序方法的选择：
 * 
 * (1)若n较小(如n≤50)，可采用直接插入或直接选择排序。
 * 
 * 　当记录规模较小时，直接插入排序较好；否则因为直接选择移动的记录数少于直接插人，应选直接选择排序为宜。
 * 
 * (2)若文件初始状态基本有序(指正序)，则应选用直接插人、冒泡或随机的快速排序为宜；
 * 
 * (3)若n较大，则应采用时间复杂度为O(nlgn)的排序方法：快速排序、堆排序或归并排序。
 * 
 * 
 */

/**
 * @author JINSHENGJIE
 *
 */
public class ArraySort {

	public ArraySort() {

	}

	/**
	 * 初始化测试数组的方法
	 * 
	 * @return 一个初始化好的数组
	 */
	public int[] createArray() {
		Random random = new Random();
		int[] array = new int[1000];
		for (int i = 0; i < array.length; i++) {
			array[i] = random.nextInt(100) - random.nextInt(100);// 生成两个随机数相减，保证生成的数中有负数
		}
		System.out.println("==========原始序列=============");
		printArray(array);
		return array;
	}

	/**
	 * 打印数组元素
	 * 
	 * @param array
	 */
	private static void printArray(int[] array) {
		for (int i : array) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	/**
	 * 交换数组中指定的两元素的位置
	 * 
	 * @param array
	 * @param x
	 * @param y
	 */
	private void swap(int[] array, int x, int y) {
		int temp = array[x];
		array[x] = array[y];
		array[y] = temp;
	}

	// ===============================================================================================================
	/**
	 * 冒泡排序----交换排序的一种
	 * 方法：相邻两元素进行比较，如有需要则进行交换，每完成一次循环就将最大元素排在最后（如从小到大排序），下一次循环是将其他的数进行类似操作。
	 * 性能：比较次数O(n^2),n^2/2；交换次数O(n^2),n^2/4
	 * 
	 * @param array
	 * @param sortType
	 */
	public void bubbleSort(int[] array, String sortType) {
		if ("desc".equals(sortType)) { // 倒排序，从大排到小
			for (int i = 1; i < array.length; i++) {// 比较的轮数
				for (int j = 0; j < array.length - i; j++) {
					if (array[j] < array[j + 1]) {// 将相邻两个数进行比较，较小的数往后冒泡
						swap(array, j, j + 1);// 交换相邻两个数
					}
				}

			}
		} else if ("asc".equals(sortType)) {// 正排序，从小排到大
			for (int i = 1; i < array.length; i++) { // 比较的轮数
				for (int j = 0; j < array.length - i; j++) {
					if (array[j] > array[j + 1]) {// 将相邻两个数进行比较，较大的数往后冒泡
						swap(array, j, j + 1);// 交换相邻两个数
					}
				}

			}

		} else {
			System.out.println("你输入的排序类型错误！请检查！");
		}
		printArray(array);
	}

	// =====================================================================================================
	/**
	 * 
	 * 直接选择排序法----选择排序的一种
	 * 
	 * 方法：每一趟从待排序的数据元素中选出最小（或最大）的一个元素， 顺序放在已排好序的数列的最后，直到全部待排序的数据元素排完。
	 * 
	 * 性能：比较次数O(n^2),n^2/2
	 * 
	 * 交换次数O(n),n
	 * 
	 * 交换次数比冒泡排序少多了，由于交换所需CPU时间比比较所需的CUP时间多，所以选择排序比冒泡排序快。
	 * 
	 * 但是N比较大时，比较所需的CPU时间占主要地位，所以这时的性能和冒泡排序差不太多，但毫无疑问肯定要快些。
	 */

	/**
	 * 直接选择排序
	 * 
	 * @param array
	 * @param sortType
	 */
	public void selectSort(int[] array, String sortType) {
		int index;
		for (int i = 0; i < array.length; i++) {
			if ("desc".equals(sortType)) {
				index = 0;
				for (int j = 1; j < array.length - i; j++) {
					if (array[j] < array[index]) {
						index = j;
					}
				}
				swap(array, array.length - i - 1, index);

			} else if ("asc".equals(sortType)) {
				index = 0;
				for (int j = 1; j < array.length - i; j++) {
					if (array[j] > array[index]) {
						index = j;
					}
				}
				swap(array, array.length - i - 1, index);
			} else {
				System.out.println("你输入的排序类型不对，请重新输入!");
			}
		}
		printArray(array);
	}

	// ====================================================================
	/**
	 * @param array
	 * @param sortType
	 */
	public void selectSort2(int[] array, String sortType) {
		int index;
		if ("asc".equals(sortType)) {// 正排序，从小排到大
			for (int i = 1; i < array.length; i++) {
				index = 0;
				for (int j = 1; j <= array.length - i; j++) {
					if (array[j] > array[index]) {
						index = j;
					}
				}
				swap(array, array.length - i, index);// 交换在位置array.length-i和index(最大值)两个数
			}
		} else if ("desc".equals(sortType)) {// 倒排序，从大排到小
			for (int i = 1; i < array.length; i++) {
				index = 0;
				for (int j = 1; j <= array.length - i; j++) {
					if (array[j] < array[index]) {
						index = j;
					}
				}
				swap(array, array.length - i, index);// 交换在位置data.length-i和index(最大值)两个数
			}
		} else {
			System.out.println("你输入的排序方式不对，请重新输入！");
		}
		printArray(array);
	}

	// =================================================================================================

	/**
	 * 
	 * 插入排序
	 * 
	 * 方法：将一个记录插入到已排好序的有序表（有可能是空表）中,从而得到一个新的记录数增1的有序表。
	 * 
	 * 性能：比较次数O(n^2),n^2/4
	 * 
	 * 复制次数O(n),n^2/4
	 * 
	 * 比较次数是前两者的一倍，而复制所需的CPU时间较交换少，所以性能上比冒泡排序提高一倍多，而比选择排序也要快。
	 */

	public void insertSort(int[] array, String sortType) {
		if ("asc".equals(sortType)) {// 正排序，从小排到大
			for (int i = 1; i < array.length; i++) {// 比较的轮数
				for (int j = 0; j < i; j++) {// 保证前i+1个数排好序
					if (array[j] > array[i]) {
						swap(array, i, j);
					}
				}
			}
		} else if ("desc".equals(sortType)) {
			for (int i = 1; i < array.length; i++) {
				for (int j = 0; j < i; j++) {
					if (array[j] < array[i]) {
						swap(array, i, j);
					}
				}
			}

		} else {
			System.out.println("你输入的排序类型不正确，请重新输入！");
		}

		printArray(array);
	}

	// =============================================================================

	/**
	 * 反转数组的方法1
	 * 
	 * @param array
	 */
	public void reverse1(int[] array) {
		int length = array.length;
		int temp = 0;
		for (int i = 0; i < array.length / 2; i++) {
			temp = array[i];
			array[i] = array[length - i - 1];
			array[length - i - 1] = temp;
		}

		printArray(array);
	}

	/**
	 * 反转数组方法2
	 * 
	 * @param array
	 */
	public void reverse2(int[] array) {
		int left = 0;
		int right = array.length - 1;
		int temp;
		while (left < right) {
			temp = array[left];
			array[left] = array[right];
			array[right] = temp;
			left++;
			right--;
		}
		printArray(array);
	}

	// ====================================================================================
	/**
	 * 快速排序算法
	 * 
	 * @param data
	 *            目标数组
	 * @param start
	 *            起始位
	 * @param end
	 *            结束位
	 */
	public static void quickSort(int[] data, int start, int end) {
		// 设置关键数据key为要排序数组的第一个元素，
		// 即第一趟排序后，key右边的数全部比key大，key左边的数全部比key小
		int key = data[start];
		// 设置数组左边的索引，往右移动比key大的数
		int i = start;
		// 设置数组右边的索引，往左移动比key小的数
		int j = end;
		// 如果左边索引比右边索引小，则还有数据没有排序
		while (i < j) {
			while (data[j] >= key && j > i) {
				j--;
				// System.out.println(j);
			}
			data[i] = data[j];

			while (data[i] <= key && i < j) {
				i++;
				// System.out.println(i);
			}
			data[j] = data[i];

			// System.out.println("i="+i+",j="+j);
		}
		// 此时 i==j
		data[i] = key;

		// 递归调用
		if (i - 1 > start) {
			// 递归调用，把key前面的完成排序
			quickSort(data, start, i - 1);
		}
		if (i + 1 < end) {
			// 递归调用，把key后面的完成排序
			quickSort(data, i + 1, end);
		}

	}

	// =====================================================================================
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArraySort arraySort = new ArraySort();
		int[] arrayInt = arraySort.createArray();
		// System.out.println("===========原始数组============");
		// arraySort.printArray(arrayInt);

		System.out.println("=========冒泡排序后（正序）=============");
		Date dateStart1 = new Date();
		arraySort.bubbleSort(arrayInt, "asc");
		Date dateEnd1 = new Date();
		System.out.println("冒泡排序（正序）用时===========>>>"
				+ (dateEnd1.getTime() - dateStart1.getTime()) + "毫秒");

		System.out.println("=========冒泡排序后（倒序）=============");
		Date dateStart2 = new Date();
		arraySort.bubbleSort(arrayInt, "desc");
		Date dateEnd2 = new Date();
		System.out.println("冒泡排序（倒序）用时===========>>>"
				+ (dateEnd2.getTime() - dateStart2.getTime()) + "毫秒");
		// ====================================================================
		arrayInt = arraySort.createArray();
		System.out.println("=========直接选择排序后（正序）=============");
		Date dateStart3 = new Date();
		arraySort.selectSort(arrayInt, "asc");
		Date dateEnd3 = new Date();
		System.out.println("直接选择排序（正序）用时===========>>>"
				+ (dateEnd3.getTime() - dateStart3.getTime()) + "毫秒");

		System.out.println("=========直接选择排序后（倒序）=============");
		Date dateStart4 = new Date();
		arraySort.selectSort(arrayInt, "desc");
		Date dateEnd4 = new Date();
		System.out.println("直接选择排序（倒序）用时===========>>>"
				+ (dateEnd4.getTime() - dateStart4.getTime()) + "毫秒");
		// ================================================================
		arrayInt = arraySort.createArray();
		System.out.println("=========直接选择排序2后（正序）=============");
		Date dateStart5 = new Date();
		arraySort.selectSort2(arrayInt, "asc");
		Date dateEnd5 = new Date();
		System.out.println("直接选择排序2（正序）用时===========>>>"
				+ (dateEnd5.getTime() - dateStart5.getTime()) + "毫秒");

		System.out.println("=========直接选择排序2后（倒序）=============");
		Date dateStart6 = new Date();
		arraySort.selectSort2(arrayInt, "desc");
		Date dateEnd6 = new Date();
		System.out.println("直接选择排序2（倒序）用时===========>>>"
				+ (dateEnd6.getTime() - dateStart6.getTime()) + "毫秒");
		// ==============================================================
		arrayInt = arraySort.createArray();
		System.out.println("=========插入排序（正序）=============");
		Date dateStart7 = new Date();
		arraySort.insertSort(arrayInt, "asc");
		Date dateEnd7 = new Date();
		System.out.println("插入排序（正序）用时===========>>>"
				+ (dateEnd7.getTime() - dateStart7.getTime()) + "毫秒");

		System.out.println("=========插入排序（倒序）=============");
		Date dateStart8 = new Date();
		arraySort.insertSort(arrayInt, "desc");
		Date dateEnd8 = new Date();
		System.out.println("插入排序（倒序）用时===========>>>"
				+ (dateEnd8.getTime() - dateStart8.getTime()) + "毫秒");
		// ============================================================================
		arrayInt = arraySort.createArray();
		System.out.println("=========反转数组方法1=============");
		Date dateStart9 = new Date();
		arraySort.reverse1(arrayInt);
		Date dateEnd9 = new Date();
		System.out.println("反转数组方法1用时===========>>>"
				+ (dateEnd9.getTime() - dateStart9.getTime()) + "毫秒");

		System.out.println("=========反转数组方法2=============");
		Date dateStart10 = new Date();
		arraySort.reverse2(arrayInt);
		Date dateEnd10 = new Date();
		System.out.println("反转数组方法2用时===========>>>"
				+ (dateEnd10.getTime() - dateStart10.getTime()) + "毫秒");

		arrayInt = arraySort.createArray();
		System.out.println("=========快速排序=============");
		long start = System.currentTimeMillis();
		quickSort(arrayInt, 0, arrayInt.length - 1);
		printArray(arrayInt);
		System.out.println("快速排序用时===========>>>"
				+ (System.currentTimeMillis() - start) + "毫秒");
	}
}
