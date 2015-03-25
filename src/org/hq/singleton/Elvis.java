package org.hq.singleton;

/**
 * @author HuangQiang
 * @date 2015-3-25
 * 
 *       单例模式的3种写法 用私有构造器或者枚举类型强化Singleton属性。
 *       单元素枚举类型方法是最佳的方法，可以应对序列化和反射等问题。
 */
public class Elvis {

	// 1.public静态成员是个final域
	static class Singleton1 {
		public static final Singleton1 INSTANCE = new Singleton1();

		private Singleton1() {
		}
	}

	// 2.静态工厂方法
	static class Singleton2 {
		private static final Singleton2 INSTANCE = new Singleton2();;

		private Singleton2() {
		}

		public static Singleton2 getInstance() {
			return INSTANCE;
		}
	}

	// 3.包含单个元素的枚举类型。最佳方法
	public static enum Singleton3 {
		INSTANCE;
		public void leaveTheBuilding() {
			System.out.println("so great.");
		}
	}

	public static void main(String[] args) {
		Elvis.Singleton3 a = Elvis.Singleton3.INSTANCE;
		Elvis.Singleton3 b = Elvis.Singleton3.INSTANCE;
		a.leaveTheBuilding();
		b.leaveTheBuilding();
	}
}
