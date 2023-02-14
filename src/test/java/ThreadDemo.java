public class ThreadDemo {

    // 线程共有的
    private static Object resource1  = new Object();
    private static Object resource2  = new Object();

    public static void main(String[] args) {
       new Thread(() ->{
            synchronized (resource1) {
                System.out.println(Thread.currentThread() + " running...");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println( Thread.currentThread() + " waitting for resouce2");
                synchronized (resource2) {
                    System.out.println(Thread.currentThread() + "take resouce2 suc");
                }
            }

        },"线程1").start();

        new Thread(()->{
            synchronized (resource2) {
                System.out.println(Thread.currentThread() +  " running...");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread() + " waitting for resouce1");
                synchronized (resource1) {
                    System.out.println(Thread.currentThread() + "take resouce1 suc");
                }
            }
        },"线程2").start();

    }


    public static void run() {

    }




}
