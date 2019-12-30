package edu.fx.iostream;

import java.io.*;

/**
 * @author: Pxn
 * @date: 2019/12/30 19:52
 */
public class TextCopy {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        //将本地的文本文件copy到程序中
        String txtFile="F:\\1pxn\\test\\fpv处理原则.txt";
        String proFile="testFile.txt";
        BufferedReader bufferedReader=null;
        BufferedWriter bufferedWriter=null;
        try {
            bufferedReader = new BufferedReader(new FileReader(new File(txtFile)));
            bufferedWriter = new BufferedWriter(new FileWriter(new File(proFile)));
            /*
            //方式一：读写操作通过char[]
            char[] cbrf=new char[1024];
            int date;
            while ((date=bufferedReader.read(cbrf))!=-1){
                bufferedWriter.write(cbrf,0,date);
            }*/
            //方式二：读写操作通过string
            String data;
            while ((data=bufferedReader.readLine())!=null){
               // bufferedWriter.write(data+"\n");//data中不包含换行符
                bufferedWriter.write(data);
                bufferedWriter.newLine();//提供换行操作
            }
        }catch (IOException i){
            i.printStackTrace();
        }finally {
            //关闭流
            if (bufferedReader!=null){
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bufferedWriter!=null){
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        long end = System.currentTimeMillis();
        System.out.println(end-start);//6
    }
}
