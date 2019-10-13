/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myservlet;

import dao.CustomerDAO;
import dao.CustomerDAOFactory;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "GetAndSetCustomerDAO", urlPatterns = {"/GetAndSetCustomerDAO"},loadOnStartup = 2)
public class GetAndSetCustomerDAO extends HttpServlet {
     CustomerDAO cd;
    @Override
    public void init() throws ServletException {
        ServletContext sc = this.getServletContext();
        String path = sc.getRealPath("/WEB-INF/CustomerDatas.yung");
        cd = CustomerDAOFactory.getCustomerDAO(path);
        sc.setAttribute("customerDAO", cd);
    }        
}
