package classload;

/**
 * Created by LiMingji on 2015/3/20.
 */
public class A {
	public int a = 10;

	static {
		// System.out.println("父类静态域初始化.");
	}

	public A() {
		System.out.println("父类构造函数启动");
		// System.out.println(a);
		this.print();
	}

	public void printf() {
		System.out.println(a + ": " + this);
		print();
	}

	void print() {
		System.out.println(a);
		System.out.println(this);
	}

	public static class C extends A {
		public int c = 30;
		public int a = 10;

		static {
			System.out.println("子类静态域初始化");
		}

		C() {
			System.out.println("子类构造函数启动");
			print();
		}

		// @Override
		void print() {
			System.out.println(c);
			System.out.println(this);
		}

		public void what() {
			super.print();
		}
	}

	public static void main(String[] args) {
		C c = new C();
		c.what();
	}
}
