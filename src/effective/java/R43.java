package effective.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class R43 {
	// 零大小数组的生成方法如下，更好的做法是利用`Collections.emptyList()`
	private final List<Integer> cheeseInStock = new ArrayList<Integer>();
	private static final Integer[] EMPTY_CHEESE_ARRAY = new Integer[0];
	/*
	 * @return an array containing all of the cheeses in the shop.
	 */
	public Integer[] getCheeses() {
		return cheeseInStock.toArray(EMPTY_CHEESE_ARRAY);
	}
	
	
	public static void main(String[] args) {
		Collections.emptySet();
		Long l = 1L;
		Long l1 = 1L;
		System.out.println(l.equals(l1));
	}
}
