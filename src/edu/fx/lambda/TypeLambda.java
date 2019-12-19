package edu.fx.lambda;

import edu.fx.stream.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @author: Pxn
 * @date: 2019/12/19 14:54
 */
public class TypeLambda {
    public static void main(String[] args) {

        //消费型接口 Consumer<T>     void accept(T t)
        Consumer<String> consumer= s -> System.out.println("好好学习，天天向上！");
        consumer.accept("名言警句");

        //供给型接口 Supplier<T>     T get()
        Supplier<String> supplier = () -> "努力奋斗，买车买房！";
        System.out.println(supplier.get());;

        Student dz = new Student("dongzhen", 29);
        Supplier<String> sup = () -> dz.getName() ;
        System.out.println(sup.get() + " say: 你俗不俗  ");
        test8();
        test9();


    }

    private static void test9() {
        List<String> strings = Arrays.asList("北京", "天津", "南京", "东京", "京东", "京剧");
        List<String> stringList = filterContains(strings, s -> s.contains("京"));
        System.out.println(stringList);
    }

    private static void test8() {
        //函数型接口

        List<String> strings = Arrays.asList("北京", "天津", "南京", "东京", "京东", "京剧");

        List<String> stringList=filterContains(strings,new Predicate<String>(){
            @Override
            public boolean test(String s) {
                return s.contains("京");
            }
        });
        System.out.println(stringList);
    }

    //1.制定匹配规则:判断输出包含“京”字符串
    public static List<String> filterContains(List<String> stringList, Predicate<String> pre){
        List<String> strings = new ArrayList<>();
        for (String s: stringList) {
            if(pre.test(s)){
                strings.add(s);
            }
        }
        return strings;
    }
}
