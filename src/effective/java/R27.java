package effective.java;

import java.util.Arrays;
import java.util.Collections;

public class R27 {
	public interface UnaryFunction<T> {
		T apply(T arg);
	}

	// 私有 单例
	private static UnaryFunction<Object> IDENTITY_FUNCTION = new UnaryFunction<Object>() {
		public Object apply(Object arg) {
			return arg;
		}
	};

	// 共享单例
	@SuppressWarnings("unchecked")
	public static <T> UnaryFunction<T> identityFunction() {
		return (UnaryFunction<T>) IDENTITY_FUNCTION;
	}

	public static void main(String[] args) {
		String[] strs = { "jute", "hemp", "nylon" };
		UnaryFunction<String> sameString = R27.identityFunction();
		for (String s : strs) {
			System.out.println(sameString.apply(s));
		}

		Number[] nums = { 1, 2.0, 3L };
		UnaryFunction<Number> sameNumber = R27.identityFunction();
		for (Number num : nums) {
			System.out.println(sameNumber.apply(num));
		}

		Collections.reverseOrder();
		Arrays.sort(strs, Collections.reverseOrder());
		for (String s : strs) {
			System.out.println(sameString.apply(s));
		}
		
	}
	
}
