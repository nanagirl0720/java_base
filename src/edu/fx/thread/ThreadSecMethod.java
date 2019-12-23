package edu.fx.thread;

/**
 * @author: Pxn
 * @date: 2019/12/22 19:48
 */
class TicketWindows extends Thread{
    static int ticket=100;
    @Override
    public void run() {
            while (true){
            showTicket();
        }
    }

    private static synchronized void showTicket() {
        if (ticket>0){
            System.out.println(Thread.currentThread().getName()+" 票号: "+ticket);
            ticket--;
        }
    }
}
public class ThreadSecMethod {
    public static void main(String[] args) {
        TicketWindows t1 = new TicketWindows();
        TicketWindows t2 = new TicketWindows();
        TicketWindows t3 = new TicketWindows();
        t1.setName("1号窗口");
        t2.setName("2号窗口");
        t3.setName("3号窗口");
        t1.start();
        t2.start();
        t3.start();

    }
}
