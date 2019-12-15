package edu.fx.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author zd
 * @version v1.0
 * @2019 12 14 15 42
 */
public class StreamDemo {

    public static void main(String[] args) {
        /**
         * 1.实例化
         *      方式：通过集合、数组、Stream.of()实例化流
         */
        System.out.println("===1.通过集合===========================");
        Student s1 = new Student("zhangsan", 20);
        Student s2 = new Student("lisi", 25);
        Student s3 = new Student("ww", 30);
        ArrayList<Student> studentList = new ArrayList<>();
        studentList.add(s1);
        studentList.add(s2);
        studentList.add(s3);
//        studentList.stream().forEach(System.out::println);//通过集合:顺序流
        studentList.parallelStream().forEach(System.out::println);//通过集合：并行流

        System.out.println("===2.通过数组===========================");
/*        List arrayList = new ArrayList();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);*/
        List<Integer> arrayList = Arrays.asList(3,5,4,1,2,3);//与上面相等
        long count = arrayList.stream().count();//通过数组
        System.out.println(count);
        System.out.println("===3.通过Stream.of()===========================");
        ArrayList<Student> students = new ArrayList<>();
        System.out.println(Stream.of(students));
        System.out.println("===4.通过迭代、无限流===========================");
        Stream.iterate(0,dz->dz+2).limit(3).forEach(System.out::println);
        Stream.generate(Math::random).limit(3).forEach(System.out::println);
        System.out.println("================实例化结束===========================");
        System.out.println("================中间操作===========================");
        /**
         * 中间操作：
         *      1.筛选与切片
         *      2.映射
         *      3.排序
         */
        System.out.println("================1.筛选与切片===========================");
        studentList.stream().filter(s->s.getAge()==25).forEach(System.out::println);//过滤
        studentList.stream().limit(2).forEach(System.out::println);//前2名
        studentList.stream().distinct().forEach(System.out::println);//去重
        studentList.stream().skip(2).forEach(System.out::println);//去掉前2名取剩下的部分
        System.out.println("================2.映射===========================");
        //返回学生姓名长度大于3的学生名字
        studentList.stream().map(sl->sl.getName()).filter(sn->sn.length()>3).forEach(System.out::println);
        System.out.println("================映射:map===========================");
        //方式一：将strings中的数据遍历循环放在一个字符数组中
        List<String> strings = Arrays.asList("dz", "say", ":", "I", "love", "you", "!");
        Stream<Stream<Character>> streamStream = strings.stream().map(StreamDemo::fromStingToStream);
        streamStream.forEach(s->{
            s.forEach(System.out::println);
        });
        System.out.println("================映射:flatMap===========================");
        strings.stream().flatMap(StreamDemo::fromStingToStream).forEach(System.out::println);
        System.out.println("================3.排序===========================");
        arrayList.stream().sorted().forEach(System.out::println);
//        studentList.stream().sorted().forEach(System.out::println);//这样会报错
        //类对象排序必须要先制定排序规则
        studentList.stream().sorted( (c1,c2)->Integer.compare(c1.getAge(),c2.getAge())).forEach(System.out::println);
        System.out.println("================中间操作结束===========================");
        System.out.println("================结束操作===========================");
        //返回 是否所有的age都等于25
        System.out.println(studentList.stream().allMatch(s -> s.getAge() == 25));
        //返回 是否存在有一个age等于25
        System.out.println(studentList.stream().anyMatch(s -> s.getAge() == 25));
        //返回 是不是没找到age等于25的
        System.out.println(studentList.stream().noneMatch(s -> s.getAge() == 25));
        //返回 当前流的第一个元素
        System.out.println(studentList.stream().findFirst());
        //返回 任意一个对象
        System.out.println(studentList.stream().findAny());//顺序流
        System.out.println(studentList.parallelStream().findAny());//并行流
        //统计流中的个数
        System.out.println(strings.stream().count());
        //返回集合中age中最大的年龄
        System.out.println(studentList.stream().map(s -> s.getAge()).max(Integer::compareTo));
        System.out.println(studentList.stream().map(s -> s.getAge()).min(Integer::compareTo));
        //归约---相当于合并
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        //求数组中的合计数
        System.out.println(integers.stream().reduce(0, Integer::sum));
        //收集
        //查找年龄大于24的学生，并返回一个list集合
        System.out.println(studentList.stream().filter(s -> s.getAge() > 24).collect(Collectors.toList()));

    }
    private static Stream<Character> fromStingToStream(String s) {
        ArrayList<Character> chList = new ArrayList<>();
        for (Character c : s.toCharArray()) {
            chList.add(c);
        }
        return chList.stream();
    }
}
