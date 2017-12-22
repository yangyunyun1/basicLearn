import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 *
 *
 * ScheduledExecutorService是从Java SE5的java.util.concurrent里，做为并发工具类被引进的，这是最理想的定时任务实现方式。
 * 相比于上两个方法，它有以下好处：
 * 1>相比于Timer的单线程，它是通过线程池的方式来执行任务的
 * 2>可以很灵活的去设定第一次执行任务delay时间
 * 3>提供了良好的约定，以便设定执行的时间间隔
 *
 * 下面是实现代码，我们通过ScheduledExecutorService#scheduleAtFixedRate展示这个例子，通过代码里参数的控制，首次执行加了delay时间。
 *
 *
 * @author yangyunyun
 *
 */
public class Timer3 {
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
        Runnable runnable1 = new Runnable() {
            public void run() {
                while(true){
                    System.out.println("--------------------");
                    try {
                        Thread.sleep(internal);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        };

        //ScheduledExecutorService scheduledExecutorServices = Executors.newSingleThreadScheduledExecutor();
        ScheduledExecutorService scheduledExecutorServices = Executors.newScheduledThreadPool(2);
        // 第二个参数为首次执行的延时时间，第三个参数为定时执行的间隔时间
        System.out.println(new Date());
        scheduledExecutorServices.scheduleAtFixedRate(runnable, 10,1, TimeUnit.SECONDS);
        scheduledExecutorServices.scheduleAtFixedRate(runnable1, 5, 2, TimeUnit.SECONDS);
    }
}
