package pers.springtest3.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pers.springtest3.service.IMovieService;

import javax.annotation.Resource;
import java.io.IOException;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.Map;

/**
 * @Author: Eve
 * @Date: 2019/1/3 18:33
 * @Version 1.0
 */
@Controller
public class FindAllMovieAction {
    @Resource
    private IMovieService ims;
    @RequestMapping("/findMoviesByPage.action")
    public @ResponseBody Map<String,Object> findMoviesByPage(Integer current) throws IOException {
        System.out.println("======================");
        return ims.findMoviesByPage(current,10);
    }
}
