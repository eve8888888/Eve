package pers.springone.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import pers.springone.action.CarAction;
import pers.springone.entity.Car;
import pers.springone.entity.Company;
import pers.springone.entity.Person;
import pers.springone.service.ICarService;

/**
 * @Author: Eve
 * @Date: 2019/1/2 9:38
 * @Version 1.0
 */
public class CarTest {
    public static void main(String[] args) {
        ApplicationContext app =
                new FileSystemXmlApplicationContext("src\\applicationContext2.xml");
//        Car car = app.getBean("maikailun",Car.class);
//        Company p = app.getBean("company", Company.class);
//        System.out.println(p);
        //ICarService i = app.getBean("isca",ICarService.class);
        CarAction c = app.getBean("action",CarAction.class);
        c.findAll();
    }
}
