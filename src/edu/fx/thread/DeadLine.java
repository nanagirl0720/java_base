package edu.fx.thread;

/**
 * @author: Pxn
 * @date: 2019/12/23 18:49
 */
public class DeadLine extends Thread {

    @Override
    public void run() {
        System.out.println("DeadLine死锁了");
    }

    public static void main(String[] args) {
        StringBuffer s1=new StringBuffer();
        StringBuffer s2=new StringBuffer();
        s1.append("a");
        s2.append("1");

        new Thread(){
            @Override
            public void run() {
                synchronized(s1){
                    s1.append("b");
                    s2.append("2");
                    try {
                        Thread.sleep(100);  //让死锁的概率变大
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(s1);
                    System.out.println(s2);
                }
            }
        }.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized(s2){
                    s1.append("c");
                    s2.append("3");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(s1);
                    System.out.println(s2);
                }
            }
        }).start();
    }

}
