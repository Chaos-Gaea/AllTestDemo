package lyp.com.text.ThreadPool;


import android.support.annotation.NonNull;


import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;


public class ThreadPoolTest {
    public static void main(String args[]){



        /*int corePoolSize,  核心线程池大小
        int maximumPoolSize,  最大线程池大小
        long keepAliveTime,   线程存活时间
        TimeUnit unit,        时间单位
        BlockingQueue<Runnable> workQueue,   工作队列
        ThreadFactory  threadFactory   线程工厂
        ThreadPoolExecutor(int, int, long, TimeUnit, BlockingQueue<Runnable>, ThreadFactory)
        */

        //单端队列
        //BlockingQueue//
        //BlockingDeque    双端队列
        //增删比较频繁 所以用链表结构的LinkedblockQueue
        /*public StringBuffer(String str) {
        super(str.length() + 16);
        append(str);
    }*/
        //new StringBuffer(100);  // 超过动态分配
        //100是该容器的最大上限 runnale泛型参数




        LinkedBlockingQueue<Runnable> blockingQueue = new LinkedBlockingQueue<>(100);

        ThreadFactory threadFactory = new ThreadFactory() {
            //int i = 0;

            //thread.setName("MyThread"+ i++); i++ 不是线程安全的
            //synchronized  关键字 每次执行一个线程 影响性能
            //使用包装类   原子性的int线程安全的包装类
            AtomicInteger atomicInteger = new AtomicInteger(0);
            @Override
            public Thread newThread(@NonNull Runnable r) {

                //创建线程 把r赋值线程
                Thread thread = new Thread(r);
                //线程Id
                //getAndIncrement() == i++   incrementAndGet()== ++i
                thread.setName("MyThread=" + atomicInteger.getAndIncrement());

                return thread;
            }
        };

        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(5, 10, 5, TimeUnit.SECONDS,
                blockingQueue,threadFactory );

        for (int i = 0;i<100;i++){
            poolExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    method();
                }
            });
        }


    }

    private static void method() {
        System.out.println("ThreadName"+Thread.currentThread().getName()+ "过来了");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("ThreadName"+Thread.currentThread().getName()+ "出去了");
    }
}
