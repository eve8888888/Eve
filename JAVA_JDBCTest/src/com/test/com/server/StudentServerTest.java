package com.server;

import com.bean.Student;
import org.junit.Test;

import java.util.Scanner;

import static org.junit.Assert.*;

public class StudentServerTest {

    private StudentServer ss = new StudentServer();

    @Test
    public void addStudent() {
        Student s = new Student(15,"¶­Õê","ÄÏ¾©");
        ss.addStudent(s);
    }

    @Test
    public void delStudent() {
        ss.delStudent(15);
    }

    @Test
    public void updateStudent() {
        ss.updateStudent(10,"Ìì½ò");
    }

    @Test
    public void selectStudent() {
        System.out.println(ss.selectStudent(10));
    }
    @Test
    public void findAll() {
        for (Object s:
                ss.findAll()) {
            System.out.println(s);
        }
    }

    @Test
    public void count() {
        System.out.println(ss.count());
    }

    @Test
    public void find() {
        System.out.println("input:");
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        int j = scanner.nextInt();
        for (Object s:
                ss.find(i,j)) {
            System.out.println(s);
        }
    }
}