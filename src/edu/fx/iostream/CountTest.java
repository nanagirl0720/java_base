package edu.fx.iostream;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author: Pxn
 * @date: 2019/12/30 22:18
 */
public class CountTest {
    public static void main(String[] args) {
        //统计文件中每个字符出现的次数
        String file="hello.txt";
        Map<Character, Integer> cnh = new HashMap<>();
        FileReader fileReader=null;
        BufferedWriter fileWriter=null;
        try {
            fileReader = new FileReader(new File(file));
            //操作读文件
            int c=0;
            while ((c=fileReader.read())!=-1){//读取文件，直到读完返回-1
                char ch=(char)c;//定义字符，存储每次读到的字符
                if (cnh.get(ch)==null){//通过获取map中的key(无序且不重复)：第一次key存为1
                    cnh.put(ch,1);
                }else {
                    cnh.put(ch,cnh.get(ch)+1);//以后每次累加
                }

            }
            //操作写文件
            //把map中的文件写入count.txt中
            //创建写的流
            fileWriter = new BufferedWriter(new FileWriter(new File("count.txt")));
            //遍历map，再写入数据
            Set<Map.Entry<Character, Integer>> entries = cnh.entrySet();
            for (Map.Entry<Character,Integer> entry:entries){
                switch (entry.getKey()){
                    case ' ':
                        fileWriter.write("空格="+entry.getValue());
                        break;
                    case '\n':
                        fileWriter.write("换行="+entry.getValue());
                        break;
                    case '\t':
                        fileWriter.write("Tab="+entry.getValue());
                        break;
                    case '\r':
                        fileWriter.write("回车="+entry.getValue());
                        break;
                    default:
                        fileWriter.write(entry.getKey()+"="+entry.getValue());
                        break;
                }
                fileWriter.newLine();//换行
            }
        }catch (IOException i){
            i.printStackTrace();
        }finally {
            //关闭流
            if (fileReader!=null){
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileWriter!=null){
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
