package pers.springone.action;

import org.springframework.stereotype.Controller;
import pers.springone.service.ICarService;

import javax.annotation.Resource;

/**
 * @Author: Eve
 * @Date: 2019/1/2 9:32
 * @Version 1.0
 */
@Controller("action")
public class CarAction {

    @Resource(name = "service")
    private ICarService ics;

    public ICarService getIcs() {
        return ics;
    }

    public void setIcs(ICarService ics) {
        this.ics = ics;
    }
    public void findAll(){
        ics.findAllCar();
    }
}
