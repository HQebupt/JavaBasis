package org.hq.java.lesson3;

import java.util.Random;

/**
 * 
 * @author HuangQiang
 * @date 2013-10-27
 */
public class Main {
	private static final int NUMMAX = 100;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		welcome();
		test();
	}

	public static void welcome() {
		System.out.println("Welcome to Homework 3 from Group 3!\n"
				+ "Our members are 王岩 单劼 黄强 刘化东 张宇飞.\n");
		System.out.println("下面是EBArray类的方法演示：\n" + "1.EBArray类创建。\n"
				+ "2.EBArray方法的三个方法：add、remove、contains。\n"
				+ "3.Iterator三个方法的使用：hasNext、next、remove。");
	}

	public static void test() {
		Random rand = new Random(System.currentTimeMillis());
		System.out
				.println("\n\n****************************这是一个随机测试用例。****************************");
		System.out.println("新建EBarray实例，初始化最大容量为500；随机添加500个int元素(0~300之间).\n");
		EBArray ebarray = new EBArray();
		for (int i = 1; i <= 500; i++)
			ebarray.add(rand.nextInt(NUMMAX));
		System.out.println("1.测试EBArray add方法,添加超过数组容量的数据，打印报错信息！！");
		ebarray.add(rand.nextInt(NUMMAX));
		EBArray.print(ebarray);

		int numcontain = rand.nextInt(NUMMAX);
		System.out.println("2.测试EBArray contains方法,测试数组中是否有number: "
				+ numcontain + " ?");
		System.out.println("contained ? :" + ebarray.contains(numcontain)
				+ "\n");

		int numremove = rand.nextInt(NUMMAX);
		System.out
				.println("3.测试EBArray remove方法,随机移除一个随机值:" + numremove + " ?");
		System.out.println("remove " + numremove + " successful ? :"
				+ ebarray.remove(numremove));
		EBArray.print(ebarray);

		int numremoveAll = rand.nextInt(NUMMAX);
		System.out.println("\n4.测试EBArray removeAll方法,随机移除一个随机值:"
				+ numremoveAll + "的所有元素 ?");
		System.out.println("removeAll " + numremoveAll + " successful ? :"
				+ ebarray.removeAll(numremoveAll));
		EBArray.print(ebarray);

		System.out.println("\n5.测试Iterator remove方法，移除所有数组元素：");
		EBArray.testIteratorRemove(ebarray);
		EBArray.print(ebarray);

		System.out
				.println("\n\n************************************测试完毕！************************************");
	}
}
