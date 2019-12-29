package edu.fx.iostream;

import java.io.*;

/**
 * @author: Pxn
 * @date: 2019/12/29 18:59
 */
public class FileReaderTest {
    public static void main(String[] args)  {
        //读文件:FileReader
        //readFileTest();
        //写文件:FileWriter
        //writeFileTest();

    }

    private static void writeFileTest() {
        //步骤一：创建文件
        File file = new File("hello.txt");
        //步骤二：创建需要操作的流
        FileWriter fileWriter=null;
        try {
            fileWriter = new FileWriter(file,true);
            //步骤三：写入操作
            fileWriter.write("\n董镇今天骂我了，我不开心!董镇是坏蛋！大坏蛋！\n");
            fileWriter.write("但是，我还是很爱很爱他。");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (fileWriter!=null){
                //关闭流
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void readFileTest() {
        //创建一个文件
        File file = new File("hello.txt");
        //System.out.println(file.createNewFile());

        //读取文件中的内容
        //步骤一：创建文件（已创建）
        //步骤二：创建需要操作的流
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(file);
            //第三步：读
            char[] zfsz=new char[200];
            int date;
            while ((date=fileReader.read(zfsz))!=-1){//read(zfsz)：返回读入数组中字符的个数，达到末尾，返回-1
                String s = new String(zfsz, 0, date);
                System.out.println(s);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            if (fileReader!=null){
                //第四步：关闭流
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
