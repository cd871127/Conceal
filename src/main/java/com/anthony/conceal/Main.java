package com.anthony.conceal;

import com.anthony.conceal.dao.CommonMapper;
import com.anthony.conceal.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by chendong239 on 2016-12-27.
 */
public class Main extends HttpServlet {
    private static CommonMapper commonMapper;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
    }

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:config/spring-mybatis.xml");
        commonMapper=ctx.getBean(CommonMapper.class);
        Map<String,String> m=commonMapper.getDictMapByColumnName("data_state");
        Map<String,String> m1=new HashMap<>();
        m1.put("123","456");
        m1.put("aaa","bbb");
        System.out.println(m1);
        System.out.println(m);
        System.out.println(m.get("1"));
        System.out.println(m.get("0"));
    }
}
