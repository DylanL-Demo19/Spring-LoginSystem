/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author student
 */
@WebServlet(name = "CheckName", urlPatterns = {"/CheckName"})
public class CheckName extends HttpServlet {
    private ConcurrentSkipListMap<String, String> allNamePassword; 
    @Override
    public void init(){
            ServletContext sc = getServletContext();
            allNamePassword = (ConcurrentSkipListMap)sc.getAttribute("allNamePassword");
    }    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter pw = resp.getWriter();
        String name = req.getParameter("name");
        if(allNamePassword.get(name)!= null){
            pw.print("1");
            req.getSession().setAttribute("name", name);
        }else{
            pw.print("-1");
        }
    }

}
