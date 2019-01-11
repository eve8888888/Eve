package com.springong.service.Impl;

import com.springone.App;
import com.springone.service.IMovieService;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class MovieServiceImplTest {
    @Resource
    private IMovieService ims;
    @org.junit.Test
    public void findAllMovies() {
        System.out.println(ims.findAllMovies());
    }
}