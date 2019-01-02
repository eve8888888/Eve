package pers.springone.entity;

/**
 * @Author: Eve
 * @Date: 2019/1/2 9:24
 * @Version 1.0
 */
public class Company {
    Person person;
    Car car;

    public Company() {
    }

    public Company(Person person, Car car) {
        this.person = person;
        this.car = car;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Company{" +
                "person=" + person +
                ", car=" + car +
                '}';
    }
}
