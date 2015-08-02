package effective.java;

import java.util.Arrays;
import java.util.Comparator;

public class R12 {
	public static void main(String[] args) {
		Integer[] arr = { 1, 2, 3, 5, 4 };
		Comparator<Integer> cmp = new Comparator<Integer>() {
			public int compare(Integer i1, Integer i2) {
				return i1 > i2 ? 1 : (i1 == i2 ? 0 : -1);
			}
		};
		Arrays.sort(arr, cmp);
		for (Integer i : arr)
			System.out.println(i);
	}
}
