package edu.fx.list;

import edu.fx.jihe.Student;

import java.util.*;

/**
 * @author: Pxn
 * @date: 2019/12/27 20:37
 */
public class ListTest {
    public static void main(String[] args) {
        //test3();
        //test4();
        //练习5：写出以下代码的输出结果
        HashSet hashSet = new HashSet();
        Student s1 = new Student("badege", 19);
        Student s2 = new Student("goodPerson", 20);
        hashSet.add(s1);
        hashSet.add(s2);
        System.out.println("第一次输出结果为："+hashSet);//两个对象都输出
        s1.setName("nana");//修改了s1的name属性
        hashSet.remove(s1);//删除s1时，先根据s1{"nana",19}去计算哈希值，查找哈希值对应的存储位置，此时没有，所以没有删除成功
        System.out.println("第二次输出结果为："+hashSet);
        hashSet.add(new Student("nana",19));//用{"nana",19}计算哈希值，此时存储位置上没有数据，添加成功
        System.out.println("第三次输出结果为："+hashSet);
        hashSet.add(new Student("badege", 19));//用{"badege", 19}计算哈希值，
        // 此时存储位置上有数据，那么判断equals方法，由于先前的"badege"被修改了属性为"nana",所以，集合中存储的是{"nana",19}与
        // 此时的{"badege",19}判断equals方法，此时返回false，所以添加成功。
        System.out.println("第四次输出结果为："+hashSet);

        //test1(l, sumMin, sumMax);
        //test2();
    }

    private static void test4() {
        //练习1：（改造test3）在list中去除重复数据，要求尽量简单
        List list = new ArrayList();
        list.add(new Student("dz",28));
        list.add(new Student("dz",27));
        list.add(new Student("dz",28));
        list.add(new Student("dz1",28));
        list.add(new Student("dz",28));
        System.out.println(list);

        List list1 = distinctList(list);
        Iterator iterator = list1.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    private static List distinctList(List list) {
        HashSet hashSet1 = new HashSet();
        hashSet1.addAll(list);
        return new ArrayList(hashSet1);
    }

    private static void test3() {
        //练习1：在list中去除重复数据，要求尽量简单
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Student("dz",28));
        arrayList.add(new Student("pxn",18));
        arrayList.add(new Student("dz",28));
        arrayList.add(new Student("pxn",27));
        arrayList.add(new Student("pxn",18));
        System.out.println(arrayList);

        distinctList(arrayList);
    }

    private static void test2() {
        //组套餐

        Double l=0.0;
        Double sumMin=40.0;
        Double sumMax=42.0;
        double[] doubles = {1.9, 0.9, 0.9, 40.0};
        for (int i=0;i<doubles.length;i++){
            for (int j=1;j<doubles.length;j++){
                l=doubles[i]+doubles[j];
                if (l>sumMin && l<sumMax){
                    System.out.println(doubles[i]+"、"+doubles[j]);
                }
                for (int k=0;k<doubles.length;k++){
                    l=doubles[i]+doubles[j]+doubles[k];
                    if (l>sumMin && l<sumMax){
                        System.out.println(doubles[i]+"、"+doubles[j]+"、"+doubles[k]);
                    }
                }
            }
        }
    }

    private static void test1(Double l, Double sumMin, Double sumMax) {
        List list = Arrays.asList(12.9, 22.9, 4.9, 41.0);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()){
            l+=(Double) iterator.next();
        }
        System.out.println("============");
        while (iterator.hasNext()){
            Double next = (Double)iterator.next();
            if (next>sumMin && next<sumMax){
                l=next;
            }
        }
        System.out.println(l);
    }
}
