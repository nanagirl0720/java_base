package edu.fx.thread;

/**
 * @author: Pxn
 * @date: 2019/12/23 19:26
 */

import java.util.concurrent.locks.ReentrantLock;

/**
 * 线程安全的第三种方式：继承Lock接口，用“”实现接口
 */
class Window implements Runnable{
    static int ticket = 100;
    //实例化锁
    private ReentrantLock reentrantLock=new ReentrantLock();    //默认为false（不公平）
    @Override
    public void run() {
        while (true){
            try{
                //加锁
                reentrantLock.lock();//相当于同步监视器
                if (ticket>0){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+" : "+ ticket);
                    ticket--;
                }else {
                    System.out.println("卖光了！");
                    break;
                }
            }finally {
                //解锁
                reentrantLock.unlock();
            }

        }
    }
}
public class SecurityThreeThread {
    public static void main(String[] args) {
        Window window = new Window();
        Thread t1 = new Thread(window);
        Thread t2 = new Thread(window);
        Thread t3 = new Thread(window);
        t1.setName("1号窗口");
        t2.setName("2号窗口");
        t3.setName("3号窗口");
        t1.start();
        t2.start();
        t3.start();
    }
}
