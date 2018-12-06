package pers;

/**
 * @Author: Eve
 * @Date: 2018/12/2 15:42
 * @Version 1.0
 */
public class EmpAction {
    private Emp emp = new Emp();
    public void setEmpValue(String str)throws Exception{
        BeanUtil.setValue(this,str);
    }
    public Emp getEmp(){
        return emp;
    }

}
