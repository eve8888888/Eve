package com.server;

import com.bean.Student;
import com.dao.DBdao;

import java.util.List;

/**
 * @Author: Eve
 * @Date: 2018/11/30 15:37
 * @Version 1.0
 */
public class StudentServer {
    DBdao db = new DBdao();
    public void addStudent(Student s){
        db.update("insert into dept values("+s.getDeptno()+",'"+s.getDname()+"','"+s.getLoc()+"')");
    }
    public void delStudent(int i){
        db.update("delete from dept where deptno = "+i+"");
    }
    public void updataStudent(int s,String str){
        db.update("update dept set loc = '"+str+"' where deptno = "+s+"");
    }
    public Student selectStudent(int i){
        return (Student) db.findById("select * from dept where deptno = "+i+"");
    }
    public List<Student> findAll(){
        return db.findAll("select * from dept");
    }
    public int count(){
        return db.count("select count(*) from dept");
    }
    public List<Student> find(int i,int j){
        return db.findAll("select * from dept limit "+i+","+j+"");
    }
}
