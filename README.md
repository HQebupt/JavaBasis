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

## 演示JVM中堆、栈、方法区导致的内存溢出程序实例
[**1堆实例**](https://github.com/HQebupt/JavaBasis/blob/master/src/jvm/HeapOOM.java)

 创建对象过多，导致OOM。首先设置VM参数：初始堆大小与最大堆大小都是20M，年轻代大小10M。然后，我们来看程序：程序中两个类HeapOOM、OOMObject；通过HeapOOM的main方法，在while死循环中，不断创建OOMObject对象，添加到数组队列list中。接下来，我们看一下运行效果：内存溢出错误，heap空间的问题。最后，我们来分析一下：由于对象实例是在堆中分配的，while循环不断生成新的对象，占用的堆空间越来越大，超过了最大堆20M的大小，最终导致OutOfMemoryError（内存溢出错误）。

[**2栈实例**](https://github.com/HQebupt/JavaBasis/blob/master/src/jvm/JavaVMStackSOF.java)

 大量的本地变量，导致栈溢出错误。首先设置VM参数：线程栈大小128k。然后，我们看一下程序：一个类JavaVMStackSOF，一个成员变量stacklength，一个方法stackLeak（），里面自己递归调用自己，一个main()方法，main方法中创建一个对象，然后对象引用变量som调用stackLeak方法，抛出异常。接下来，看一下运行效果：StackOverflowError（栈溢出错误）。最后，我们来分析一下：main方法中创建的对象实例调用了stackLeak方法，而这个方法是自我递归调用的，会在栈中产生大量的stackLength本地变量，占用栈内存越来越大，超过了设置的128k大小，出现栈内存溢出错误。

[**3栈实例**](https://github.com/HQebupt/JavaBasis/blob/master/src/jvm/JavaVMStackOOM.java)

 创建的线程过多，导致内存溢出。首先设置线程栈大小2M。然后，我们分析一下程序：一个类，3个方法，第2个方法在while循环中不断的创建线程，由于每一个线程启动后，调用dontStop方法，一直运行。Main方法中创建了一个对象实例，然后调用了第2个方法，导致不断创建线程。由于线程是在栈中分配的，这导致了程序占用的栈空间越来越大，最后超过了栈内存的限制，出现内存溢出错误。（这个程序演示会引起OS假死，就不演示了：假死是因为java的线程是映射到OS的内核线程的）

[**4方法区实例**](https://github.com/HQebupt/JavaBasis/blob/master/src/jvm/RuntimeConstantPoolOOM.java)

 常量池过多常量。首先设置初始方法区PermSize、最大方法区大小MaxPermSize都是10m。然后我们看一下程序，main方法中在常量池中添加内容，采用String.intern()可以将String对象包含的字符串添加到常量池中，在while循环中不断向常量池中添加内容，占用方法区空间越来越大，最后超过了10M，发生内存溢出错误。（ps：使用List保持着常量池引用，在integer范围内足够产生OOM了。）


## 反射机制
含义：运行时加载、使用编译期间完全未知的类class。

Java程序可以加载一个运行时才得知名称的class，获悉其完整构造，并生成其对象实体、或对其fields设值、或唤起其methods

> 注意：反射的代码太丑了，不推荐使用。
> 只在JDBC的时候使用，别的地方别用。


## 类加载

**- 什么是类加载机制？**

虚拟机把描述类的数据从class文件加载到内存，连接并初始化，最终形成可以被虚拟机直接使用的java类型。

**- 什么是双亲委派模型，它的工作过程是怎么样的**

<<深入理解java虚拟机>>P192.

目的：为了保证 Java 核心库的类型安全。对于任意一个类，都需要由加载它的类加载器和这个类本身一同确立其在JVM中的唯一性。
