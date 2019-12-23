package edu.fx.thread;

import java.util.concurrent.*;

/**
 * @author: Pxn
 * @date: 2019/12/23 21:55
 */
class RunThread implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i%2==0){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
}
class RunThread1 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i%2!=0){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
}
class CallThread implements Callable<String>{
    String str="xiaona";
    @Override
    public String call() throws Exception {
        if (str !=null){
            str+=" love zhen";
           // System.out.println(str);
        }
        return str;
    }
}
public class CreateThreadFour {
    public static void main(String[] args) {
        //获取多线程池
        ExecutorService service = Executors.newFixedThreadPool(10);
        System.out.println(service.getClass()); //class java.util.concurrent.ThreadPoolExecutor
        ThreadPoolExecutor threadPoolExecutor=(ThreadPoolExecutor)service;  //父类转子类（强制转换）
        //设置多线程池
        threadPoolExecutor.setCorePoolSize(12);
        //System.out.println(threadPoolExecutor.getTaskCount());
        //开启多线程
        //service.execute(new RunThread());//放入Runnable线程
        //service.execute(new RunThread1());//放入Runnable线程
        FutureTask<String> stringFutureTask = new FutureTask<>(new CallThread());
        service.submit(stringFutureTask);//放入Callable线程
        //得到stringFutureTask线程中返回的字符串
           String s = null;
            try {
                s = stringFutureTask.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        System.out.println(s);
        service.shutdown();
    }
}
