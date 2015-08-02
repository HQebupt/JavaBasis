package jvm;

public class JavaVMStackOOM {
	/**
	 *  3栈：创建线程过多，导致OOM
	 * java.lang.OutOfMemoryError：unable to create new native thread
	 * -Xss2M
	 */
	private void dontStop() {
		while (true) {
		}
	}

	public void stackLeakByThread() {
		while (true) {
			Thread thread = new Thread(new Runnable() {
				@Override
				public void run() {
					dontStop();
				}
			});
			thread.start();
		}
	}

	public static void main(String[] args) throws Throwable {
		JavaVMStackOOM oom = new JavaVMStackOOM();
		oom.stackLeakByThread();
	}
}
