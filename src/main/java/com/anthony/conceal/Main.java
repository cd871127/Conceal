package com.anthony.conceal;

import com.anthony.conceal.service.CommonService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

/**
 * Created by chendong239 on 2016-12-27.
 */
public class Main extends HttpServlet {
    private static CommonService commonService;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
    }

    public static void main(String[] args) {
//        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:config/spring-mybatis.xml");
//        commonService = ctx.getBean(CommonService.class);
//
//        Map<String, Map<String, String>> m = commonService.getDictMapByColumnName(new ArrayList<String>(Arrays.asList("data_state", "account_type")));
//        System.out.println(m);
        System.out.println("123");
//        http://www.mycodes.net/154/8985.htm
//        http://datatables.club/upgrade/1.10-convert.html
    }
}
