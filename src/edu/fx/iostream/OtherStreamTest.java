package edu.fx.iostream;

import java.io.*;

/**
 * @author zd
 * @version v1.0
 * @2020 01 01 12 47
 */
public class OtherStreamTest {
    public static void main(String[] args) {
        /**
         * 其他流：转换流输入输出流、打印流、
         */
        //1.转换流
        //练习：将本地文本(gb2321)文件上传到idea(utf-8)
        //changeStream();

        //2.打印流、借用缓存流的行输出
        //练习： 键盘输入字符串，要求输入的字符串按大写整行输出，然后继续输入；直到输入"e"或者"exit"退出控制台
        //controlSysout();

        //3.打印流、输出流
        //练习：把1-255的字符输出的文件中
        //printStreamTest();

        //4.对象流（数据流是将文件中的基本数据类型的读取。对象流除了基本类型外还可以读取object类型）
        //练习：序列化对象：对象持久化存储在文件中；对象反序列化读取在内存中
        //方法一：序列化对象
        //objectStreamXlhTest();//对象流的序列化
        //方法二：反序列化对象
        //objectStreamFxlhTest();//对象流的反序列化
    }

    private static void objectStreamFxlhTest() {
        ObjectInputStream ois=null;
        try {
            ois=new ObjectInputStream(new FileInputStream(new File("String.dat")));
            Object object=ois.readObject();
            String string=(String)object;
            System.out.println(string);
        }catch (Exception i){
            i.printStackTrace();
        }finally {
            if (ois!=null){
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void objectStreamXlhTest() {
        ObjectOutputStream oos=null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(new File("String.dat")));
            oos.writeObject("我爱北京天安门");
        }catch (IOException f){
            f.printStackTrace();
        }finally {
            if(oos!=null){
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void printStreamTest() {
        PrintStream printStream = null;
        try {
            printStream=new PrintStream(new FileOutputStream(new File("F:\\学习\\GitHubProject\\everyday_word\\zifu.txt")), true);
            if (printStream!=null){
                System.setOut(printStream);//重新指定打印流：指定打印到TXT文件中（把标准输出到控制台的改为输出到文件中）
            }

            for (int i=1;i<=255;i++){
                System.out.print((char)i);
                if (i%50==0){
                    System.out.println();
                }
            }
        }catch (FileNotFoundException f){
            f.printStackTrace();
        }finally {
            //关闭流
            printStream.close();
        }
    }

    private static void controlSysout() {
        //创建流
        InputStreamReader inputStreamReader=null;
        BufferedReader bufferedReader=null;
        try {
            inputStreamReader = new InputStreamReader(System.in);
            bufferedReader = new BufferedReader(inputStreamReader);
            //操作流
            while (true){
                //将读取到的数据存在string中
                String str=bufferedReader.readLine();
                if ("e".equalsIgnoreCase(str)||"exit".equalsIgnoreCase(str)){
                    System.out.print("即将退出程序！");
                    break;
                }
                String upperCase = str.toUpperCase();
                System.out.print(upperCase);
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
        }
    }

    private static void changeStream() {
        //创建流
        InputStreamReader isr = null;
        OutputStreamWriter osw =null;

        try {
            isr=new InputStreamReader(new FileInputStream(new File("F:\\学习\\GitHubProject\\everyday_word\\newFile.txt")),"gb2312");
            osw =new OutputStreamWriter(new FileOutputStream(new File("newFile_utf8.txt")),"utf-8");

            //存储数据
            char[] chars=new char[100];
            int data;
            //操作流
            while ((data=isr.read(chars))!=-1){
                osw.write(chars,0,data);
            }
        }catch (IOException i){
            i.printStackTrace();
        }finally {
            //关闭流
            if (isr!=null){
                try {
                    isr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (osw!=null){
                try {
                    osw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
