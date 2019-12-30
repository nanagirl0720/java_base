package edu.fx.iostream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author: Pxn
 * @date: 2019/12/30 21:44
 */
public class PicYhTest {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        //图片异或加密
        String photo="lover.jpg";
        String photoFile="F:\\1pxn\\test\\lover1.jpg";
        picJm(photo, photoFile);//图片加密对应解密（异或一次加密，再异或一次解密）
        long end = System.currentTimeMillis();
        System.out.println(end-start);//加密：163  解密153
    }

    private static void picJm(String photo, String photoFile) {
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            fileInputStream = new FileInputStream(new File(photo));
            fileOutputStream = new FileOutputStream(new File(photoFile));
            //读写操作
            byte[] bfos=new byte[100];
            int data;
            while ((data=fileInputStream.read(bfos))!=-1){
                for (int i=0;i<data;i++){
                    bfos[i]= (byte) (bfos[i]^5);
                }
                fileOutputStream.write(bfos);
            }
        }catch (IOException i){
            i.printStackTrace();
        }
    }
}
