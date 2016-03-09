package com.jsj.poj;

//2016年2月26日下午9:38:48
public class MoveZeros {

	public MoveZeros() {

	}

	public static void main(String[] args) {
		int[] array = { 2, 3, 0, 6, 3, 5, 0, 3, 4, 0, 5 };
		/*int[] resultArray = moveZero1(array);
		for (int i = 0; i < resultArray.length; i++) {
			System.out.println(resultArray[i]);
		}*/

		moveZeros3(array);
	}

	/**
	 * 遇到数值为O的数,将它后面的数统统往前移一位，最后一位补0。 ===》移动次数较多，有冗余移动，尤其是最后都为0的时候仍然去交换，直到最后一个数。
	 * 
	 * @param array
	 * @return
	 */
	private static int[] moveZero1(int[] array) {
		int length = array.length;
		for (int i = 0; i < length; i++) {
			if (array[i] == 0) {
				for (int f = i; f < length - 1; f++) {
					array[f] = array[f + 1];
				}
				array[length - 1] = 0;
			}
		}
		return array;

	}

	/**
	 * 首先将数组中不为零的数值重新放在数组的前面，后面的不足数组长度的位置补零 ===> 此方法不足的地方在于不是将0移动到最后，而是统一在最后位置补0
	 * 
	 * @param array
	 * @return
	 */
	private static int[] moveZero2(int[] array) {
		int f = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] != 0) {
				array[f] = array[i];
				f++;
			}
		}
		for (int i = f; i < array.length; i++) {
			array[i] = 0;
		}
		return array;
	}

	/**
	 * 双指针移动，将0和第一个非0调换位置
	 * 相当于将0逐渐向后冒泡
	 * 
	 * @param array
	 */
	private static void moveZeros3(int[] array) {
		if (array != null && array.getClass().isArray()) {
			for (int i = 0, j = 0; i < array.length; i++) {
				if (array[i] != 0) {
					if (i != j) {
						array[j] = array[i];
						array[i] = 0;
					}
					j++;
				}

			}
		}
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]);
		}
	}
}
