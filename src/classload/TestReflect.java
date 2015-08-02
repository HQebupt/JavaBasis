package classload;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Hashtable;

public class TestReflect {
	public double d;
	public int i;

	public TestReflect() {
	}

	public TestReflect(double d, int i) {
		this.d = d;
		this.i = i;
	}

	public String func(String s, Hashtable ht) {
		System.out.println("func invoked");
		return s;
	}

	public static void main(String[] args) throws ClassNotFoundException,
			InstantiationException, IllegalAccessException,
			NoSuchMethodException, SecurityException, IllegalArgumentException,
			InvocationTargetException, NoSuchFieldException {

		// 动态生成“Class object 所对应之class”的对象实体；无自变量。
		Class c1 = Class.forName("classload.TestReflect");
		Object obj1 = null;
		obj1 = c1.newInstance(); // 不带自变量
		System.out.println("反射生成的对象：" + obj1);

		// 动态生成“Class object 对应之class”的对象实体；自变量以Object[]表示。
		Class c2 = Class.forName("classload.TestReflect");
		Class[] pTypes = new Class[] { double.class, int.class };
		Constructor ctor = c2.getConstructor(pTypes);
		Object obj2 = null;
		Object[] arg = new Object[] { Double.valueOf("3.14159"),
				Integer.valueOf(125) };
		obj2 = ctor.newInstance(arg);
		System.out.println(obj2);

		// 动态唤起method
		Class c3 = Class.forName("classload.TestReflect");
		Class ptypes[] = new Class[2];
		ptypes[0] = Class.forName("java.lang.String");
		ptypes[1] = Class.forName("java.util.Hashtable");
		Method m = c3.getMethod("func", ptypes);
		TestReflect obj = new TestReflect();
		Object[] arg3 = new Object[2];
		arg3[0] = new String("Hello,world");
		arg3[1] = null;
		Object r = m.invoke(obj, arg3);
		System.out.println(r);

		// 动态变更field 内容
		Class c4 = Class.forName("classload.TestReflect");
		Field f = c4.getField("d"); // 指定field 名称
		System.out.println("d= " + (Double) f.get(obj));
		f.setDouble(obj, 12.34);
		System.out.println("d= " + obj.d);
	}

}
