package jvm;

import java.util.*;

public class RuntimeConstantPoolOOM {

	/**
	 * 4方法区：常量池过多常量，溢出OOM
	 * VM Args : -XX:PermSize=10m -XX:MaxPermSize=10m
	 * java.lang.OutOfMemoryError: PermGen space
	 */
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		int i = 0;
		while (true) {
			list.add(String.valueOf(i++).intern());
		}

	}
}
