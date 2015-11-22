package org.hq.collections;

import java.util.BitSet;

public class BitTest {
	/**
	 * 如何用BitSet来存储对应的值。节约空间
	 * 
	 */
	public static void main(String[] args) {
		BitSet bitSet = new BitSet(8);
		bitSet.set(4, true);
		bitSet.set(7, true);
		bitSet.set(2, true);
		bitSet.set(5, true);
		int size = bitSet.size();
		System.out.println("size:" + size);
		for (int i = 0; i < size; i++) {
			boolean b = bitSet.get(i);
			if (b) {
				System.out.println(i);
			}
		}
	}
}