package edu.fx.reflect;

import edu.fx.stream.Student;

/**
 * @author: Pxn
 * @date: 2019/12/21 13:40
 */
public class ReflectExample {

    public static void main(String[] args) throws ClassNotFoundException {

        //获取反射实例
        //方式一：通过对象的getClass方法
        Student student = new Student();
        Class aClass = student.getClass();
        System.out.println(aClass);
        //方式二：通过类的静态属性class
        Class<Student> studentClass = Student.class;
        System.out.println(studentClass);
        //方法三：Class类的forName方法
        Class student1 =Class.forName("edu.fx.stream.Student");
        System.out.println(student1);
        //方法四：
        ClassLoader classLoader = Student.class.getClassLoader();
        Class<?> loadClass = classLoader.loadClass("edu.fx.stream.Student");
        System.out.println(loadClass);
        System.out.println("判断：Class的实例对应着一个运行时类");
        System.out.println(aClass==studentClass);
        System.out.println(studentClass==student1);
        System.out.println(student1==loadClass);

        //理解：只要是数组的类型和维度一样，就是同一个Class
        int[] ints = new int[4];
        int[] ints1 = new int[5];
        Class intsClass = ints.getClass();
        Class ints1Class = ints1.getClass();
        System.out.println("理解含义：");
        System.out.println(intsClass==ints1Class);

    }
}
