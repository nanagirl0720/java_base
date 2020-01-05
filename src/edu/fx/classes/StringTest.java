package edu.fx.classes;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author zd
 * @version v1.0
 * @2020 01 04 15 26
 */
public class StringTest {
    public static void main(String[] args) {
        //面试题：s1、s2是多少？ 都是“012345”
        String s1="0";
        for (int i=1;i<=5;i++){
            s1+=i;
        }
        System.out.println("s1="+s1);
        String s2=new String("0");
        for (int i=1;i<=5;i++){
            s2+=i;
        }
        System.out.println("s2="+s2);

        //面试题：转置字符串
        String s3=new String("abc123");
        CharSequence charSequence = s3.subSequence(1, 5);
        System.out.println(charSequence);
        String string = charSequence.toString();
        Collections.reverse(Arrays.asList(string));
        System.out.println(string);

        //面试题：模拟一个trim方法，去掉两端的空格
        String s4=new String("  I Love You  ");
        System.out.println(s4.trim());

        //面试题：将abcdefg反转为abfedcg
        //方式一：采用拼接的方式
        String s5 = new String("abcdefg");
        int indexStart=2;
        int indexEnd=6;
        String s = testIndexReverse(s5, indexStart, indexEnd);
        System.out.println(s);

        //方式二：采用字符转置
        char[] chars = s5.toCharArray();
        System.out.println(chars.length);
        for (int i = indexStart,j=indexEnd-1; i<j ; i++,j--) {
            char temp=chars[i];
            chars[i]=chars[j];
            chars[j]=temp;
        }
        System.out.println(chars);

        //面试题：ab在abkkcadkabkebfkabkskab中出现的次数
        String substr="ab";
        String mainstr="abkkcadkabkebfkabkskab";

        int count = getCount(substr, mainstr);
        System.out.println(count);


    }

    private static int getCount(String substr, String mainstr) {
        int sub = substr.length();
        int main = mainstr.length();
        int index=0;
        int count=0;
        if (main>=sub){
            //indexOf判断子字符串是否在主字符串中存在，如果相等，返回0；如果不存在，返回-1，如果存在返回1
            //方式一：
//            while ((index=mainstr.indexOf(substr))!=-1){
//                count++;
//                mainstr=mainstr.substring(index+substr.length());
//            }
            //方式二：在方式一的基础上优化
            while ((index=mainstr.indexOf(substr,index))!=-1){
                count++;
                index+=sub;
            }
            return count;
        }else {
            return 0;
        }
    }

    private static String testIndexReverse(String string, int indexStart, int indexEnd) {
        StringBuilder stringBuilder = new StringBuilder(string.length());
        //第一部分
        String ss1 = string.substring(0, indexStart);
        System.out.println(ss1);
        stringBuilder.append(ss1);
        //第二部分（反转）
        String ss2 = string.substring(indexStart, indexEnd);
        stringBuilder.append(new StringBuilder(ss2).reverse());
        //第三部分
        stringBuilder.append(string.substring(indexEnd, indexEnd+1));
        return new String(stringBuilder);
    }

}
class StringLianXi{
    String s=new String("good");
    char[] c=new char[]{'t','e','s','t'};
    public void exchange(String str,char[] ch){
        str="test ok";
        ch[0]='b';
    }

    public static void main(String[] args) {
        System.out.println("======");
        //面试题：输出的结果是多少？
        StringLianXi stringLianXi = new StringLianXi();
        stringLianXi.exchange(stringLianXi.s,stringLianXi.c);
        System.out.println(stringLianXi.s);//good
        System.out.println(stringLianXi.c);//best
    }
}
