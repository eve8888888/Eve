package pers;

import javax.xml.crypto.Data;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * @Author: Eve
 * @Date: 2018/12/2 10:09
 * @Version 1.0
 */

interface Interface1 {}
interface Interface2 {}
class A {}
class B extends A implements Interface1,Interface2 {}
class Person {
    public String name;
    public int age;

    public Person(){}
    protected Person(String name) { }
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
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
}

public class Test {
    public static void main(String[] args) throws Exception {
//        Class<?> cls = pers.B.class;
//        System.out.println(cls.getSuperclass());
//
//        Class<?>[] cls2 = cls.getInterfaces();
//        for (Class c :
//                cls2) {
//            System.out.println(c);
//        }

        Class<?> clazz = Person.class;
        System.out.println(clazz.getConstructor());
        System.out.println(clazz.getDeclaredConstructor());
//        System.out.println(clazz.getDeclaredConstructor());
//        System.out.println(clazz.getDeclaredConstructor(String.class));
//        System.out.println(clazz.getConstructor(String.class,int.class));
//        System.out.println("================================================");
//        Constructor<?>[] constructors = Person.class.getConstructors();
//        for (Constructor c :
//                constructors) {
//            System.out.println(c);
//        }
//        System.out.println("================================================");
//
//        Constructor<?>[] cs = Person.class.getDeclaredConstructors();
//        for (Constructor c :
//                cs) {
//            System.out.println(c);
//        }
        //Person person = Person.class.getDeclaredConstructor(String.class,int.class).newInstance("z",10);


//        Class<Person> cls = Person.class;
//        String set = "set"+initCap(args[0]);
//        String get = "get"+initCap(args[0]);
//        Method setNameMethod = cls.getMethod(set, String.class);
//        Method getNameMethod = cls.getMethod(get);
//        Person person = cls.newInstance();
//        setNameMethod.invoke(person,"张三");
//        System.out.println(getNameMethod.invoke(person));
//
//        /**
//         * 普通属性
//         */
//        Field field = cls.getField("age");
//        field.set(person,10);
//        System.out.println(field.get(person));
    }
    public static String  initCap(String s){
        return s.substring(0,1).toUpperCase() + s.substring(1);
    }
}
