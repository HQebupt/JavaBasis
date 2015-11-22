package org.hq.java.lesson3;

import java.util.AbstractCollection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @version 1.0
 * @author HuangQiang
 * @date 2013-10-26
 * @update 2015-8-24
 */

public class EBArray extends AbstractCollection<Object> {
	private int[] elementData;
	private int size; // elementData数组已经使用的大小
	private static final int MAX_ARRAY_SIZE = 500;

	public EBArray() {
		this(MAX_ARRAY_SIZE);
	}

	/**
	 * @param initialCapacity
	 */
	public EBArray(int initialCapacity) {
		if (initialCapacity < 0 || initialCapacity > MAX_ARRAY_SIZE)
			throw new IllegalArgumentException(
					"Illegal Capacity(Capacity <0 or more than MAX_ARRAY_SIZE 500): "
							+ initialCapacity);
		this.elementData = new int[initialCapacity];
	}

	/**
	 * @param index
	 * @return 返回index下标的元素
	 */
	public int get(int index) {
		rangeCheck(index);
		return elementData[index];
	}

	/**
	 * @param index
	 */
	private void rangeCheck(int index) {
		if (index >= size)
			throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
	}

	/**
	 * @param index
	 * @return error message
	 */
	private String outOfBoundsMsg(int index) {
		return "Index: " + index + ", Size: " + size;
	}

	/*
	 * 获取当前数组内的元素个数。
	 */
	public int size() {
		return size;
	}

	/**
	 * @param num
	 * @return 是否添加成功
	 */
	public boolean add(int num) {
		if (ensureCapacityEnough(size + 1)) {
			elementData[size++] = num;
			return true;
		} else {
			System.out.println("EBArray's data has reached  maxCapacity : "
					+ elementData.length + ".\n" + "add number: " + num
					+ " failed!\n");
			return false;
		}
	}

	/**
	 * 确保容量够不够用
	 */
	private boolean ensureCapacityEnough(int size) {
		if (size <= elementData.length)
			return true;
		else
			return false;

	}

	/**
	 * 移除EBArray中第一个值为num的元素
	 * 
	 * @param num
	 * @return
	 */
	public boolean remove(int num) {
		for (int index = 0; index < size; index++)
			if (elementData[index] == num) {
				fastRemove(index);
				return true;
			}
		return false;
	}

	/**
	 * 移除EBArray中所有值为num的元素
	 * 
	 * @param num
	 * @return
	 */
	public boolean removeAll(int num) {
		int sizebefore = size;
		for (int index = 0; index < size; index++)
			if (elementData[index] == num) {
				fastRemove(index);
			}
		if (sizebefore > size)
			return true;
		else
			return false;
	}

	/**
	 * @param index
	 */
	private void fastRemove(int index) {
		int numMoved = size - index - 1;
		if (numMoved > 0)
			System.arraycopy(elementData, index + 1, elementData, index,
					numMoved);
		size--; // 隐患：没有清除掉数组边界的值。改进方法：全部使用Object[] elementData,
				// 用到elementData的方法要强制转换为Integer。
	}

	/**
	 * @param num
	 * @return
	 */
	public boolean contains(int num) {
		return indexOf(num) >= 0;
	}

	/**
	 * @param num
	 * @return 返回找到元素的下标
	 */
	public int indexOf(int num) {
		for (int i = 0; i < size; i++)
			if (elementData[i] == num)
				return i;
		return -1;
	}

	/**
	 * 打印数组
	 */
	public static void print(EBArray ebarray) {
		int ebsize = ebarray.size();
		System.out.println("当前数组的容量是: " + ebsize + ".\n" + "数组元素如下：");
		if (ebsize == 0) {
			System.out.println("null.");
			return;
		}
		Iterator<Integer> it = ebarray.iterator();
		int count = 0;
		boolean count20 = false;
		while (it.hasNext()) {
			System.out.print(it.next() + " ; ");
			count++;
			if (count % 20 == 0) {
				count20 = true;
				System.out.println();
				count20 = false;
			}
		}
		System.out.println();
	}

	@Override
	public Iterator iterator() {
		return new Itr();
	}

	/**
	 * Iterator的实现
	 */
	private class Itr implements Iterator<Integer> {
		int cursor = 0; // index of next element to return
		int lastRet = -1; // index of last element returned; -1 if no such

		public boolean hasNext() {
			return cursor != EBArray.this.size();
		}

		public Integer next() {
			try {
				int i = cursor;
				int next = EBArray.this.get(i);
				lastRet = i;
				cursor = i + 1;
				return Integer.valueOf(next);
			} catch (IndexOutOfBoundsException e) {
				throw new NoSuchElementException();
			}
		}

		/**
		 * 移除当前的元素
		 */
		public void remove() {
			if (lastRet < 0)
				throw new IllegalStateException();
			try {
				EBArray.this.fastRemove(lastRet);
				cursor = lastRet;
				lastRet = -1;
			} catch (IndexOutOfBoundsException ex) {
				throw new ConcurrentModificationException();
			}
		}
	}

	public static void testIteratorRemove(EBArray ebarray) {
		Iterator it = ebarray.iterator();
		while (it.hasNext()) {
			it.next();
			it.remove();
		}
	}
}
