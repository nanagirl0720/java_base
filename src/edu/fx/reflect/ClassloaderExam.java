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

        fileStreamtest();
        Properties properties = new Properties();
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        InputStream resourceAsStream = classLoader.getResourceAsStream("jdbc1.properties");
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
