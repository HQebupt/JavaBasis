package org.hq.java.lesson8.fanxing;

import java.util.concurrent.Callable;

public class Fanxing<V> {
    public V submit(Callable<V> callable) throws Exception {
        return callable.call();
    }
}
