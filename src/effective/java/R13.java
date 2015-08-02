package effective.java;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class R13 {

	// 返回不可变的静态域的两种方法：
	// 1.Collections.unmodifiableList()
	private static final String[] PRIVATE_VALUES = { "A", "B", "C" };
	public static final List<String> VALUES = Collections
			.unmodifiableList(Arrays.asList(PRIVATE_VALUES));

	// 2.clone()
	public static final String[] values() {
		return PRIVATE_VALUES.clone();
	}
}
