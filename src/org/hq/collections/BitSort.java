package org.hq.collections;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import java.util.Random;

/**
 * 利用BitSet对自然数数据进行排序
 * User: huangqiang
 * Date: 15/11/22
 * Time: 下午8:35
 */
public class BitSort {
    private static final Random random = new Random();
    private static int COUNT = 1000;

    public static void main(String[] args) {
        BitSet bs = new BitSet(COUNT);
        for (int i = 0; i < COUNT / 10; i++) {
            int num = random.nextInt(COUNT);
            bs.set(num);
        }

        // 顺序输出排好序的数
        List<Integer> sortData = new ArrayList<Integer>(bs.cardinality());
        for (int i = bs.nextSetBit(0); i >=0; i = bs.nextSetBit(i + 1)) {
            sortData.add(i);
        }
        System.out.println("排好序的数组大小:" + sortData.size());
        System.out.println("排好序的数组:" + sortData);
    }

}
