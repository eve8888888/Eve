package pers.bean;

/**
 * @Author: Eve
 * @Date: 2018/12/3 16:04
 * @Version 1.0
 */
//用户表
public class User {

    // `u_id` VARCHAR(50),
    // `u_pwd` VARCHAR(50) COMMENT '密码',
    // `u_name` VARCHAR(50) COMMENT '姓名',
    // `u_phone` VARCHAR(20) COMMENT '电话',
    // `u_address` VARCHAR(20) COMMENT '地址',
    // `u_status` VARCHAR(2) DEFAULT '1' COMMENT '用户身份',

    String u_id;
    String u_pwd;
    String u_name;
    String u_phone;
    String u_address;
    String u_status;

    public User() {
        super();
    }

    public User(String u_id, String u_pwd, String u_name,String u_phone, String u_address, String u_status) {
        super();
        this.u_id = u_id;
        this.u_pwd = u_pwd;
        this.u_name = u_name;
        this.u_phone = u_phone;
        this.u_address = u_address;
        this.u_status = u_status;
    }

    public String getU_id() {
        return u_id;
    }

    public void setU_id(String u_id) {
        this.u_id = u_id;
    }

    public String getU_pwd() {
        return u_pwd;
    }

    public void setU_pwd(String u_pwd) {
        this.u_pwd = u_pwd;
    }

    public String getU_name() {
        return u_name;
    }

    public void setU_name(String u_name) {
        this.u_name = u_name;
    }

    public String getU_phone() {
        return u_phone;
    }

    public void setU_phone(String u_phone) {
        this.u_phone = u_phone;
    }

    public String getU_address() {
        return u_address;
    }

    public void setU_address(String u_address) {
        this.u_address = u_address;
    }

    public String getU_status() {
        return u_status;
    }

    public void setU_status(String u_status) {
        this.u_status = u_status;
    }

    @Override
    public String toString() {
        return "User [u_id=" + u_id + ", u_pwd=" + u_pwd + ", u_name=" + u_name + ", u_phone=" + u_phone
                + ", u_address=" + u_address + ", u_status=" + u_status + "]";
    }
}

