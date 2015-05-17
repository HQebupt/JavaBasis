package org.hq.detail;

public class LongTrap {

	/**
	 * 丧心病狂的包装类型细节:Long 和Integer 缓存了 [-128, 127]范围内的值。
	 * This is the result of auto-boxing. See Long.valueOf().
	 */
	public static void main(final String[] args) {
		final Long n = 0L;
		final Long m = 0L;
		System.out.println(n + " == " + m + " : " + (n == m));

		final Long a = 127L;
		final Long b = 127L;
		System.out.println(a + " == " + b + " : " + (a == b));

		final Long A = 128L;
		final Long B = 128L;
		System.out.println(A + " == " + B + " : " + (A == B));

		final Long x = -128L;
		final Long y = -128L;
		System.out.println(x + " == " + y + " : " + (x == y));

		final Long X = -129L;
		final Long Y = -129L;
		System.out.println(X + " == " + Y + " : " + (X == Y));
	}
	/**
	 * OutPut:
	 * 0 == 0 : true
	 * 127 == 127 : true
	 * 128 == 128 : false
	 * -128 == -128 : true
	 * -129 == -129 : false
	 */

}
