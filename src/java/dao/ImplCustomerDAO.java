/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Customer;

/**
 *
 * @author student
 */
class ImplCustomerDAO implements CustomerDAO{
    private Map<String, Customer> customers = new java.util.concurrent.ConcurrentSkipListMap<>();
    
    public ImplCustomerDAO(String path){
        Path p = Paths.get(path);
        try {
            List<String> lines = Files.readAllLines(p);
            for(String line : lines){
                String[] data = line.split(",");
                Customer customer = new Customer(data[0],data[1],data[2],data[3],data[4]);
                customers.put(customer.getCustomerId(), customer);
            }
        } catch (IOException ex) {           
        }
        
    }

    @Override
    public List<Customer> getAllCustomer() {
        return new ArrayList<Customer>(customers.values());
    }

}
