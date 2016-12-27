package com.anthony.conceal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by chendong239 on 2016-12-27.
 */
@WebServlet(name="123",urlPatterns = "/1234")
public class Main extends HttpServlet {
    public static void main(String[] args) {
        System.out.println("123");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
        System.out.println("vvv");
        System.out.println("vsv");
    }
}
