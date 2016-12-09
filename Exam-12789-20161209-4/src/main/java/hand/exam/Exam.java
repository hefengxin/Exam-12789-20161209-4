package hand.exam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class Exam {
	static Random r = new Random();
	static List<Integer> list = new ArrayList<Integer>();
	static List<Integer> sortList = new ArrayList<Integer>();
	static Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
	static Map<Integer, List<Integer>> sortMap = new HashMap<Integer, List<Integer>>();
	

	public static void main(String[] args) {
		System.out.print("随机生成50个小于100的整数，分别为：");
		for (int i = 0; i < 50; i++) {
			int num = r.nextInt(100);
			list.add(num);
			System.out.print(num + ",");
		}

		/*
		 * 得到map
		 */
		Map<Integer, List<Integer>> firstMap = getMap();
		System.out.println();
		System.out.println("map中的数据为：" + firstMap.toString());
		/*
		 * 得到排序后的map
		 */
		lastSortMap();

	}
	private static void lastSortMap() {
		Set<Integer> k = map.keySet();
		Iterator<Integer> it1 = k.iterator();
		while (it1.hasNext()) {
			sortList.add(it1.next());
		}
		
		Collections.sort(sortList); //排序
		Iterator<Integer> it2 = sortList.iterator();
		while (it2.hasNext()) {
			sortMap.put(it2.next(), list);
		}
		System.out.println("排序后map为：" + sortMap.toString());
	}

	private static Map<Integer, List<Integer>> getMap() {
		Iterator<Integer> it = list.iterator();
		while (it.hasNext()) {
			map.put(Math.round(it.next() / 10), list);
		}
		return map;
	}
}
