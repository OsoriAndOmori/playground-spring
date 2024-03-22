package com.osori.servlet;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.startup.Tomcat;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

@SpringBootApplication
public class ApplicationServletApplication {

    public static void main(String[] args) throws LifecycleException {
        run(ApplicationServletApplication.class, args);
    }

    public static void run(Class config, String[] args) throws LifecycleException {
        Tomcat tomcat = new Tomcat();
        Connector connector = new Connector();
        connector.setPort(8080);
        tomcat.setConnector(connector);
        Context context = tomcat.addContext("", "/");

        tomcat.addServlet("", "testServlet", new TestServlet());
        context.addServletMappingDecoded("/test", "testServlet");

        AnnotationConfigWebApplicationContext ac = new AnnotationConfigWebApplicationContext();
        ac.register(config);
        DispatcherServlet dispatcherServlet = new DispatcherServlet(ac);

        tomcat.addServlet("", "dispatcherServlet", dispatcherServlet);
        context.addServletMappingDecoded("/", "dispatcherServlet");

        tomcat.start();
    }

}
