package test.pers.car.dao.Impl; 

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After;
import pers.car.dao.ICarDao;
import pers.car.dao.Impl.CarDaoImpl;
import pers.car.entity.Car;
import pers.car.service.ICarService;
import pers.car.service.Impl.CarServiceImpl;

import java.util.List;

/** 
* CarDaoImpl Tester. 
* 
* @author <Authors name> 
* @since <pre>Ê®¶þÔÂ 17, 2018</pre> 
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
    ICarService i = new CarServiceImpl();
    System.out.println(i.findAllCar());
}
} 
