import org.hq.java.lesson6.daemon.ZengJingSong;

public class Zhangtao {
    public static void main(String[] args) throws Exception {
        Thread zjs = new ZengJingSong();
        zjs.setDaemon(true);// 守护线程有什么作用：做辅助，比如日志、心跳。
        zjs.start();

        System.out.println("zt: i am out");
        Thread.currentThread().sleep(5000);

        System.out.println("zt: i am back");
        zjs.interrupt();

        Thread.currentThread().sleep(5000);
        System.out.println("守护线程的原因：使得主线程挂了之后，zjs的线程也结束了.");
    }

}
