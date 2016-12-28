package com.anthony.conceal;

import com.anthony.conceal.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by chendong239 on 2016-12-27.
 */
public class Main extends HttpServlet{
    @Autowired
    private static UserMapper userMapper;
    @Override
    public void doGet(HttpServletRequest request,HttpServletResponse response)
    {
        System.out.println(userMapper.userLogin("cd871127"));
    }

    public static void main(String[] args) {
        ApplicationContext ctx=new ClassPathXmlApplicationContext("classpath:config/applicationContext.xml");
        Test t=ctx.getBean(Test.class);
        t.print();
    }
}
