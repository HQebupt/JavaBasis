package jvm;

import java.util.*;

public class HeapOOM {

	/**
	 * 1堆：创建对象过多，导致OOM
	 * java.lang.OutOfMemoryError: Java heap space 
	 * -Xms20m -Xmx20m -Xmn10m
	 */
	static class OOMObject {
	}

	public static void main(String[] args) {
		List<OOMObject> list = new ArrayList<OOMObject>();
		while (true) {
			list.add(new OOMObject());
		}
	}
}
