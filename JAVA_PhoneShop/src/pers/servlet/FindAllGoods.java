package pers.servlet;

import pers.bean.Goods;
import pers.service.GoodsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Author: Eve
 * @Date: 2018/12/3 16:29
 * @Version 1.0
 */
@WebServlet("/FindAllGoods")
public class FindAllGoods extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //创建GoodsService
        GoodsService gs = new GoodsService();
        List<Goods> listGoods = gs.findAll();
        System.out.println("listGoods--->"+listGoods.size());
        //存到请求域中
        request.setAttribute("listGoods", listGoods);
        //跳转到页面
        request.getRequestDispatcher("GoodsList.jsp").forward(request, response);

    }

}
