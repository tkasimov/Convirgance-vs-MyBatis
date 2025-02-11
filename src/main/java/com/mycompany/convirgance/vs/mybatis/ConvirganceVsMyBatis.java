/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.convirgance.vs.mybatis;

import java.io.FileWriter;
import java.util.List;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.session.SqlSession;


/**
 *
 * @author timur
 */
public class ConvirganceVsMyBatis 
{
    public static void main(String[] args) throws IOException
    {
        // get SQLSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // create a session
        SqlSession session = sessionFactory.openSession();
        // record customers
        List<Customer> customers = session.selectList("com.mycompany.convirgance.vs.mybatis.CustomerMapper.getAll");
        
        
        //export to CSV
        CSVPrinter printer = new CSVPrinter(new FileWriter("customer.csv"), CSVFormat.DEFAULT);
        // header
        printer.printRecord("Customer_id", "Discount_code", "Zip", "Name", 
        "Addressline1", "Addressline2", "City", "State", "Phone", "Fax", 
        "Email", "Credit_limit");
        
        for (Customer customer : customers)
        {
            Object[] data = 
            {
                String.valueOf(customer.getCustomer_id()), 
                customer.getDiscount_code(), 
                customer.getName(), 
                customer.getAddressline1(),
                customer.getAddressline2(),
                customer.getCity(),
                customer.getState(),
                customer.getPhone(),
                customer.getFax(), 
                customer.getEmail(),
                customer.getCredit_limit() 
            };
            printer.printRecord(data);   
        }
        printer.flush();
        
        //export to JSON
        
        
        // close a session
        session.close();
    }
}
