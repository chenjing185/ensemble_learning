package com.etc.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FileDownloadServlet")
public class FileDownloadServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /*
         * 解决下载 你的名字.txt时乱码的问题
         */
        //1.获取下载文件的名称
        String filename=request.getParameter("fileName");

        filename=new String(filename.getBytes("ISO8859-1"),"UTF-8");
        //*告诉客户端这个文件不是解析 而是以附件的形式下载
        response.setHeader("Content-Disposition", "attachment;filename="+filename);
        //2.获取文件的绝对路径
        String path="E:\\img\\"+filename;
        //3.获得该文件的输入流
        InputStream in=new FileInputStream(path);
        //获得输出流---通过response获得的输出流  用于向客户端写内容
        ServletOutputStream out=response.getOutputStream();
        //拷贝文件
        int len=0;
        byte [] buffer=new byte[1024];

        while((len=in.read(buffer))>0) {
            out.write(buffer, 0, len);
        }
        in.close();
        out.close();
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
