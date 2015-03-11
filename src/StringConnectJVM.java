public class StringConnectJVM {

	/**
	 * Java虚拟机对字符串的优化
	 * @param args
	 */
	public static void main(String[] args) {
		final String t1 = "handsome";
		String t2 = "handsome";
		String s0 = "You are handsome";
		String s1 = "You are " + t1;
		String s2 = "You are " + t2;
		System.out.println("t1 == t2:" + (t1 == t2));
		System.out.println("s0 == s1:" + (s0 == s1));
		System.out.println("s0 == s2:" + (s0 == s2));
		System.out.println("s1 == s2:" + (s1 == s2));
	}
	/**
	 * OutPut：
	 * t1 == t2:true
	 * s0 == s1:true
	 * s0 == s2:false
	 * s1 == s2:false
	 */
}
