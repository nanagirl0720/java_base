package edu.fx.reflect;

/**
 * @author: Pxn
 * @date: 2019/12/21 16:33
 */
public class ClassLoaderTest {

    public static void main(String[] args) {

        ClassLoaderTest classLoaderTest = new ClassLoaderTest();//自定义类
        ClassLoader classLoader = classLoaderTest.getClass().getClassLoader();//获取自定义类的加载器
        System.out.println(classLoader.getParent());//获取自定义加载器的上一级：扩展类加载器
        System.out.println(classLoader.getParent().getParent());//获取扩展类加载器的上一级：引导类加载器（无法直接获取）
    }
}
