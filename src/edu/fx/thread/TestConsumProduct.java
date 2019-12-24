package edu.fx.thread;

/**
 * @author: Pxn
 * @date: 2019/12/24 20:10
 */

/**
 * 例子：生产者（Productor）将产品（Product）交给店员（Clerk），消费者（Consumer）从店员这取走产品
 *      店员一次只能持有20个数量的产品，如果试图生产更多产品，店员会让生产者休息一会；店中有空位了再通知生产
 *      如果店中没有产品了，店员会通知消费者停一会，如果有产品了再通知来取
 * 分析：
 *      存在多线程：生产者线程、消费者线程
 *      共享数据：店员或产品（两者可以绑定在一起） ：共用店员或者产品，所以在生产者和消费者中都要声明店员或者产品
 *      线程安全：三种解决方式
 *      线程通信：
 */
class Clerk{
    private int productNum=0;

    /**
     * 同步监视器共用的是CLerk，这一对象。当调用生产时，生产锁住，由于共用一个锁，所以此时消费者不能消费产品
     * 两个线程运行时，首先抢占资源。如果生产者抢到锁，开始生产，有了共有资源产品时，消费者线程抢到锁后，此时消费者消费产品
     * 当生产大于20的时候，调用wait方法，释放锁。然后两线程抢占资源，如果消费者资源先抢到，可以消费资源，如果生产者抢到，依然调用等待方法
     * 消费者同理
     * （线程通信）当消费者消费产品为0是，唤醒生产者线程，赶快让生产；当生产者生产到大于20时，唤醒消费者赶紧消费产品
     */

    //负责生产产品
    public synchronized void productProduct() {  //同步监视器：当前对象Clerk，此时是唯一的，只new了一个
        if (productNum<20){
            productNum++;
            System.out.println(Thread.currentThread().getName()+"开始生产第："+productNum+"个产品");
            notify();//只要生产者生产出了产品，就可以唤醒消费者来消费，同时满足：当productNum等于第20个产品时，通知消费者赶紧消费
        }else {
            try {
                //等待
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //负责消费产品
    public synchronized void consumProduct() {   //同步监视器：当前对象Clerk，此时是唯一的，只new了一个
        if (productNum>0){
            System.out.println(Thread.currentThread().getName()+"开始消费第："+productNum+"个产品");
            productNum--;
            notify();//只要消费了产品，就可以唤醒生产者来生产，同时满足：当productNum等于第0个产品时，通知生产者赶紧生产
        }else {
            try {
                //等待
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class Productor extends Thread{
    private Clerk clerk;
    public Productor(Clerk clerk){
        this.clerk=clerk;
    }
    @Override
    public void run() {
        //生产者负责生产产品
        System.out.println(getName()+"开始生产。。。");
        while (true){
            try {
                sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.productProduct();//店员或产品（两者可以绑定在一起），相当于让产品调用生产产品
        }
    }
}
class Consumer extends Thread{
        private Clerk clerk;
        public Consumer(Clerk clerk){
            this.clerk=clerk;
        }

    @Override
    public void run() {
        //消费者负责消费产品
        System.out.println(getName()+"开始消费。。。");
        while (true){
            try {
                sleep(15);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.consumProduct();//店员或产品（两者可以绑定在一起），相当于让产品调用消费产品
        }
    }
}

public class TestConsumProduct {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Productor p1 = new Productor(clerk);
        Consumer c1 = new Consumer(clerk);
        p1.setName("生产者");
        c1.setName("消费者");
        p1.start();
        c1.start();
    }
}
