package pers;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class Person {
    private String name;
    private int age;
    public Person(){}
    public Person(String name) {}
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
//    public String getName() { return name; }
//    protected void setName(String name) { this.name = name; }
//    private int getAge() { return age; }
//    public void setAge(int age) { this.age = age; }
}
public class Test {
    public static void main(String[] args) throws Exception{

//        Person p = new Person();
//        Method[] methods = cls.getMethods();
//        for (Method m :
//                methods) {
//            System.out.println(m);
//        }
//        System.out.println("=============================");
//        Method[] methods2 = cls.getDeclaredMethods();
//        for (Method m :
//                methods2) {
//            System.out.println(m);
//        }
//        Method m = cls.getMethod("getName");
//        System.out.println(m.invoke(new Person()));
//        Person p = new Person();
//        Field field = cls.getField("name");
//        field.set(p,"张三");
//        System.out.println(field.get(p));
        Class cls = Person.class;
        Person p = new Person("Tom",22);
        Field field = cls.getDeclaredField("name");
        field.setAccessible(true);
        System.out.println(field.get(p));
    }
}
