package edu.function;

import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: Pxn
 * @date: 2020/1/9 20:10
 */
public class WorldExport {
    public static void main(String[] args) {
        Map<String,Object> dataMap = new HashMap<String, Object>();
        try {
            //编号
            dataMap.put("id", "123456");
            //日期
            dataMap.put("date", new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
            //附件张数
            dataMap.put("number", 1);
            //收款人
            dataMap.put("payee", "张三");
            //付款用途
            dataMap.put("use_of_payment", "test");
            //大写金额
            dataMap.put("capitalization_amount", 100.0);
            //小写金额
            dataMap.put("lowercase_amount", "100");
            //Configuration 用于读取ftl文件
            Configuration configuration = new Configuration();
            configuration.setDefaultEncoding("utf-8");

            /**
             * 以下是两种指定ftl文件所在目录路径的方式，注意这两种方式都是
             * 指定ftl文件所在目录的路径，而不是ftl文件的路径
             */
            //指定路径的第一种方式（根据某个类的相对路径指定）
//                configuration.setClassForTemplateLoading(this.getClass(), "");

            //指定路径的第二种方式，我的路径是C：/a.ftl
            configuration.setDirectoryForTemplateLoading(new File("D:/"));

            //输出文档路径及名称
            File outFile = new File("D:/报销信息导出1.doc");

            //以utf-8的编码读取ftl文件
            Template template = configuration.getTemplate("报销信息导出.ftl", "utf-8");
            Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile), "utf-8"), 10240);
            template.process(dataMap, out);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
