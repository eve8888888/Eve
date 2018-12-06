package pers;

/**
 * @Author: Eve
 * @Date: 2018/12/2 15:41
 * @Version 1.0
 */
public class Emp {
    private String name;
    private String job;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return "name "+name +"\t\t"+"job " + job;
    }

}
