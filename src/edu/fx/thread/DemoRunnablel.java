package edu.fx.thread;

/**
 * @author: Pxn
 * @date: 2019/12/22 12:58
 */
class MyRunnable implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i%2==0) {
                System.out.println(Thread.currentThread().getName()+" : "+i);
            }
        }
    }
}
public class DemoRunnablel {


    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        thread.setName("线程");
        thread.start();//start()作用1：启动当前线程 作用2：调用当前线程的run方法
        //分析
        //第一步：new Thread(myRunnable),初始化线程
        //第二步：调用当前线程，即thread线程，进入Thread的run方法
        /**
         @Override  [target的类型是（Runnable）  private Runnable target]
         public void run() {
         if (target != null) {
         target.run();
         }
         }
         */

        //总结：相当于new Thread(myRunnable)中myRunnable对象作为行参给target赋值，（target的类型是Runnable）
        //      当我们调用Thread的start方法的时候，由于target已经被赋过值了，就开始调用target中的run方法。
        //      target的run方法就是刚刚构造时造的对象重写的run方法
    }
}
