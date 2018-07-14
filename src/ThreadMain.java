/**
 * Created by xiangwuzhu on 18/7/14.
 */
public class ThreadMain {

    public static void main(String[] args) {
        Buffer buffer = new Buffer();
        Productor p = new Productor("生产者", buffer);
        Consumer c = new Consumer("生产者", buffer);
        p.start();
        c.start();
    }
}
