package edu.fx.jihe;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author: Pxn
 * @date: 2019/12/26 20:46
 */
public class ArrayListTest {
    public static void main(String[] args) {
        System.out.println("====1.ArrayList源码===========");
        ArrayList arrayList = new ArrayList(20);//创建了一个类型是Object的空数组
        arrayList.add(123);//添加数据时，先判断内部容量，然后长度加一
        arrayList.add(4);
        arrayList.add(4);
        arrayList.add(new int[]{1,2,4});
        arrayList.add("AA");
        arrayList.add(new Student("dz",28));
        System.out.println(arrayList);
        System.out.println("2.ArrayList中的方法");
        //由于List底层是索引，动态数组，所以重写了Collection接口的方法
        //增：add
        arrayList.add(false);//在末尾添加数据
        arrayList.add(2,88);//相当于insert插入
        System.out.println(arrayList);
        //删：remove
       //Object remove = arrayList.remove(4);//删除的是索引下标为4的数据
        //System.out.println(remove);
        System.out.println(arrayList);
        boolean remove1 = arrayList.remove(new Integer(4));//把是4的数据删除掉
        System.out.println(remove1);
        System.out.println(arrayList);
        //System.out.println(arrayList.removeAll(arrayList));
        System.out.println(arrayList);
        //改：set()
        arrayList.set(3,"nihao");
        System.out.println(arrayList);
        //查：get()
        Object o = arrayList.get(3);
        System.out.println(o);
        //遍历1->经典采用
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        //遍历2->加强版for循环
        for(Object obj : arrayList){
            System.out.println(obj);
        }
        //遍历3->for
        for(int i=0;i<arrayList.size();i++){
            System.out.println(arrayList.get(i));
        }

    }
}
