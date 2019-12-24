package edu.fx.thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: Pxn
 * @date: 2019/12/24 17:04
 */
class Print implements Runnable{
    private int printnum=1;
    @Override
    public void run() {
        while (true){
            synchronized(this){
                notify();   //唤醒一个优先级高的线程
                if (printnum <= 100){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+" : "+printnum);
                    printnum++;
                    try {
                        wait(); //IllegalMonitorStateException:
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else {
                    break;
                }
            }
        }
    }
}
class Print2 implements Runnable{
    private int num=1;
    private ReentrantLock reentrantLock=new ReentrantLock(true);
    @Override
    public void run() {
        while (true){
            try{
                reentrantLock.lock();
                if (num<=100){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+" : "+num);
                    num++;
                }else {
                    break;
                }
            }finally {
                reentrantLock.unlock();
            }
        }

    }
}
public class ThreadCommute {
    public static void main(String[] args) {
        //使用两个线程打印1-100，两线程交替打印
        //test1();//方式一：采用Object类的方法notify方法和wait方法交替线程打印
        System.out.println("============================");
        test2();//方式二：采用安全锁ReentrantLock类的lock和unlock方法，实例化ReentrantLock传入true（线程公平交替打印）


    }

    private static void test2() {
        Print2 print2 = new Print2();
        Thread t3 = new Thread(print2);
        Thread t4 = new Thread(print2);
        t3.setName("线程3");
        t4.setName("线程4");
        t3.start();
        t4.start();
    }

    private static void test1() {
        Print print = new Print();
        Thread t1 = new Thread(print);
        Thread t2 = new Thread(print);
        t1.setName("线程1");
        t2.setName("线程2");
        t1.start();
        t2.start();
    }
}
