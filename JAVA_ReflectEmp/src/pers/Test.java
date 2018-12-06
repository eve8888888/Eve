package pers;

/**
 * @Author: Eve
 * @Date: 2018/12/2 15:41
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) throws Exception{
        String str = "emp.name:zzz|emp.job:bbb";
        EmpAction empAction = new EmpAction();
        empAction.setEmpValue(str);
        System.out.println(empAction.getEmp());
    }
}
