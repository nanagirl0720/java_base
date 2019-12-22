package edu.fx.thread;

/**
 * @author: Pxn
 * @date: 2019/12/22 18:32
 */
class SellTicketWindow implements Runnable{
    static int ticket=100;
    @Override
    public void run() {
        while (true){
            synchronized(this){
                if(ticket>0){
                    try {
                        Thread.sleep(200);
                        System.out.println(Thread.currentThread().getName()+" 票号是: "+ticket);
                        ticket--;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else {
                    System.out.println("Sorry,There is no ticket!");
                    break;
                }
            }
        }
    }
}
public class TicketRunnable {
    public static void main(String[] args) {
        SellTicketWindow sellMan = new SellTicketWindow();
        Thread sellOneThread = new Thread(sellMan);
        Thread sellTwoThread = new Thread(sellMan);
        Thread sellThreeThread = new Thread(sellMan);
        sellOneThread.setName("OneWindow");
        sellTwoThread.setName("TwoWindow");
        sellThreeThread.setName("ThreeWindow");
        sellOneThread.start();
        sellTwoThread.start();
        sellThreeThread.start();
    }
}
