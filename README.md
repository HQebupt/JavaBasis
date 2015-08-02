# JavaBasis
Java programming basis training. 


## [Long 包装类型](https://github.com/HQebupt/JavaBasis/blob/master/src/org/hq/detail/LongTrap.java)
<Effective Java> 对于包装类型的建议： 包装类型遇到基本类型，一定会自动拆箱。若为 `null`，拆箱出来就是`NullPointerException`.

Long类型在进行`==`比较，调用此方法`Long.valueOf()`进行比较，[举例参考](https://github.com/HQebupt/JavaBasis/blob/master/src/org/hq/detail/LongTrap.java)。
Long的类型缓存了**[-128, 127]**内的值。
```
public static Long valueOf(long l) {
	final int offset = 128;
	if (l >= -128 && l <= 127) { // will cache
	    return LongCache.cache[(int)l + offset];
	}
        return new Long(l);
    }
```

[More Example and Explain](http://blog.csdn.net/is_zhoufeng/article/details/38443507)


## [长度非0的数组总是可变的](https://github.com/HQebupt/JavaBasis/blob/master/src/org/hq/detail/PrivateValues.java)
<Effective Java> R43条的教训：返回零长度的数组或者集合，而不是null。
**说明：** 数组在大小非0的时候，是可变的。用`static final`修饰也没有用。在项目编程的时候要注意。

如果遇到一定要返回非0的数组，有2个方法：
- 集合返回的方式：`Collections.unmodifiableCollection(Arrays.asList(PRIVATE_VALUES));`
- 拷贝clone的方式：`PRIVATE_VALUES.clone();`


## [字符串比较==](https://github.com/HQebupt/JavaBasis/blob/master/src/StringConnectJVM.java)
考察Java内存模型，对字符串的处理。
> Java对字符串的优化，使得字符串的`==`比较操作具有不确定性，使用字符串的比较请用`equals()`方法，不必纠结这个示例的细节结果。


## [Effective Java](https://github.com/HQebupt/JavaBasis/tree/master/src/effective/java)
这是看《Effective Java》时，练习的示例，参考价值低。


## [单例模式的4种实现](https://github.com/HQebupt/JavaBasis/blob/master/src/org/hq/singleton/Elvis.java)
用私有构造器或者枚举类型强化Singleton属性。 单元素枚举类型方法是最佳的方法，可以应对序列化和反射等问题。
* 1.public静态成员是个final域，构造函数都是`private`
* 2.静态工厂方法
* 3.包含单个元素的枚举类型。**最佳方法**
* 4.静态工厂方法 --延迟初始化: 使用内部类达到目的

> 如果一个类实现了`Serialize`序列化接口，这个类的单例模式被破坏。修正的方法只有一个，反序列化的时候，添加`readResolve`方法。具体见<Effective Java> Rule77.

## [子类父类初始化以及调用问题](https://github.com/HQebupt/JavaBasis/tree/master/src/classload)
Java细节编程的奇淫技巧，价值低，有兴趣就看看。

类的初始化顺序：先父类，后子类，先字段，后方法。

## 

