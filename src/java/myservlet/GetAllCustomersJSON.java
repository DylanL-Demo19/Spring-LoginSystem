/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myservlet;

import dao.CustomerDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Customer;
/**
 *
 * @author student
 */
@WebServlet(name = "GetAllCustomersJSON", urlPatterns = {"/GetAllCustomersJSON"})
public class GetAllCustomersJSON extends HttpServlet {
    private CustomerDAO cd;
    @Override
    public void init(){
        ServletContext sc = this.getServletContext();
        cd = (CustomerDAO)sc.getAttribute("customerDAO");
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        List<Customer> customers = cd.getAllCustomer();
        
        String json = "{\"customers\":[";
        for(Customer c : customers){
            json += c.toString() + ",";
        }
        json = json.substring(0,json.length()-1);
        json += "]}";
        
        try (PrintWriter out = response.getWriter()) {
            out.print(json);
        }
    }
}
