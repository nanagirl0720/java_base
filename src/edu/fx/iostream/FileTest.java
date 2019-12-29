package edu.fx.iostream;

import java.io.File;
import java.io.IOException;

/**
 * @author: Pxn
 * @date: 2019/12/29 12:56
 */
public class FileTest {
    public static void main(String[] args) throws IOException {
        //一、利用构造器new一个文件目录File
        //1.在其创建多个文件和目录
        File f1 = new File("F:\\1pxn\\test");//构造器1，String目录
        boolean mkdirs = f1.mkdirs();
        System.out.println(mkdirs);
        File f2 = new File(f1,"hello");//构造器2.File目录，String目录
        File f3 = new File(f1,"hello1");//构造器2.File，String
        System.out.println(f2.mkdirs());//在test目录下再创建一个子目录
        System.out.println(f3.mkdirs());//在test目录下再创建一个子目录
        File f4 = new File("F:\\1pxn\\test", "test2.txt");//构造器3，String目录，String文件
        File f5 = new File("F:\\1pxn\\test", "test3.txt");//构造器3，String，String
        File f6 = new File(f2, "test3.txt");//构造器2，File目录，String文件
        boolean newFile = f4.createNewFile();
        boolean newFile1 = f6.createNewFile();
        System.out.println(newFile1);
        //2.删除指定文件目录下的所有文件及目录
        //testDeletFile(f2);

        //二、判断指定目录下是否有.jpg文件，如果有则输出文件名称
        String[] filenameList = f2.list();
        if (filenameList.length>0){
            for (String s : filenameList){
                if (s.endsWith(".jpg")){
                    System.out.println(s);
                }
            }
        }

        //三、遍历指定目录下的文件及子目录下的文件
        getFilePath(f2);

        //三、1.计算指定目录所占用的大小
        //sumFileLength(f2);
        //三、2.删除指定路径下的文件
        //遍历指定目录下的文件及子目录下的文件
        //deleteFIles(f2);
    }

    private static void deleteFIles(File f2) {
        if (f2.isDirectory()){//如果是目录
            File[] files = f2.listFiles();//得到目录中的所有文件
                for (File f:files){
                    deleteFIles(f);
                }
            }
        f2.delete();//删除文件/目录(此时目录为空目录)
    }

    private static void sumFileLength(File f2) {
        //第一步：遍历指定目录下的文件及子目录下的文件
        //第二步：sum
        Long l=0l;
        File[] files = f2.listFiles();
        for (File fi:files){
            if (fi.isDirectory()){
                getFilePath(fi);
            }else {
                l+=fi.length();
            }
        }
        System.out.println(l);
    }

    private static void getFilePath(File f2) {
        //遍历指定目录下的文件及子目录下的文件
        File[] files = f2.listFiles();
        for (File fi:files){
            if (fi.isDirectory()){
                getFilePath(fi);
            }else {
                System.out.println(fi.getPath());
            }
        }
    }

    private static void testDeletFile(File f2) {
        //编写方法，删除指定文件
        //String[] list = f2.list();//方式一调用list方法：获取当前目录下所有文件名称数组
        File[] files = f2.listFiles();//方式二调用listFile：获取当前目录下的所有文件数组
        System.out.println(f2.delete());//a由于f2(hello)存在文件，所以删除不成功，必须先删除文件，再删除目录
        System.out.println(f2.getPath());//a获取f2(hello)的路径：F:\1pxn\test\hello
        /*if (list.length>0){//a如果当前目录下有文件
            for (String s : list){
                File file = new File(f2.getPath(), s);//a创建当前f2(hello)的路径下每个文件的file对象
                file.delete();//a删除自己（先删除文件）
            }
        }*/
        if (files.length>0){
            for(File f:files){
                f.delete();
            }
        }
        boolean delete = f2.delete();//a再删除目录
        System.out.println(delete);
    }
}
