///*fix the problem
//**The web application [ROOT] appears to have started a thread named [Abandoned connection cleanup thread] but has failed to stop it. This is very likely to create a memory leak. Stack trace of thread:
//**        java.lang.Object.wait(Native Method)
//**        java.lang.ref.ReferenceQueue.remove(ReferenceQueue.java:143)
//**        com.mysql.jdbc.AbandonedConnectionCleanupThread.run(AbandonedConnectionCleanupThread.java:43)
//*/
//package com.anthony.conceal.common;
//
//import com.mysql.cj.jdbc.AbandonedConnectionCleanupThread;
//
//import javax.servlet.ServletContextEvent;
//import javax.servlet.ServletContextListener;
//import javax.servlet.annotation.WebListener;
//import java.sql.Driver;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import java.util.Enumeration;
//
///**
// * Created by Anthony on 2016/12/27.
// */
//@WebListener
//public class ContextFinalizer implements ServletContextListener {
//
//    public void contextInitialized(ServletContextEvent sce) {
//    }
//
//    public void contextDestroyed(ServletContextEvent sce) {
//        Enumeration<Driver> drivers = DriverManager.getDrivers();
//        Driver d = null;
//        while (drivers.hasMoreElements()) {
//            try {
//                d = drivers.nextElement();
//                DriverManager.deregisterDriver(d);
//                System.out.println(String.format("ContextFinalizer:Driver %s deregistered", d));
//            } catch (SQLException ex) {
//                System.out.println(String.format("ContextFinalizer:Error deregistering driver %s", d) + ":" + ex);
//            }
//        }
//        try {
//            AbandonedConnectionCleanupThread.shutdown();
//        } catch (InterruptedException e) {
//            System.out.println("ContextFinalizer:SEVERE problem cleaning up: " + e.getMessage());
//            e.printStackTrace();
//        }
//    }
//}