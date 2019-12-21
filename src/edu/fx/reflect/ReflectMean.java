package edu.fx.reflect;

import edu.fx.stream.Student;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * @author: Pxn
 * @date: 2019/12/21 13:59
 */
public class ReflectMean {

    public static void main(String[] args) throws Exception {

        //正常实例化对象
        Student dz = new Student("dz", 28);
        System.out.println(dz.toString());

        //反射实例化
        //反射的含义：通过类的getClass方法获取到的反射对象，通过该对象可以看到类的结构。
        //所以 形象的称之为“反射”
        Student student = new Student();
        Class aClass = student.getClass();
        System.out.println(aClass);
        Constructor constructor = aClass.getConstructor(String.class, int.class);
        //通过反射，获取类对象
        Student dzgg = (Student)constructor.newInstance("dzgg", 28);
        System.out.println(dzgg.toString());
//        dzgg.setName("一朵花");
//        System.out.println(dzgg);
        //通过反射，获取对象属性
        Field age = aClass.getDeclaredField("age");
//        age.set(dzgg,29);//属性是私有的，public才可以调用
        System.out.println(dzgg.toString());;


    }
}
