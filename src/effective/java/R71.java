package effective.java;

public class R71 {
	// 静态类的延迟初始化，这个方法不影响性能。
	private static class FieldHolder {
		static final  Boolean field = computeFiledValue();

		private static Boolean computeFiledValue() {
			return Boolean.valueOf("true");
		}
	}
	
	static Boolean getField() {
		return FieldHolder.field;
	}
	
	public static void main(String[] args) {

	}

}
