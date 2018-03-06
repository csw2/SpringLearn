package com.test.interfaces.impl;

import com.test.interfaces.WebParameter;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

/**
 * Created by Jone on 2018-03-06.
 */
public class MyWebParameter implements WebParameter {
    public void loadOnstarp(ServletContext servletContext) {
        ServletRegistration.Dynamic testSetvelt=servletContext.addServlet("test","com.test.servlet.MyServlet");
        testSetvelt.setLoadOnStartup(1);
        testSetvelt.addMapping("/test");
    }
}