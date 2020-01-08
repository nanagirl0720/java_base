package edu.fx.classes;

import edu.fx.jihe.Student;

import java.util.*;

/**
 * @author: Pxn
 * @date: 2020/1/8 17:22
 */
public class ComparatorStudent {
    public static void main(String[] args) {
        //定制排序
        List<Student> arrayList = new ArrayList<>();
        arrayList.add(new Student("dz",28));
        arrayList.add(new Student("nana",18));
        arrayList.add(new Student("gg",34));
        Collections.sort(arrayList, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                //判断是否是学生类型
                if (o1 instanceof Student && o2 instanceof Student){
                    Student s1=(Student)o1;
                    Student s2=(Student)o2;
                    //定制排序规则
                    if(s1.getAge()>s2.getAge()){
                        return 1;
                    }else  if (s1.getAge()<s2.getAge()){
                        return -1;
                    }else {
                        return -s1.getName().compareTo(s2.getName());
                    }
                }else {
                    throw new RuntimeException("类型不匹配！");
                }
            }
        });
        Iterator<Student> iterator = arrayList.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
