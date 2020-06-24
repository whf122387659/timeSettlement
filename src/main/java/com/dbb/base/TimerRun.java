package com.dbb.base;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class TimerRun implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("定时开启");
        new TimerManager();
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
