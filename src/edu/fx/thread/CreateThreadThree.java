package edu.fx.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author: Pxn
 * @date: 2019/12/23 20:14
 */

/**
 * 创建多线程的第三种方式5.0新增：实现Callable接口
 * 1.有返回值
 * 2.能抛异常
 * 3.实现泛型
 */
class Count implements Callable<Integer>{
    //第一步：实现接口
    int sum=0;
    @Override
    public Integer call() throws Exception {
        //第二步：重新call方法
        for (int i = 0; i <= 100; i++) {
           sum+=i;
        }
        return sum;
    }
}
public class CreateThreadThree {
    public static void main(String[] args) {
        //实例化：创建Callable接口实现类的对象
        Count count = new Count();
        //创建FutureTask对象：将Callable接口实现类传入构造器中
        FutureTask<Integer> futureTask = new FutureTask<Integer>(count);
        //创建Thread对象，并将FutureTask对象传入构造器中，并调用start方法
        new Thread(futureTask).start();
        Integer sum = null;
        try {
            sum = futureTask.get();//用get方法获取线程的返回值
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(sum);
    }

}
