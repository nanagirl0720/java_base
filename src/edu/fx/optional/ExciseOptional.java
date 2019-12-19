package edu.fx.optional;

import edu.fx.stream.Student;

import java.util.Optional;
import java.util.function.Consumer;

/**
 * @author: Pxn
 * @date: 2019/12/19 17:00
 */
public class ExciseOptional {
    public static void main(String[] args) {
        Student aa=null;
        //System.out.println(Optional.of(aa));//报错：空指针异常 NullPointerException
        Student nana = new Student("nana", 28);
        Optional<Student> nana1 = Optional.of(nana);
        System.out.println(nana1);
        System.out.println(Optional.of(new Student()));

        Optional<Object> empty = Optional.empty();
        System.out.println(empty.getClass().getName());
        System.out.println(Optional.ofNullable(nana1));

        //判断类型是Optional的对象nana1中是否包含对象
        System.out.println(nana1.isPresent());//true 包含
        nana1.ifPresent( s -> System.out.println("有值"));
        System.out.println(Optional.of(new Student()).get());
        Student stu = new Student();
        Optional<Student> sp= Optional.ofNullable(new Student("dz",30));
        System.out.println(sp.orElse(nana));
    }
}
