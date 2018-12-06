package com.demo;

import com.service.StudentServer;

import java.util.Scanner;

/**
 * @Author: Eve
 * @Date: 2018/11/30 18:37
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        StudentServer ss = new StudentServer();
        System.out.println("input");
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        int j = scanner.nextInt();
        for (Object s:
                ss.find(i,j)) {
            System.out.println(s);
        }
    }
}
