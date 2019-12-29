package edu.fx.iostream;

import java.io.*;

/**
 * @author: Pxn
 * @date: 2019/12/29 20:42
 */
public class BufferTest {
    public static void main(String[] args) {
        //将本地的图片复制到项目的相对路径下
        File file = new File("F:\\1pxn\\test\\wx.jpg");
        File copyFile = new File("wx.jpg");
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
