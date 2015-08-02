package effective.java;

// R15
public class Complex {
	private final double re;

	private Complex() {
		throw new AssertionError();
	}

	private Complex(double re) {
		this.re = re;
	}

	public static Complex valueOf(double re) {
		return new Complex(re);
	}
}
