package pers;

import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Field;
import java.net.ServerSocket;
import java.util.*;

/**
 * @Author: Eve
 * @Date: 2018/12/19 18:12
 * @Version 1.0
 */

class Person{
    private String name;
    private Integer age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
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
//class comparePerson implements Comparator{
//
//    @Override
//    public int compare(Object o1, Object o2) {
//        Person p1 = (Person) o1;
//        Person p2 = (Person) o2;
//        if(p1.getAge()>p2.getAge()){
//            return 1;
//        }else if(p1.getAge()<p2.getAge()){
//            return -1;
//        }
//        return p1.getName().compareTo(p2.getName());
//    }
//}
//class Test{
//    public static void main(String[] args) {
//        Set<Person> set = new TreeSet<>(new comparePerson());
//        set.add(new Person("C",10));
//        set.add(new Person("B",20));
//        set.add(new Person("A",30));
//        System.out.println(set);
//    }
//}
//class Test{
//    public static void main(String[] args) {
//        List<String> list = new ArrayList<>();
//        Collections.addAll(list,"A","B","C","D","E");
//        ListIterator listIterator = list.listIterator();
//        while (listIterator.hasNext()){
//            System.out.print(listIterator.next()+",");
//        }
//        System.out.println("\n*************************");
//        while (listIterator.hasPrevious()){
//            System.out.print(listIterator.previous()+",");
//        }
//    }
//}
//class Test{
//    public static void main(String[] args) {
//        List<String> vector = new Vector<>();
//        Collections.addAll(vector,"A","B","C","D","E");
//        Enumeration enumeration = ((Vector<String>) vector).elements();
//        while (enumeration.hasMoreElements()){
//            System.out.print(enumeration.nextElement() + ",");
//        }
//    }
//}
//class Test{
////    public static void main(String[] args) {
////        Set<String> set = new HashSet<>();
////        Collections.addAll(set,"A","B","C","D","E");
////        for (String s :
////                set) {
////            System.out.print(s+",");
////        }
////    }
////}
class Test{
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        String a = "Hello";
//        String b = "Hello";
//        String c = new String("Hello");
        System.out.println("修改前的值");
        System.out.println("a = "+a);
//        System.out.println("b = "+b);
//        System.out.println("c = "+c);
        Field a_ = String.class.getDeclaredField("value");
        a_.setAccessible(true);
        char[] value = (char[])a_.get(a);
        value[2] = '_';
        System.out.println("a = " + a);
        //System.out.println("b = " + b);
        System.out.println("Hello");
        //System.out.println("c = " + c);
    }
}
