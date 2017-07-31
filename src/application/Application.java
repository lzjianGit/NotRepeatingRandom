package application;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import util.DBHelper;
import util.NothingInfo;
import util.RandomNum;

public class Application {

	public static void main(String[] args) {
		List<NothingInfo> infolist = new ArrayList<>();
		List<Integer> numlist = new ArrayList<>();
		RandomNum ran = new RandomNum();
		//j < 最大生成数量
		for (int j = DBHelper.DBselectCount(); j < 10000; j++) {
			int num = ran.randomNum();
			if (DBHelper.DBselect(num) != 0) {
				for (int i = 1; i > 0; i++) {
					num = ran.randomNum();
					if (DBHelper.DBselect(num) == 0) {
						DBHelper.DBinsert(num);
						break;
					}
				}
			} else {
				DBHelper.DBinsert(num);
			}
		}
		infolist = DBHelper.DBselectAll();
		// 提取所有num
		for (int i = 0; i < infolist.size(); i++) {
			numlist.add(infolist.get(i).getNumber());
		}
		// 从小到大排序num
		for (int i = 0; i < numlist.size() - 1; i++) {
			for (int j = 1; j < numlist.size() - i; j++) {
				Integer a;
				if ((numlist.get(j - 1)).compareTo(numlist.get(j)) > 0) { // 比较两个整数的大小

					a = numlist.get(j - 1);
					numlist.set((j - 1), numlist.get(j));
					numlist.set(j, a);
				}
			}
		}
		// 输出所有经过排序的num
		for (Integer i : numlist) {
			System.err.println(i);
		}
	}
}
