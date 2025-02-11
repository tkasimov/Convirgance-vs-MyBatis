/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.convirgance.vs.mybatis;

import com.invirgance.convirgance.dbms.DBMS;
import com.invirgance.convirgance.dbms.Query;
import com.invirgance.convirgance.json.JSONObject;
import com.invirgance.convirgance.output.CSVOutput;
import com.invirgance.convirgance.output.JSONOutput;
import com.invirgance.convirgance.target.FileTarget;
import java.io.IOException;
import org.apache.derby.jdbc.ClientDataSource;

/**
 *
 * @author timur
 */
public class ConvirganceExample
{
    public static void main(String[] args) throws IOException 
    {    
        // database source setup
        ClientDataSource source = new ClientDataSource();
        source.setDatabaseName("sample");
        source.setPassword("app");
        source.setPortNumber(1527);
        source.setServerName("localhost");
        source.setUser("app");
        
        // Here is how easy it is to work with data using Convirgance
        
        // Query the database
        DBMS database = new DBMS(source);
        Query query = new Query("SELECT * FROM CUSTOMER");
        Iterable<JSONObject> records = database.query(query);
        
        // Specify the target file
        FileTarget target = new FileTarget("convirgance-example.csv");
        
        // Write the stream to a CSV file
        new CSVOutput().write(target, records);
        
        // Write the stream to a JSON file
        target = new FileTarget("convirgance-example.json");
        JSONOutput output = new JSONOutput();
        output.write(target, records);
    }
}
