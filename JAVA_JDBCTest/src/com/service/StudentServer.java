package com.service;

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
        db.update("insert into student values("+s.getSid()+",'"+s.getSname()+"','"+s.getAddress()+"')");
    }
    public void delStudent(int i){
        db.update("delete from student where sid = "+i+"");
    }
    public void updateStudent(int s,String str){
        db.update("update student set address = '"+str+"' where sid = "+s+"");
    }
    public Student selectStudent(int i){
        return (Student) db.findById("select * from student where sid = "+i+"");
    }
    public List findAll(){
        return db.findAll("select * from student");
    }
    public int count(){
        return db.count("select count(*) from student");
    }
    public List find(int i,int j){
        return db.findAll("select * from student limit "+i+","+j+"");
    }
}
