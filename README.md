# JavaBasis
Java programming basis training. 

## Long 包装类型
<Effective Java> 对于包装类型的建议： 包装类型遇到基本类型，一定会自动拆箱。若为 `null`，拆箱出来就是`NullPointerException`.

Long类型在进行`==`比较，调用此方法`Long.valueOf()`进行比较，[举例参考](https://github.com/HQebupt/JavaBasis/blob/a5d42e7714391a328fcca71981ab689e864fcd42/src/org/hq/detail/LongTrap.java)。
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