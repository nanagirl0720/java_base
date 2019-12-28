package edu.fx.jihe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author: Pxn
 * @date: 2019/12/28 22:38
 */
public class CollectionsTest {
    public static void main(String[] args) {
        //Collections方法练习（方法是静态的）
        ArrayList arrayList = new ArrayList();
        arrayList.add(12);
        arrayList.add(2);
        arrayList.add(0);
        arrayList.add(-22);
        arrayList.add(82);
        System.out.println(arrayList);
        Collections.reverse(arrayList);//顺序反转
        System.out.println(arrayList);
        Collections.shuffle(arrayList);//随机排序
        System.out.println(arrayList);
        Collections.sort(arrayList);//自然排序-从小到大
        System.out.println(arrayList);
        Collections.swap(arrayList,3,2);
        System.out.println(arrayList);//索引是3的数据和2交换
        Comparable max = Collections.max(arrayList);//返回集合中的最大数
        System.out.println(max);
        Comparable min = Collections.min(arrayList);//返回集合中的最小数
        System.out.println(min);
        int frequency = Collections.frequency(arrayList, 2);//返回2在集合中出现的次数
        System.out.println(frequency);
        List dest= Arrays.asList(new Object[arrayList.size()]);
        Collections.copy(dest,arrayList);//将集合中的数据复制给新的集合
        System.out.println(dest);
    }
}
