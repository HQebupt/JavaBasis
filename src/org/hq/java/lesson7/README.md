## 同步`synchronized`的用法:`sync`

* 方法上: `this`引用
* 代码块: 指定对象
* 类


## 实现线程池:`pool`
1个阻塞队列`BlockingQueue<Runnable>`存放需要执行的Task, 1个`ArrayList<Thread>`存放线程池的资源. \
线程池中的线程是死循环运行的,保证线程一直处于可运行的状态,具体见代码.


## 生产者消费者:`producerConsumer`
* 方法1:使用`BlockingQueue`
* 方法2:使用`Lock`

