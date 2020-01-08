package edu.fx.jihe;

import java.util.Objects;

/**
 * @author: Pxn
 * @date: 2019/12/25 18:07
 */
public class Student  implements Comparable{
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age &&
                Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Student){//判断对象的类型是否是学生
            Student student=(Student) o;
            if (this.age>student.age){
                return 1;
            }else if(this.age<student.age){
                return -1;
            }else {
                return -this.name.compareTo(student.name);
            }
        }else{
            throw new RuntimeException("不是该学生类型对象！");
        }
    }
}
