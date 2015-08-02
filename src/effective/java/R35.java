package effective.java;

public class R35 {

	/**
	 * Enum可以继承么?
	 * Ans：不可以。
	 */
	public static enum  Parent {
		A,B;
	}
	
	// 下面的報錯
	// public static enum Child extends Parent {
	// }
	
	public static void main(String[] args) {
	}
}
