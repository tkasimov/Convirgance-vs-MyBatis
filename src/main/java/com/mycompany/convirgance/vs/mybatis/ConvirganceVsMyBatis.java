/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.convirgance.vs.mybatis;




import java.util.List;
import java.io.IOException;
import java.io.InputStream;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.*;





/**
 *
 * @author timur
 */
public class ConvirganceVsMyBatis 
{
    public static void main(String[] args) throws IOException
    {
        // get SQLSessionFacotyr
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        
        SqlSession session = sessionFactory.openSession();
//        
        List<Customer> customers = session.selectList("com.mycompany.convirgance.vs.mybatis.CustomerMapper.getAll");
    }
}
