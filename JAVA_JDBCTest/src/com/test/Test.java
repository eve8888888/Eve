import com.bean.Student;
import com.server.StudentServer;

import java.util.Scanner;

/**
 * @Author: Eve
 * @Date: 2018/11/30 15:36
 * @Version 1.0
 */
public class Test {
    StudentServer ss = new StudentServer();
    @org.junit.Test
    public void add(){
        Student s = new Student(11,"张华","南京");
        ss.addStudent(s);
    }
    @org.junit.Test
    public void del(){
        ss.delStudent(11);
    }
    @org.junit.Test
    public void update(){
        ss.updataStudent(10,"天津");
    }
    @org.junit.Test
    public void findById(){
        System.out.println(ss.selectStudent(10));
    }
    @org.junit.Test
    public void findAll(){
        for (Student s:
                ss.findAll()) {
            System.out.println(s);
        }
    }
    @org.junit.Test
    public void count(){
        System.out.println(ss.count());
    }
    @org.junit.Test
    public void find(){
        System.out.println("input:");
        int i = 0,j = 0;
        Scanner scanner = new Scanner(System.in);
        i = scanner.nextInt();
        j = scanner.nextInt();
        System.out.println(i + j);
        for (Student s:
                ss.find(i,j)) {
            System.out.println(s);
        }
    }
}
