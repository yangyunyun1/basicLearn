import java.util.Date;

/**
 * 普通thread
 * 这是最常见的，创建一个thread，然后让它在while循环里一直运行着，
 * 通过sleep方法来达到定时任务的效果。这样可以快速简单的实现.
 * @author yangyunyun
 *
 */
public class Timer1 {
    public static void main(String[] args) {
        final long internal = 1000;
        Runnable runnable = new Runnable() {
            public void run() {
                while(true){
                    System.out.println(new Date());
                    try {
                        Thread.sleep(internal);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();
    }
}
