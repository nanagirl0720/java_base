package edu.fx.jihe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/**
 * @author: Pxn
 * @date: 2019/12/25 18:01
 */
public class CollectionTest {
    public static void main(String[] args) {
        //创建对象  体现Java的多态性
        Collection coll = new ArrayList();
        //add()
        boolean a1 = coll.add(123);
        coll.add("nihao");
        coll.add(new String("nihao"));
        coll.add(false);
        coll.add(new Student("dz",28));
        System.out.println(coll);
        System.out.println(a1);//返回true，添加成功
        Collection cooll1 = Arrays.asList("I", "You");
        //addAll()
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(10);
        coll.addAll(arrayList);
        coll.addAll(cooll1);//addAll方法只能添加集合类型的数据
        System.out.println(coll);

        //可变参数
        Collection int1=Arrays.asList(1,2,3);
        Collection int2=Arrays.asList(new int[]{1,2,3});//可变形参将new int[]作为一个参数存放在容器中
        Collection int3=Arrays.asList(new Integer[]{1,2,3});//可变参数将new Integer[]作为三个参数放在容器中
        System.out.println(int1);
        System.out.println(int2);
        System.out.println(int3);

        //clear()
        //coll.clear();//清除集合中的所有数据
        System.out.println(coll);
        System.out.println(coll.size());//集合的大小
        System.out.println(coll.contains("I"));
        System.out.println(coll.contains(new String("nihao")));
        //contains()
        // 如果JavaBean不重写equals方法，那么会调用Object类中的equals方法,即返回false
        // 重写equals方法，返回true
        System.out.println(coll.contains(new Student("dz",28)));
        System.out.println(coll.containsAll(Arrays.asList(123)));
        System.out.println(int1.equals(int2));
        System.out.println(int1.equals(int3));
        System.out.println(int1.hashCode());
        System.out.println(int2.hashCode());
        System.out.println(cooll1.isEmpty());
        //coll.remove("I");
        //coll.remove("You");
        System.out.println(coll);
        //coll.removeAll(cooll1);//差集。除去了coll中存在的cooll1数据后的数据
        System.out.println(coll);
        coll.retainAll(cooll1);
        System.out.println(coll);//保留coll和cooll1中共有的数据
        //迭代器：专属于Collection集合的数据遍历输出，Map不行
        Iterator iterator = coll.iterator();
        //正确姿势的迭代
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }
}
