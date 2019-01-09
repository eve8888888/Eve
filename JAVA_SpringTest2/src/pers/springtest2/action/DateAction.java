package pers.springtest2.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pers.springtest2.entity.User;

/**
 * @Author: Eve
 * @Date: 2019/1/2 15:45
 * @Version 1.0
 */
@Controller
public class DateAction {
    @RequestMapping(value = "/date.action",method = RequestMethod.PUT)
    public String date(User user){
        System.out.println(user);
        return "date.html";
    }
}
