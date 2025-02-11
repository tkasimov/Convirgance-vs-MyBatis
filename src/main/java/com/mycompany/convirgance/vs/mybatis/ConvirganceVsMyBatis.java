/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.convirgance.vs.mybatis;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
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
        // close a session
        session.close();
        
        
        //export to CSV using apache    
        try (CSVPrinter printer = new CSVPrinter(new FileWriter("mybatis-example.csv"), CSVFormat.DEFAULT))
        {
            // header
            printer.printRecord("CUSTOMER_ID", "DISCOUNT_CODE", "ZIP", "NAME", 
            "ADDRESSLINE1", "ADDRESSLINE2", "CITY", "STATE", "PHONE", "FAX", 
            "EMAIL", "CREDIT_LIMIT");
            // customers
            for (Customer customer : customers)
            {
                Object[] data = {
                    customer.getCustomerID(), 
                    customer.getDiscountCode(), 
                    customer.getName(), 
                    customer.getAddressLine1(),
                    customer.getAddressLine2(),
                    customer.getCity(),
                    customer.getState(),
                    customer.getPhone(),
                    customer.getFax(), 
                    customer.getEmail(),
                    customer.getCreditLimit()};
                printer.printRecord(data);   
            }
        }
        catch (IOException e)
        {
            System.out.println("Error: " + e.getMessage());
        }
        
       
        //export to JSON usong Gson
        try (FileWriter writer = new FileWriter("mybatis-example.json"))
        {
            Gson gson = new GsonBuilder()
                    .setPrettyPrinting()
                    .create();
            
            gson.toJson(customers, writer);
        }
        catch (IOException e)
        {
            System.out.println("Error: " + e.getMessage());
        }
    }
}