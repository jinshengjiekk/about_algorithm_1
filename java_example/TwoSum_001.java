package java_example;

import java.util.HashMap;
import java.util.Map;

//2016年3月9日下午5:12:29
/**
 * 给定一个数组和一个目标数值，找出数组中两个数值相加等于给定目标数值的位置(基于1开始)
 * 
 * @author JINSHENGJIE
 *
 */
public class TwoSum_001 {

	public TwoSum_001() {
	}

	public static void main(String[] args) {
		int[] intArray = { 1, 3, 5, 6, 7, 34, 75, 2, 3, 6, 8 };
		int target = 9;
		findIndexsInArray1(intArray, target);
		findIndexsInArray2(intArray, target);
		findIndexsInArray3(intArray, target);
		findIndexsInArray4(intArray, target);
	}

	/**
	 * 此方法简单直接粗暴，直接从头遍历数组，找到两个数相加等于目标数组的就返回，没有就为空
	 * 
	 * @param intArray
	 * @param target
	 * @return
	 */
	private static int[] findIndexsInArray1(int[] intArray, int target) {
		int[] resultIndexs = new int[2];
		if (intArray != null) {

			outer: for (int i = 0; i < intArray.length; i++) {
				for (int j = i + 1; j < intArray.length; j++) {
					if (intArray[i] + intArray[j] == target) {
						resultIndexs[0] = i + 1;
						resultIndexs[1] = j + 1;
						// 若果不加上"break outer"跳出外层循环的标签，最后的结果是数组中最后两个匹配的，而不是最开始就匹配的两个数值
						break outer;

					}
				}
			}
		}

		for (int i = 0; i < resultIndexs.length; i++) {
			System.out.println(resultIndexs[i]);
		}
		return resultIndexs;
	}

	/**
	 * 利用map的完成查找，　 此方法有缺陷，找到的组合不一定是从嘴最开始的优先组合，有可能中间是中间两个数值的组合
	 * 
	 * @param intArray
	 * @param target
	 */
	private static void findIndexsInArray2(int[] intArray, int target) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int[] resultArr = new int[2];
		for (int i = 0; i < intArray.length; i++) {
			if (map.containsKey(intArray[i])) {
				resultArr[0] = map.get(intArray[i]) + 1;
				resultArr[1] = i + 1;
				break;// 如果不加break,返回的结果是数组中最后的匹配
			} else {
				map.put(target - intArray[i], i);
			}
		}
		System.out.println("==================findIndexsInArray2====================");
		for (int i = 0; i < resultArr.length; i++) {
			System.out.print(resultArr[i] + "--");
		}
		System.out.println();
	}

	/**
	 * 将可能的组合放进map里，这样可以查询出来没有重复位置出现的组合。
	 * 找出key最小的map，就可以找出最先出现的组合，克服了findIndexsInArray2中的缺陷
	 * 
	 * @param intArr
	 * @param target
	 */
	private static void findIndexsInArray3(int[] intArr, int target) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		Map<Integer, Integer> resultMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < intArr.length; i++) {
			if (map.containsKey(intArr[i])) {
				resultMap.put(map.get(intArr[i]) + 1, i + 1);
			} else {
				map.put(target - intArr[i], i);
			}
		}
		System.out.println("===================findIndexInArray3=======================");
		for (Map.Entry<Integer, Integer> entry : resultMap.entrySet()) {
			System.out.println(entry.getKey() + "----" + entry.getValue());
		}
	}

	/**
	 * @param intArr
	 * @param target
	 */
	private static void findIndexsInArray4(int[] intArr, int target) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		Map<Integer, Integer> resultMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < intArr.length; i++) {
			if (map.containsKey(target - intArr[i])) {
				resultMap.put(map.get(target - intArr[i]) + 1, i + 1);
			}
			map.put(intArr[i], i);
		}
		System.out.println("===================findIndexInArray4=======================");
		for (Map.Entry<Integer, Integer> entry : resultMap.entrySet()) {
			System.out.println(entry.getKey() + "----" + entry.getValue());
		}
	}
}
