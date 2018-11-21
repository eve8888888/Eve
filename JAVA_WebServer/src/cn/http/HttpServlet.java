package cn.http;

import java.io.RandomAccessFile;
import java.net.URLDecoder;

/**
 * @Author: Eve
 * @Date: 2018/11/20 16:23
 * @Version 1.0
 */
public abstract class HttpServlet {
    public  void service(HttpRequest request, HttpResponse response){
        if(request.getMethod().equals("POST")){
            doPost(request,response);
        }else if(request.getMethod().equals("GET")){
            doGet(request,response);
        }
    }

    public void doGet(HttpRequest request, HttpResponse response) {
    }

    public void doPost(HttpRequest request, HttpResponse response) {
    }
    public void modify(String oldstr,String newstr){
        RandomAccessFile raf = null;
        try {
            raf = new RandomAccessFile("user.txt","rw");
            String line;
            long lastpoint = 0;
            System.out.println(oldstr+"*************************************1");
            while ((line = raf.readLine())!=null){
                System.out.println(oldstr+"*************************************2");
                final long point = raf.getFilePointer();
                if(line.contains(URLDecoder.decode(oldstr, "UTF-8"))){
                    System.out.println(oldstr+"*************************************3");
                    String str = line.replace(oldstr,newstr);
                    raf.seek(lastpoint);
                    raf.writeBytes(str);
                }
                lastpoint = point;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                raf.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

}
