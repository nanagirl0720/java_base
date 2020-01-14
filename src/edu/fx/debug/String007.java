package edu.fx.debug;

/**
 * @author: Pxn
 * @date: 2020/1/6 21:28
 */
public class String007 {
    public static void main(String[] args) {
        //String的难点
        String string=null;
        StringBuffer sb1 = new StringBuffer();
        sb1.append(string);//需看源码   底层添加了“null”
        System.out.println(sb1.length());//4
        System.out.println(sb1);
        StringBuffer sb2 = new StringBuffer(string);//需看源码  抛异常NullPointerException
        System.out.println(sb2);

    }
}
