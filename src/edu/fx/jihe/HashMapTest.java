package edu.fx.jihe;

import java.util.*;

/**
 * @author: Pxn
 * @date: 2019/12/28 19:59
 */
public class HashMapTest {
    public static void main(String[] args) {
        //testHashMap();
        //testTreeMap
        //testTreeMap1();
        testTreeMap2();

    }

    private static void testTreeMap2() {
        //排序规则：定制排序
        Map<Person,String> tp = new TreeMap<Person,String>(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                if (o1 instanceof Person && o2 instanceof Person) {
                    Person p1 = (Person) o1;
                    Person p2 = (Person) o2;
                    return Integer.compare(p1.getAge(), p2.getAge());
                }
                 throw new RuntimeException("类型不匹配！");
            }
        });
        Person p4 = new Person("I", 4);
        Person p5 = new Person("Love", 2);
        Person p6 = new Person("Dz", 3);
        tp.put(p4,"One");
        tp.put(p5,"Two");
        tp.put(p6,"Three");
        //遍历输出：按照定制排序（TreeMap只能对key进行排序）
        Set<Map.Entry<Person, String>> entries = tp.entrySet();
        Iterator iterator2 = entries.iterator();
        while (iterator2.hasNext()){
            Object entry = iterator2.next();
            Map.Entry e=(Map.Entry)entry;//得到每个键值对
            System.out.println(e.getKey()+"===》"+e.getValue());//通过键值对得到key和value
        }
    }

    private static void testTreeMap1() {
        //***************TreeMap的排序规则：只能key排序，不能按照value排序************************
        Person s1 = new Person("nana", 24);
        Person s2 = new Person("nn", 21);
        Person s3 = new Person("dz", 38);
        Map<Person,String> treeMap = new TreeMap<Person,String>();
        treeMap.put(s1,"u1");
        treeMap.put(s2,"u2");
        treeMap.put(s3,"u3");
        //遍历输出：按照自然排序
        Set<Map.Entry<Person,String>> entries = treeMap.entrySet();//方法2：entrySet()
        Iterator iterator1 = entries.iterator();
        while (iterator1.hasNext()){
            Object entry = iterator1.next();
            Map.Entry e=(Map.Entry)entry;//得到每个键值对
            System.out.println(e.getKey()+"===》"+e.getValue());//通过键值对得到key和value
        }
    }

    private static void testHashMap() {
        HashMap hashMap = new HashMap();
        HashMap hashMap1 = new HashMap();
        //增
        Student s1 = new Student("dz", 28);
        Student s2 = new Student("pxn", 27);
        Student s3 = new Student("dz1", 28);
        Student s4 = new Student("pxn", 27);
        hashMap.put("user1",s1);
        hashMap.put("user2",s2);
        hashMap1.put("user3",s3);
        hashMap1.put("user2",s4);//key是无序且不重复；
        hashMap.putAll(hashMap1);
        System.out.println(hashMap);
        //删除
        //Object user1Value = hashMap.remove("user1");
        //System.out.println(user1Value);
        //System.out.println(hashMap.remove("user2",s2));
        //System.out.println(hashMap);
        //hashMap.clear();
        //System.out.println(hashMap.size());
        //修改
        hashMap.put("user2",s3);//key无序且不重复，value无序可以重复
        System.out.println(hashMap);
        //查
        System.out.println(hashMap.containsKey("user2"));
        System.out.println(hashMap.containsValue(s4));
        //遍历
        Set set = hashMap.keySet();//方法1：keySet()
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            Object key = iterator.next();//先得到key
            Object value = hashMap.get(key);//再得到value
            System.out.println(key+"--->"+value);
        }
        Set entrySet = hashMap.entrySet();//方法2：entrySet()
        Iterator iterator1 = entrySet.iterator();
        while (iterator1.hasNext()){
            Object entry = iterator1.next();
            Map.Entry e=(Map.Entry)entry;//得到每个键值对
            System.out.println(e.getKey()+"===》"+e.getValue());//通过键值对得到key和value
        }
    }
}
