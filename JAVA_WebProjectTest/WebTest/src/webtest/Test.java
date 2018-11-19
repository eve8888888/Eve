package webtest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author: Eve
 * @Date: 2018/11/16 18:12
 * @Version 1.0
 */
public class Test extends HttpServlet{
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("username");
        String ps = request.getParameter("ps");
        PrintWriter out = new PrintWriter(new FileWriter("D:\\user.txt"));
        out.println(name +"\n" + ps);
        out.close();
        System.out.print("ok");
        response.sendRedirect("reg.js");
    }
}
