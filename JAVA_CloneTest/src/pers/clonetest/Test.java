package pers.clonetest;

import java.io.*;

/**
 * @Author: Eve
 * @Date: 2019/1/3 20:00
 * @Version 1.0
 */

class Teacher implements Cloneable{
    String name;
    String job;

    public Teacher(String name, String job) {
        this.name = name;
        this.job = job;
    }
    public Teacher clone(){
        Teacher teacher = null;
        try {
            teacher = (Teacher)super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return teacher;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

//    @Override
//    public String toString() {
//        return "Teacher{" +
//                "name='" + name + '\'' +
//                ", job='" + job + '\'' +
//                '}';
//    }
}

class Student implements Cloneable{
    private String name;
    private Integer age;
    private Teacher teacher;
    public Student(){}
    public Student(String name, Integer age, Teacher teacher) {
        this.name = name;
        this.age = age;
        this.teacher = teacher;
    }
    public Student clone(){
        Student s = new Student();
        s.setAge(this.age);
        s.setName(this.name);
        s.setTeacher(teacher.clone());
        return s;
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

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

//    @Override
//    public String toString() {
//        return "Student{" +
//                "name='" + name + '\'' +
//                ", age=" + age +
//                ", teacher=" + teacher +
//                '}';
//    }
}
public class Test {
    public static void main(String[] args) {
        Teacher teacher = new Teacher("A","Math");
        Student student = new Student("Tom",20,teacher);
        Student studentClone = student.clone();

        System.out.println(student);
        System.out.println(studentClone);
        System.out.println("========");

        System.out.println(teacher == studentClone.getTeacher());
    }
}

//class Teacher implements Serializable {
//    String name;
//    String job;
//
//    public Teacher(String name, String job) {
//        this.name = name;
//        this.job = job;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getJob() {
//        return job;
//    }
//
//    public void setJob(String job) {
//        this.job = job;
//    }
//
////    @Override
////    public String toString() {
////        return "Teacher{" +
////                "name='" + name + '\'' +
////                ", job='" + job + '\'' +
////                '}';
////    }
//}
//
//class Student implements Serializable{
//    String name;
//    Integer age;
//    Teacher teacher;
//
//    public Student(String name, Integer age, Teacher teacher) {
//        this.name = name;
//        this.age = age;
//        this.teacher = teacher;
//    }
//
//    public String getName() {
//        return name;
//    }
//    public Student cloneObject()throws Exception{
//        ByteArrayOutputStream bos = new ByteArrayOutputStream();
//        ObjectOutputStream oos = new ObjectOutputStream(bos);
//        oos.writeObject(this);
//        oos.close();
//        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
//        ObjectInputStream ois = new ObjectInputStream(bis);
//        return (Student)ois.readObject();
//    }
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public Integer getAge() {
//        return age;
//    }
//
//    public void setAge(Integer age) {
//        this.age = age;
//    }
//
//    public Teacher getTeacher() {
//        return teacher;
//    }
//
//    public void setTeacher(Teacher teacher) {
//        this.teacher = teacher;
//    }
//
////    @Override
////    public String toString() {
////        return "Student{" +
////                "name='" + name + '\'' +
////                ", age=" + age +
////                ", teacher=" + teacher +
////                '}';
////    }
//}
//class Test{
//    public static void main(String[] args) throws Exception{
//        Teacher teacher = new Teacher("A","Math teacher");
//        Student student = new Student("Tom",20,teacher);
//        Student studentClone = student.cloneObject();
//        System.out.println(student);
//        System.out.println(studentClone);
//        System.out.println(teacher == studentClone.getTeacher());
//    }
//}