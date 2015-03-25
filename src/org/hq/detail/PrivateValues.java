package org.hq.detail;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 
 * @author HuangQiang
 * @date 2015-3-25
 * 
 * 长度非0的数组总是可变的。
 */
public class PrivateValues {

	// Potential security hole! Never do this.
	public static final Thing[] VALUES = { new Thing("1"), new Thing("2") };

	public static void main(String[] args) {
		PrivateValues.VALUES[0] = new Thing("0");
		System.out.println("不安全的做法：" + PrivateValues.VALUES[0]);
		
		Thing[] ths = PrivateValues.Solution2.values();
		ths[0] = new Thing("4");
		System.out.println("自己意会：" + ths[0]);
	}

	// Solution 1
	static class Solution1 {
		private static final Thing[] PRIVATE_VALUES = { new Thing("1"),
				new Thing("2") };
		public static final List<Thing> VALUES1 = (List<Thing>) Collections
				.unmodifiableCollection(Arrays.asList(PRIVATE_VALUES));
	}

	// Solution 2
	static class Solution2 {
		private static final Thing[] PRIVATE_VALUES = { new Thing("1"),
				new Thing("2") };

		public static final Thing[] values() {
			return PRIVATE_VALUES.clone();
		}
	}
	
	// class Thing
	static class Thing {
		String thing;

		Thing(String thing) {
			this.thing = thing;
		}

		@Override
		public String toString() {
			return thing;
		}
	}

}
