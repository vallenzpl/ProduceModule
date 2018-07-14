/**
 * Created by xiangwuzhu on 18/7/14.
 */
public class Buffer {

    private java.util.List<Integer> list = new java.util.ArrayList<Integer>();
    private int MAX = 20;

    public void add(int n) {
        synchronized (this) {
            System.out.println("-- start add --");

            try {
                while (list.size() >= MAX) {
                    try {
                        System.out.println(" buffer超了，要等等");
                        this.wait();   //当缓冲区中的数超出最大值时，调用wait()方法释放锁的监控权，线程进入等待队列
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
                list.add(n);
                System.out.println("add "+n + " 成功 size: " + list.size());
                this.notify();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    public int remove() {
        synchronized (this) {
            System.out.println("-- remove --");
            try {
                while (list.size() == 0) {
                    try {
                        System.out.println(" buffer＝0，要等等");
                        this.wait();   // //当缓冲区中的数为0时，调用wait()方法释放锁的监控权，线程进入等待队列
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                int i = list.remove(0);

                System.out.println("remove "+i+"成功 list size()="+list.size());

                this.notify();
                return i;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return -1;
        }
    }
}
