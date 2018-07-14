/**
 * Created by xiangwuzhu on 18/7/14.
 */
public class Productor extends Thread {
    private String name;
    private Buffer buffer;

    public Productor(String name, Buffer buffer) {
        this.name = name;
        this.buffer = buffer;
    }

    public void run() {
        int i = 0;
        while (true && i<50) {

            buffer.add(i++);   //生产者线程往缓冲区里面添加数
            try {
                Thread.sleep(50);
            } catch (Exception e) {
                e.printStackTrace();   //打印栈跟踪信息
            }

            System.out.println("Productor add:" + i );
        }
    }
}
