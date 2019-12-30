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
        long start = System.currentTimeMillis();
        String files="C:\\Users\\LittleDog\\Desktop\\15-尚硅谷-Java语言高级-缓冲流(字节型)实现非文本文件的复制-超清720P.qsv";
        String copyFiles="video.qsv";
        fileStreamCopyTest(files, copyFiles);
        long end = System.currentTimeMillis();
        System.out.println(end-start);//6332
    }

    private static void fileStreamCopyTest(String files, String copyFiles) {
        //通过节点流处理视频复制
        File file = new File(files);
        File copyFile = new File(copyFiles);
        //创建需要操作的流
        FileInputStream fileInputStream=null;
        FileOutputStream fileOutputStream=null;
        try {
            fileInputStream = new FileInputStream(file);
            fileOutputStream = new FileOutputStream(copyFile);

            //复制
            byte[] tpfz=new byte[200];
            int date;
            while (((date=fileInputStream.read(tpfz))!=-1)) {
                fileOutputStream.write(tpfz, 0, date);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (fileInputStream!=null){
                //关闭流
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileOutputStream!=null){
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
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
