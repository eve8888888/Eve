package pers.test.test;

import org.junit.Test;
import pers.test.service.IMovieService;
import pers.test.service.ITypeService;
import pers.test.service.Impl.MovieServiceImpl;
import pers.test.service.Impl.TypeServiceImpl;

import java.io.IOException;

import static org.junit.Assert.*;

public class TypeServiceImplTest {

    @Test
    public void findAllType() throws IOException {
        IMovieService i = new MovieServiceImpl();
        System.out.println(i.findAllMovie());
    }
}