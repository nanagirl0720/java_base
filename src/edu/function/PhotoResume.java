package edu.function;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 将map中的数据保存在Word中-doc另存为mht模板的格式（图片）
 * @author: Pxn
 * @date: 2020/1/9 20:42
 */
public class PhotoResume {
    public static void main(String[] args) throws IOException, TemplateException {
        //设置Word的内容显示
        StringBuffer sb = new StringBuffer();
        sb.append("<div>");
        sb.append("<img style='height:100px;width:100px;display:block;' src='D:/wx.jpg'/>");
        sb.append("</br><span>中国年，鸿运年</span>");
        sb.append("</div>");
        //1.创建保存数据的Map
        Map<String, Object> map = new HashMap<>();
        //第一步：创建操作的文件
        File resumeFile = new File("D:/resumeMB.ftl");//模板文件
        File myResume = new File("D:/myResume.doc");//输出文件
        File photo = new File("wx.jpg");
        //第二步：创建操作的流:
        FileOutputStream fileOutputStream = new FileOutputStream(myResume);//内存->输出到->磁盘文件[对于程序/内存来讲是输出流]
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream,"utf-8");//将字节流转换为字符流[Word保存的是字符]
        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter,10240);//缓冲流(处理流的一种，提高数据处理速度)
        FileOutputStream photoFileOutputStream = new FileOutputStream(photo);
        byte[] bytes=new byte[1024];
        photoFileOutputStream.write(bytes);
        //2.将参数存入map中
        map.put("username","蒲晓娜");
        map.put("photo",photoFileOutputStream);
        map.put("gender","女");
        map.put("high",160);
        map.put("weight",60);
        map.put("hobby","sleep,watchTV");
        map.put("birthday",new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        //3.读取文件
        //3.1创建读取文件的类
        Configuration configuration = new Configuration();
        //3.2设置读取文件的路径 dir
        configuration.setDirectoryForTemplateLoading(new File("D:/"));
        //3.3输出文件的名称及路径 myResume
        Template template = configuration.getTemplate("resumeMB.ftl", "utf-8");
        //3.4通过字符流将map中的数据写到模板中
        template.process(map,bufferedWriter);
        //第四步：关闭流
        bufferedWriter.close();
    }
}
