package edu.fx.thread;

/**
 * @author: Pxn
 * @date: 2019/12/22 17:53
 */
class SeldTicketWindows extends Thread{
    static int ticket=100;
    @Override
    public void run() {
        while (true){
            if (ticket > 0){
                System.out.println(getName()+" 您的票号是: " + ticket );
                ticket--;
            }else{
                System.out.println("Sorry！今天已经售完了。");
                break;
            }
         }
    }
}
public class TicketThread {
    public static void main(String[] args) {
        SeldTicketWindows sell1 = new SeldTicketWindows();
        SeldTicketWindows sell2 = new SeldTicketWindows();
        SeldTicketWindows sell3 = new SeldTicketWindows();
        sell1.setName("1窗口");
        sell2.setName("2窗口");
        sell3.setName("3窗口");
        sell1.start();
        sell2.start();
        sell3.start();
    }
}
