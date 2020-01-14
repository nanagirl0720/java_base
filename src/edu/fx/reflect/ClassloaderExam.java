package edu.fx.reflect;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author: Pxn
 * @date: 2019/12/21 16:42
 */
public class ClassloaderExam {

    public static void main(String[] args) throws IOException {

        fileStreamtest();//使用流读取配置文件的信息
        fileClassLoaderTest();//使用类加载器加载资源文件
    }

    private static void fileClassLoaderTest() throws IOException {
        Properties properties = new Properties();
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();//运行时类的getClassLoader方法获取类加载器
        InputStream resourceAsStream = classLoader.getResourceAsStream("jdbc1.properties");//通过类加载器获取资源文件的流
        properties.load(resourceAsStream);
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");
        System.out.println("username="+username+"   password="+password);
    }

    private static void fileStreamtest() throws IOException {
        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream("jdbc.properties");
        properties.load(fileInputStream);
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");
        System.out.println("username="+username+"   password="+password);
    }
}
