package com.bean;

/**
 * @Author: Eve
 * @Date: 2018/11/29 15:52
 * @Version 1.0
 */
public class Student {
    private int sid;
    private String sname;
    private String address;

    public Student(int sid, String sname, String address) {
        this.sid = sid;
        this.sname = sname;
        this.address = address;
    }
    public int getSid() {
        return sid;
    }

    public String getSname() {
        return sname;
    }

    public String getAddress() {
        return address;
    }
    @Override
    public String toString() {
        return sid + "\t\t" + sname + "\t\t" + address + "\t\t";
    }
}
