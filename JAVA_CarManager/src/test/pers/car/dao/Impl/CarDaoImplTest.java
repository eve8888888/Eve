package test.pers.car.dao.Impl; 

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After;
import pers.car.dao.ICarDao;
import pers.car.dao.Impl.CarDaoImpl;
import pers.car.entity.Car;

/** 
* CarDaoImpl Tester. 
* 
* @author <Authors name> 
* @since <pre>十二月 17, 2018</pre> 
* @version 1.0 
*/ 
public class CarDaoImplTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: addCar() 
* 
*/ 
@Test
public void testAddCar() throws Exception { 
//TODO: Test goes here...
    ICarDao iCarDao = new CarDaoImpl();

//    Car car = new Car(
//            2,"斯柯达",
//            "红色",null,
//            11200.2,"car.png","car");
//    iCarDao.addCar(car);
    Car car3 = new Car(
            3,"斯柯达777",
            "黑色",null,
            11200.2,"car.png","car");
    iCarDao.addCar(car3);
}
} 
