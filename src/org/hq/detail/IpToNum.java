package org.hq.detail;

public class IpToNum {
	/**
	 * IP地址的值转换为数字，必须用long来存储，int储存不下。
	 * 因为 java中只有 int型 而没有 unsign integer 和 signed之分。
	 */
	// D.C.B.A的int值 = A + B*2^8 + C*2^16 + D*2^24
	// 2^8 = 1 << 8 
	long d, c, b, a;
	public final static int TICK = 1 << 8;

	public IpToNum(int d, int c, int b, int a) {
		this.d = d;
		this.c = c;
		this.b = b;
		this.a = a;
	}

	long ofValue() {
		long value = a + b * (1 << 8) + c * (1 << 16) + d * (1 << 24);
		return value;
	}

	public static void main(String[] args) {
		
		int d = 255, c = 255, b = 255, a = 255;
		IpToNum sol = new IpToNum(d, c, b, a);
		System.out.println(IpToNum.TICK);
		System.out.println(sol.ofValue());
		System.out.println((1l << 32) - 1);
	}
}
