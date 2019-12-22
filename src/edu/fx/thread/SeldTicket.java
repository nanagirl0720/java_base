package edu.fx.thread;

/**
 * @author: Pxn
 * @date: 2019/12/22 11:03
 */
class Windows extends Thread{
    private static int ticket = 100;
    @Override
    public void run() {
        while(true){
            if(ticket > 0) {
                System.out.println(getName() +" : "+ticket);
                ticket--;
            }else {
                System.out.println("sorry,sold out!");
                break;
            }
        }

    }
}
public class SeldTicket  {

    public static void main(String[] args) {
        Windows win1 = new Windows();
        Windows win2 = new Windows();
        Windows win3 = new Windows();
        win1.setName("窗口1");
        win2.setName("窗口2");
        win3.setName("窗口3");
        win1.start();
        win2.start();
        win3.start();

    }
}
