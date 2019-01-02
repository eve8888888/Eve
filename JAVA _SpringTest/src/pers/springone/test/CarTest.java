package pers.springone.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import pers.springone.entity.Car;
import pers.springone.entity.Company;
import pers.springone.entity.Person;

/**
 * @Author: Eve
 * @Date: 2019/1/2 9:38
 * @Version 1.0
 */
public class CarTest {
    public static void main(String[] args) {
        ApplicationContext app =
                new FileSystemXmlApplicationContext("src/applicationContext.xml");
//        Car car = app.getBean("maikailun",Car.class);
        Company p = app.getBean("company", Company.class);
        System.out.println(p);
    }
}
