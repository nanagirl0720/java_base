package edu.fx.classes;

import edu.fx.jihe.Student;

import java.util.*;

/**
 * @author: Pxn
 * @date: 2020/1/7 21:03
 */
public class ComparableString {
    public static void main(String[] args) {
        //自然排序
        String[] strings={"RR","QQ","BB","MM","KK","ZZ","AA"};
        Arrays.sort(strings);
        System.out.println(Arrays.toString(strings));

        Student s1 = new Student("dz", 23);
        Student s2 = new Student("nana", 18);
        Student s3 = new Student("pxn", 29);
        List<Student> students = new ArrayList<Student>();
        students.add(s1);
        students.add(s2);
        students.add(s3);
        Collections.sort(students);
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
