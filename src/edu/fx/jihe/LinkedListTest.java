package edu.fx.jihe;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author: Pxn
 * @date: 2019/12/27 8:40
 */
public class LinkedListTest {
    public static void main(String[] args) {
        System.out.println("LinkedList底层源码");
        LinkedList linkedList = new LinkedList();
        linkedList.add("nihao");
        /**
         *public boolean add(E e) {
         *     linkLast(e);
         *     return true;
         * }
         *
         *
         *void linkLast (E e){
         *final Node<E> l = last;    //定义了一个类型为Node的常量l,并将当前的最后一个元素last赋给l,此时l就指的是当前链表的最后一个元素
         *final Node<E> newNode = new Node<>(l, e, null);    //创建了一个节点newNode，并为其添加元素。前指针指向l，后指针指向null，节点的数据为e
         *last = newNode;    //newNode作为最后一个节点last
         *if (l == null)    //如果l为空
         *first = newNode;    //newNode作为当前链表的第一个节点
         *     else
         *l.next = newNode;    //newNode作为当前链表的最后一个节点
         *size++;    //链表的容量加一
         *modCount++;    //链表修改值加一
         *}
         *
         */
        System.out.println(linkedList);
        //增加add
        LinkedList ll = new LinkedList();
        ll.add(123);
        ll.add(1);
        ll.add(new Student("dz",28));
        ll.add("一朵花");
        //ll.addAll(linkedList);//将linkedList链表添加进来
        ll.addAll(2,linkedList);//将linkedList链表添加在首位
        System.out.println(ll);
        //删除
        //ll.remove();//从左往右删除，调用一次remove，删除一个数据
        //ll.removeAll(linkedList);//删除链表
        //ll.remove(new Integer(1));//删除数据1，由于直接传1，会默认index=1，而不是object对象是1
        //ll.remove(1);//删除索引为1的数据
        System.out.println(ll);
        //改
        ll.set(1,"好好学习");
        System.out.println(ll);
        //查
        Object first = ll.getFirst();
        System.out.println(first);
        Object last = ll.getLast();
        System.out.println(last);
        Object o = ll.get(1);
        System.out.println(o);
        System.out.println("========1.迭代遍历===========");
        Iterator iterator = ll.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("========2.增强版for循环==========");
        for (Object object : ll){
            System.out.println(object);
        }
        System.out.println("======3.for==========");
        for (int i=0;i<ll.size();i++){
            System.out.println(ll.get(i));
        }
    }
}
