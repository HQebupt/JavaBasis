## 比较器和可比较的用法
 1. 比较器`Compartor`: 针对Object本身不具有可比较的属性,可以为它添加排序的特性,方便排序. `int compare(T o1, T o2);`
 2. 可比较的`Comparable`: 让对象本身具有排序的特性. `int compareTo(T o)`