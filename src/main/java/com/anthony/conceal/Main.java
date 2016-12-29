package com.anthony.conceal;

import com.anthony.conceal.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by chendong239 on 2016-12-27.
 */
public class Main extends HttpServlet{
    @Autowired
    private static UserMapper userMapper;
    @Override
    public void doGet(HttpServletRequest request,HttpServletResponse response)
    {
    }

    public static void main(String[] args) {
        ApplicationContext ctx=new ClassPathXmlApplicationContext("classpath:config/applicationContext.xml");
        Test t=ctx.getBean(Test.class);
        t.print();
    }
}
