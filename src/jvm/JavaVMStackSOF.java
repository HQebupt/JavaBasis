package jvm;

/**
 * 2栈：大量本地的变量，导致SOF
 * java.lang.StackOverflowError 
 * -Xss128k
 * @author Administrator
 */
public class JavaVMStackSOF {
	private int stackLength = 1;

	public void stackLeak() {
		stackLength++;
		stackLeak();
	}

	public static void main(String[] args) throws Throwable {
		JavaVMStackSOF som = new JavaVMStackSOF();
		try {
			som.stackLeak();
		} catch (Throwable e) {
			System.out.println("Stack length: " + som.stackLength);
			throw e;
		}
	}
}
