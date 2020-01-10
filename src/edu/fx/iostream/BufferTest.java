package edu.fx.iostream;

import java.io.*;

/**
 * @author: Pxn
 * @date: 2019/12/29 20:42
 */
public class BufferTest {
    public static void main(String[] args) {
        //testCopyVideo();
        bufferedTest("wx.jpg","D:/wx.jpg");
    }

    private static void testCopyVideo() {
        long start = System.currentTimeMillis();
        String files="C:\\Users\\LittleDog\\Desktop\\15-尚硅谷-Java语言高级-缓冲流(字节型)实现非文本文件的复制-超清720P.qsv";
        String copyFiles="video.qsv";
        bufferedTest(files,copyFiles);
        long end = System.currentTimeMillis();
        System.out.println(end-start);//4404
    }

    public static void bufferedTest(String files,String copyFiles) {
        //将本地的图片复制到项目的相对路径下
        File file = new File(files);
        File copyFile = new File(copyFiles);
        //创建需要操作的流
        BufferedInputStream bufferedInputStream=null;
        BufferedOutputStream bufferedOutputStream=null;
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            FileOutputStream fileOutputStream = new FileOutputStream(copyFile);

            bufferedInputStream = new BufferedInputStream(fileInputStream);
            bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            //复制
            byte[] tpfz=new byte[200];
            int date;
            while (((date=bufferedInputStream.read(tpfz))!=-1)) {
                bufferedOutputStream.write(tpfz, 0, date);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (bufferedInputStream!=null){
                //关闭流
                try {
                    bufferedInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bufferedOutputStream!=null){
                try {
                    bufferedOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
