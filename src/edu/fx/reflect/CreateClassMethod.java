package edu.fx.reflect;

import edu.fx.jihe.Student;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/**
 * @author: Pxn
 * @date: 2020/1/13 16:07
 */
public class CreateClassMethod {
    public static void main(String[] args) throws Exception {
        /**
         * 创建类的三种方式
         */
        //方式一：new + 构造器（）
        Student s1 = new Student("dz", 123);
        s1.study();
        //方式二：反射newInstance
        Class classes = Class.forName("edu.fx.jihe.Student");
        Student s2 = (Student)classes.newInstance();
        s2.study();
        //方式三：反射构造器
        Class classes1 = Class.forName("edu.fx.jihe.Student");
        Constructor constructor = classes1.getConstructor();
        Student s3 = (Student)constructor.newInstance();
        s3.study();

        /**
         * 反射应用
         */
        //运用1：创建运行时类
        Class aClass = Class.forName("edu.fx.jihe.Student");//获取运行时类
        Student s4 = (Student)aClass.newInstance();//创建运行时类的对象
        s4.study();

        //运用2：运行时类的属性、方法、构造器、父类、接口、父类的泛型、包、注解、异常
        Field[] fields = aClass.getFields();
        for(Field f: fields){
            System.out.print("字段一"+f);
        }


    }
}
