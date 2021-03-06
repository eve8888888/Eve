package com.server;

import com.bean.Student;
import com.service.StudentServer;
import org.junit.Test;

import java.util.Scanner;

public class StudentServerTest {

    private StudentServer ss = new StudentServer();

    @Test
    public void addStudent() {
        Student s = new Student(15,"����","�Ͼ�");
        ss.addStudent(s);
    }

    @Test
    public void delStudent() {
        ss.delStudent(15);
    }

    @Test
    public void updateStudent() {
        ss.updateStudent(10,"���");
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
        Scanner scanner = new Scanner(System.in);
        System.out.println("input:");
        int i = scanner.nextInt();
        int j = scanner.nextInt();
//        int i = 2;
//        int j = 8;
        for (Object s:
                ss.find(i,j)) {
            System.out.println(s);
        }
    }
}