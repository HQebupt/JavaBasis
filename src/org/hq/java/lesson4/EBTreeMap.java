package org.hq.java.lesson4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

/**
 * 第三组第4次作业
 * 实现了Map接口的EBTreeMap
 * @author liuhuadong
 *
 */
public class EBTreeMap<K, V> implements Map<K, V> {
	//Collections.emptyList()产生的list不能使用add();
	private List<Entry<K,V> > data = Collections.emptyList();
	
	private Comparator<? super K> comparator = null;
	
	/**
	 * 默认构造函数
	 */
	public EBTreeMap(){}
	/**
	 * 构造函数
	 */
	public EBTreeMap( Map<? extends K, ? extends V> m) {
		putAll(m);
	}
	 
	@Override
	/**
	 * 返回map的大小
	 */
	public int size() {
		return data.size();
	}

	@Override
	public boolean isEmpty() {
		return data.isEmpty();
	}

	@Override
	/**
	 * 使用二分法查找指定的key,成功返回true,否则返回false
	 */
	public boolean containsKey(Object key) {
		return getEntry(key) !=null;
	}
	
	 /**
	  * 根据key用二分查找entry
	  * @param key
	  * @return
	  */
	@SuppressWarnings("unchecked")
	final Entry<K,V> getEntry(Object key) {
		//使用二分查找
		int cmp = Arrays.binarySearch(data.toArray(), new Entry<K, V>((K) key));
		return cmp < 0 ? null : data.get(cmp);
	}
	
	/**
	 * 比较value的大小
	 * @param o1
	 * @param o2
	 * @return
	 */
	 static final boolean valEquals(Object o1, Object o2) {
	    return (o1 ==null ? o2 == null : o1.equals(o2));
	 }
	 
	@Override
	/**
	 * 是否包含value,包含返回true,否则返回false
	 */
	public boolean containsValue(Object value) {
		for(Entry<K, V> e : data){
			if(valEquals(e.getValue() , value)){
				return true;
			}
		}
		return false;
	}
	
	
	@Override
	/**
	 * 根据key，若存在返回value，否则返回null
	 */
	public V get(Object key) {
		Entry<K, V> entry  = getEntry(key);
		return entry ==null ? null :entry.getValue();
	}

	@Override
	/**
	 * 使用选择插入，添加元素。若已存在key，这返回旧value
	 */
	public V put(K key, V value) {
		Entry<K, V> entry = new Entry<K, V>(key, value);
		if(data.isEmpty())
		{
			data = new ArrayList();
		}
		return insert(data, entry);
	}
	
	/**
	 * 在list中选择插入
	 * @param list
	 * @param k
	 */
	public final V insert(List<Entry<K, V>> list, Entry<K, V> e){
		V oldValue = null;
		if(list.isEmpty()){			
			list.add(e);
			return oldValue;
		}
		ListIterator<Entry<K, V>> it = list.listIterator();
		Entry<K, V> entryTemp = null;
		while(it.hasNext()){
			entryTemp =  it.next();
			
			int cmp = e.compareTo(entryTemp);
			if(cmp == 0){
				oldValue = entryTemp.setValue(e.getValue());
				return oldValue;
			}
			if(cmp < 0){
				list.add(it.previousIndex() == -1? 0 : it.previousIndex(), e);
				return  oldValue;
			}
		}
		if(!it.hasNext()){
			list.add(e);
		}
		return oldValue;
	}
	@SuppressWarnings("unchecked")
	@Override
	/**
	 * 移除指定key的元素
	 */
	public V remove(Object key) {
		V oldValue = null;
		//查找entry
		int cmp = Arrays.binarySearch(data.toArray(), new Entry<K, V>((K) key));
		if(cmp != -1){
			oldValue = data.get(cmp).getValue();
			data.remove(cmp);
		}
		return oldValue;
	}

	@SuppressWarnings("unchecked")
	@Override
	/**
	 * 用Map添加元素
	 */
	public void putAll(Map<? extends K, ? extends V> m) {
		if(m == null || m.isEmpty())
			return;
		if(data.isEmpty()){
			data = new ArrayList();	
		}
		
		Iterator<?> mi = m.entrySet().iterator();
		while(mi.hasNext()){
			Map.Entry<? extends K, ? extends V> temp = (Map.Entry<? extends K, ? extends V>) mi.next();
			Entry<K, V> entry = new Entry<K,V>(temp.getKey(), temp.getValue());
			// 用选择插入
			insert(data, entry);
			//data.add(entry);
		}
		//排序，保证data顺序
		//Collections.sort(data);
	}

	@Override
	/**
	 * 清除元素
	 */
	public void clear() {
		data = Collections.emptyList();
	}

	@Override
	/**
	 * 返回所有key的集合
	 */
	public Set<K> keySet() {
		Set<K> keys = new HashSet();
		Iterator<Entry<K, V>> it = data.iterator();
		while(it.hasNext()){
			keys.add(it.next().getKey());
		}
		return keys;
	}

	@Override
	/**
	 * 返回所有value
	 */
	public Collection<V> values() {
		Set<V> values = new HashSet();
		Iterator<Entry<K, V>> it = data.iterator();
		while(it.hasNext()){
			values.add(it.next().getValue());
		}
		return values;
	}

	@Override
	/**
	 * 获取entrySet
	 */
	public Set<Map.Entry<K, V>> entrySet() {
		Set<Map.Entry<K, V>> entrySet = new HashSet();
		Iterator<Entry<K, V>> it = data.iterator();
		while(it.hasNext()){
			entrySet.add((Map.Entry<K, V>) it.next());
		}
		return entrySet;
	}

     /**
      * 实现了Map.Entry，重载了toString()
      * @author liuhuadong
      *
      * @param <K>
      * @param <V>
      */
	 static final class Entry<K,V> implements Map.Entry<K, V> ,Comparable<Entry<K,V> >{
        K key;
        V value;
        
        Entry(K k, V v){
        	key = k;
        	value = v;
        }
        Entry(K k){
        	key = k;
        	value = null;
        }
		@Override
		public K getKey() {
			return key;
		}

		@Override
		public V getValue() {
			
			return value;
		}
		
		
		@Override
		public V setValue(V value) {
            V oldValue = this.value;
            this.value = value;
			return oldValue;
		}

		@SuppressWarnings("unchecked")
		@Override
		public int compareTo(Entry<K, V> o) {
			int cmp = ((Comparable<? super K>) key).compareTo(o.key);
			return cmp;
		}
		
		public String toString(){
			StringBuilder sb = new StringBuilder();
			sb.append("<");
			sb.append(key.toString());
			sb.append(",");
			sb.append(value.toString());
			sb.append(">");
			return sb.toString();
		}
	}
	 
	 /**
	  * 实现entry的value的比较器
	  * @author liuhuadong
	  *
	  */
	 public class EntryValueComparator implements Comparator<Entry<K, V>>{

		@SuppressWarnings("unchecked")
		@Override
		public int compare(Entry<K, V> o1, Entry<K, V> o2) {
	        Comparable<? super V> v1 = (Comparable<? super V>) o1.value;
	        V v2 = o2.value;
	        int cmp = v1.compareTo(v2);
			return cmp;
		}
		 
	 }
	 /**
	  * 重载了toString()
	  */
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		Iterator<?> it = data.iterator();
		while(it.hasNext()){
			sb.append(it.next().toString());
			if(it.hasNext()){
				sb.append(",");
			}
		}
		sb.append("]");
		return sb.toString();
	}

}
