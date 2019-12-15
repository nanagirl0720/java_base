package edu.fx.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: Pxn
 * @date: 2019/12/15 21:16
 */
public class ArrayListAndLinkedList {
    private static final int LIST_SIZE = 1000;

    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<Integer>();
        List<Integer> linkedList = new LinkedList<Integer>();

        for(int i = 0; i < LIST_SIZE; i++){
            arrayList.add(i);
            linkedList.add(i);
        }

        long startTime = System.currentTimeMillis();
        for(int i = 0; i < arrayList.size(); i++){
            arrayList.get(i);
        }
        System.out.println("ArrayList的for循环遍历速度：" + (System.currentTimeMillis() - startTime) + "ms");

        startTime = System.currentTimeMillis();
        for(int i = 0; i < linkedList.size(); i++){
            linkedList.get(i);
        }
        System.out.println("LinkedList的for循环遍历速度：" + (System.currentTimeMillis() - startTime) + "ms");

    }
}
