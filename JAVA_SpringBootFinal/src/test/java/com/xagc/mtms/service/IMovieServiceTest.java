package com.xagc.mtms.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
@RunWith(SpringRunner.class)
@SpringBootTest
public class IMovieServiceTest {
    @Resource
    private IMovieService iMovieService;
    @Test
    public void findDirectors() {
        System.out.println(iMovieService.findDirectors());
    }

    @Test
    public void deleteDirector() {
        iMovieService.deleteDirector("2");
    }
}