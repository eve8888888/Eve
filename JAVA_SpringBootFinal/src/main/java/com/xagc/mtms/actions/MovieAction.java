package com.xagc.mtms.actions;

import com.xagc.mtms.entity.Director;
import com.xagc.mtms.service.IMovieService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: Eve
 * @Date: 2019/1/11 9:25
 * @Version 1.0
 */
@Controller
public class MovieAction {
    @Resource
    private IMovieService ims;
    //对导游的全查询
    @RequestMapping("/findDirectors.action")
    public @ResponseBody List<Director> findDirector(){
        return ims.findDirectors();
    }

    @RequestMapping("/addDirector.action")
    public @ResponseBody String addDirector(Director director){
        ims.saveDirector(director);
        return "添加成功";
    }
    @RequestMapping("/updateDirector.action")
    public @ResponseBody String updateDirector(Director director){
        ims.updateDirector(director);
        return "修改成功";
    }

    @RequestMapping("/deleteDirector.action")
    public @ResponseBody String deleteDirector(String ids){
        ims.deleteDirector(ids);
        return "删除成功";
    }
    @RequestMapping("/findDirectorsByLikenameOrdesc.action")
    public @ResponseBody List<Director>
    findDirectorsByLikenameOrdesc(String name,String desc){
        return ims.findDirectorByLikeNameOrDesc(name,desc);
    }
}
