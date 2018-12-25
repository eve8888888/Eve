package pers;

import org.jetbrains.annotations.NotNull;

import java.net.ServerSocket;
import java.util.*;

/**
 * @Author: Eve
 * @Date: 2018/12/19 18:12
 * @Version 1.0
 */

class Person implements Comparable{
    private String name;
    private Integer age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null){
            return false;
        }else if(!(obj instanceof Person)){
            return false;
        }else {
            Person p = (Person)obj;
            return p.name.equals(this.name)&&p.age==this.age;
        }
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(@NotNull Object o) {
        if()
    }
}
//public class Test {
//    public static void main(String[] args) {
//        List<String> vector = new Vector<>();
//        vector.add("A");
//        vector.add("B");
//        vector.add("C");
//        vector.add("D");
//
//        Iterator i = vector.iterator();
//        while (i.hasNext()){
//            System.out.print(i.next()+"  ");
//        }
//        System.out.println("\n******************************");
//        ListIterator listIterator = vector.listIterator();
//        while (listIterator.hasNext()){
//            System.out.print(listIterator.next()+"  ");
//        }
//        while (listIterator.hasPrevious()){
//            System.out.print(listIterator.previous()+"  ");
//        }
//        System.out.println("\n******************************");
//        for (String s :
//                vector) {
//            System.out.print(s+"  ");
//        }
//        System.out.println("\n******************************");
//        Enumeration enumeration =  ((Vector<String>) vector).elements();
//        while (enumeration.hasMoreElements()){
//            System.out.print(enumeration.nextElement()+"  ");
//        }
//
//
//    }
//}
//class Test {
//    public static void main(String[] args) {
//        List<Person> list = new ArrayList<>();
//        Person p1 = new Person("A",10);
//        Person p2 = new Person("B",20);
//        Person p3 = new Person("C",30);
//        list.add(p1);
//        list.add(p2);
//        list.add(p3);
//        //list.remove(p1);
//        System.out.println(list.contains(p1));
//    }
//}
//class Test {
//    public static void main(String[] args) {
//        List<Person> list = new ArrayList<>();
//        list.add(new Person("A",10));
//        list.add(new Person("B",20));
//        list.add(new Person("C",30));
//        list.remove(new Person("A",10));
//        System.out.println(list);
//    }
//}
class Test{
    public static void main(String[] args) {
        Set<Person> set = new TreeSet<>();
        set.add(new Person("A",10));
        set.add(new Person("B",20));
        set.add(new Person("C",30));
        System.out.println(set);
    }
}

