package classload;

/**
 * User: roger36 Date: 2015/3/20 Time: 10:39
 */
public class B extends A {

	public int b = 20;
	// public int a = 10;
	{
		System.out.println("b�е���ͨ��");
	}

	static {
		// System.out.println("���ྲ̬���ʼ��");
	}

	B() {
		// System.out.println("���๹�캯������");
		print();
	}

	void print() {
		System.out.println(b);
		// System.out.println(this);
	}

	public void what() {
		this.printf();
		super.printf();// �᲻����ô������ĺ���
	}

	@Override
	public void printf() {
		System.out.println("���������printf������������˼����ô���");
	}

	public static void main(String[] args) {
		B b = new B();
		// b.what();
	}

}
