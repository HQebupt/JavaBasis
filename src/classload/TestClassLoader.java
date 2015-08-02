package classload;

import java.io.IOException;
import java.io.InputStream;

public class TestClassLoader {
	public static void main(String[] args) throws Exception {
		ClassLoader myLoader = new ClassLoader() {
			// 重写loadClass方法，打破双亲委派模型。查看ClassLoader的loadClass的方法。
			public Class loadClass(String name) throws ClassNotFoundException {
				try {
					String filename = name.substring(name.lastIndexOf(".") + 1)
							+ ".class";
					System.out.println("filename: " + filename);

					InputStream is = getClass().getResourceAsStream(filename);
					if (is == null) {
						return super.loadClass(name);
					}
					byte[] b = new byte[is.available()];
					System.out.println("size:" + b.length);

					is.read(b);
					return defineClass(name, b, 0, b.length);
				} catch (IOException e) {
					throw new ClassNotFoundException(name);
				}
			}
		};

		// 三种类加载器
		ClassLoader loader = myLoader.getClass().getClassLoader();
		while (loader != null) {
			System.out.println("loader:" + loader.toString());
			loader = loader.getParent();
		}

		// 不同类加载器加载的同一个类并不相同
		Object obj = myLoader.loadClass("classload.TestClassLoader")
				.newInstance();
		System.out.println("obj:" + obj.getClass());
		System.out.println("obj is TestClassLoader instance: " + (obj instanceof TestClassLoader));

		TestClassLoader CLT = new TestClassLoader();
		System.out.println(obj.getClass().getClassLoader());
		System.out.println(CLT.getClass().getClassLoader());

	}
}
