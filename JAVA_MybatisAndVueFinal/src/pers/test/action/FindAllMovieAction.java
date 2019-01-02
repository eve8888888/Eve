package pers.test.action;

import com.google.gson.Gson;
import pers.test.entity.Movie;
import pers.test.service.IMovieService;
import pers.test.service.Impl.MovieServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Author: Eve
 * @Date: 2018/12/30 14:02
 * @Version 1.0
 */
@WebServlet("/findAllMovie.action")
public class FindAllMovieAction extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IMovieService i = new MovieServiceImpl();
        List<Movie> list = i.findAllMovie();
        Gson gson = new Gson();
        resp.getWriter().print(gson.toJson(list));
    }
}
