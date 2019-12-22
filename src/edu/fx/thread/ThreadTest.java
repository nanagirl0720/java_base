package edu.fx.thread;

/**
 * @author: Pxn
 * @date: 2019/12/22 10:16
 */
public class ThreadTest extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i % 2 == 0){
                System.out.println(Thread.currentThread().getName()+": "+i);
            }
        }
    }

    public static void main(String[] args) {
        ThreadTest thread = new ThreadTest();
        thread.start();
        System.out.println(Thread.currentThread().getName());
        //匿名内部类
        new DemoThread(){
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    if(i % 2 == 1){
                        System.out.println(Thread.currentThread().getName()+": "+i);
                    }
                }
            }
        }.start();
        //匿名内部类
        new DemoThread1(){
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    if(i % 2 == 0){
                        System.out.println(Thread.currentThread().getName()+": "+i);
                    }
                }
            }
        }.start();
    }

}
class DemoThread1 extends Thread{

}
class DemoThread extends Thread{

}
