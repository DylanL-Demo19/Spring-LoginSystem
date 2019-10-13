/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myservlet;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
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
 * @author Student
 */
@WebServlet(name = "LoadNamePassword", urlPatterns = {"/LoadNamePassword"}, loadOnStartup = 2)
public class LoadNamePassword extends HttpServlet {     
    final private ConcurrentSkipListMap<String, String> allNamePassword = new ConcurrentSkipListMap<>();    
    @Override
    public void init(){
        try {
            ServletContext sc = getServletContext();
            Path path = Paths.get(sc.getRealPath("/WEB-INF/namepassword.yung"));
            List<String> list;
            list = Files.readAllLines(path);
            list.forEach(s->{
                String[] datas = s.split(",");
                allNamePassword.put(datas[0],datas[1]);
            });
            sc.setAttribute("allNamePassword", allNamePassword);
        } catch (IOException ex) {
            Logger.getLogger(LoadNamePassword.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @Override
    public void destroy() {
        try {
            ServletContext sc = getServletContext();
            Path path = Paths.get(sc.getRealPath("/WEB-INF/namepassword.yung"));
            List<String> list = new ArrayList<>();
            for(String s : allNamePassword.keySet()){
                list.add(s + "," + allNamePassword.get(s));
            }
            Files.write(path, list);
        } catch (IOException ex) {
            Logger.getLogger(LoadNamePassword.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //resp.setContentType("text/plain");
        //resp.setCharacterEncoding("UTF-8");
        //PrintWriter pw = resp.getWriter();
        //pw.print(allNamePassword);
    }
    
}
