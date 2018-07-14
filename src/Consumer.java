/**
 * Created by xiangwuzhu on 18/7/14.
 */
public class Consumer extends Thread {
    private String name;
    private Buffer buffer;

    public Consumer(String name, Buffer buffer) {
        this.name = name;
        this.buffer = buffer;
    }

    public void run() {
        while (true) {
            int i = buffer.remove();  //消费者从缓冲区里面取出数
            try {
                Thread.sleep(150);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("Consumer remove" + i);

        }
    }
}