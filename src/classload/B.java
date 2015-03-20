package classload;

/**
 * User: roger36 Date: 2015/3/20 Time: 10:39
 */
public class B extends A {

	public int b = 20;
	// public int a = 10;
	{
		System.out.println("b中的普通块");
	}

	static {
		// System.out.println("子类静态域初始化");
	}

	B() {
		// System.out.println("子类构造函数启动");
		print();
	}

	void print() {
		System.out.println(b);
		// System.out.println(this);
	}

	public void what() {
		this.printf();
		super.printf();// 会不会调用错成子类的函数
	}

	@Override
	public void printf() {
		System.out.println("我是子类的printf函数，不好意思你调用错了");
	}

	public static void main(String[] args) {
		B b = new B();
		// b.what();
	}

}
