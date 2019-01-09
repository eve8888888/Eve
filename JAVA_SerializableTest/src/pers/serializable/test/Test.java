package pers.serializable.test;

import java.io.*;

/**
 * @Author: Eve
 * @Date: 2019/1/3 19:40
 * @Version 1.0
 */
class Person implements Serializable {
    private String name;
    private transient Integer age;

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
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
public class Test {
    public static void main(String[] args) throws Exception{
        File file = new File("C:\\Users\\Eve\\Desktop\\test.txt");

//        Person p = new Person("Tom",20);
//        FileOutputStream fileOutputStream = new FileOutputStream(file);
//        ObjectOutputStream oos = new ObjectOutputStream(fileOutputStream);
//        oos.writeObject(p);
//        oos.close();

        FileInputStream fileInputStream = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fileInputStream);
        Person p = (Person)ois.readObject();
        System.out.println(p);
        ois.close();
    }
}
