package edu.fx.lambda;

import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.function.Consumer;

/**
 * @author: Pxn
 * @date: 2019/12/18 21:23
 */
public class ExciseLambda {
    public static void main(String[] args) {

        System.out.println("===1.函数式接口Runnable==========================");
        test1();
        test2();
        System.out.println("===2.函数式接口Comparator==========================");
        test3();
        test4();
        test5();
        System.out.println("===3.Lambda语法==========================");
        //1.无参数、无返回值
        Runnable runnable = () -> System.out.println("好好学习，天天向上！");
        runnable.run();
        test6();
        //2.一个参数、无返回值
        Consumer<String> consumer = (s) ->  System.out.println("努力奋斗，买车买房！");
        consumer.accept("今天你努力了吗？");
        //2.一个参数、无返回值
        Consumer<String> consumer1 = s ->  System.out.println("努力奋斗，买车买房！");//形参的小括号可以省略
        consumer1.accept("今天你努力了吗？");
        test7();
        test8();


    }

    private static void test8() {
        //3.两个形参、有返回值
        Comparator<Integer> com1 =(i1, i2) -> Integer.compare(i1,i2);
        int compare1 = com1.compare(12, 23);
        if(compare1==0){
            System.out.println("左边等于右边");
        }else if(compare1==1){
            System.out.println("左边大于右边");
        }else if(compare1==-1){
            System.out.println("右边大于左边");
        }
    }

    private static void test7() {
        //3.两个形参、有返回值
        Comparator<Integer> com = new Comparator<Integer>() {
            @Override
            public int compare(Integer i1,Integer i2) {
                return Integer.compare(i1,i2);
            }
        };
        int compare = com.compare(1, 1);
        if(compare==0){
            System.out.println("左边等于右边");
        }else if(compare==1){
            System.out.println("左边大于右边");
        }else if(compare==-1){
            System.out.println("右边大于左边");
        }
    }

    private static void test6() {
        //2.一个参数、无返回值
        //@SuppressWarnings(value = "rawtypes")//ArrayList泛型未使用注解
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println("努力奋斗，买车买房！");
            }
        };
        consumer.accept("今天你努力了吗？");
    }

    private static void test5() {
        Comparator<Integer> comparable = Integer::compare;//Lambda方法引用的的写法（::Lambda方法引用的符号）
        System.out.println(comparable.compare(123, 23));
    }

    private static void test4() {
        Comparator<Integer> comparable = (i1, i2) -> Integer.compare(i1,i2);//Lambda表达式的写法（->Lambda表达式符号）
        System.out.println(comparable.compare(123, 23));
    }

    private static void test3() {
        Comparator<Integer> comparable = new Comparator<Integer>() {
            @Override
            public int compare(Integer i1,Integer i2) {
                return Integer.compare(i1,i2);
            }
        };
        System.out.println(comparable.compare(12, 23));
    }

    private static void test2() {
        Runnable rb = () -> {
                Date date = new Date();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                System.out.println("今天是"+simpleDateFormat.format(date));
        };
        rb.run();
    }

    private static void test1() {
        Runnable rb = new Runnable() {
            @Override
            public void run() {
                Date date = new Date();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                System.out.println("今天是"+simpleDateFormat.format(date));
            }
        };
        rb.run();
    }
}
