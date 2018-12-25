package pers.car.action.car;

import com.google.gson.Gson;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Eve
 * @Date: 2018/12/20 9:15
 * @Version 1.0
 */
@WebServlet("/upload.action")
public class UploadAction extends HttpServlet {
    static FileItem file;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DiskFileItemFactory dfi = new DiskFileItemFactory();
        ServletFileUpload sfu = new ServletFileUpload(dfi);
        try {
            List<FileItem> items = sfu.parseRequest(req);
            file = items.get(0);
            String path = this.getServletContext().getResource("upload").getPath();
            System.out.println(path);
            InputStream in = file.getInputStream();
            OutputStream out = new FileOutputStream(path+file.getName());
            byte[] buffer = new byte[2048];
            while (in.read(buffer)!=-1){
                out.write(buffer);
            }
            Gson gson = new Gson();
            Map<String,String> map = new HashMap<>();
            map.put("fileName",file.getName());
            resp.getWriter().write(gson.toJson(map));
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
    }
    public static String getFileName(){
        return file.getName();
    }
}
