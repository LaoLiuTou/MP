package com.mp.utils;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Timer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;

import com.smgp.server.Server;
import com.smgp.server.ServerHandleConnect;
 

public class ContextListener implements ServletContextListener {

	 Timer timer = new Timer() ; 
	 

    public void contextInitialized(ServletContextEvent event) { 
        timer = new java.util.Timer(true);  
        
        //参数
   	 	Properties properties = new Properties();
		String base = getClass().getResource("/")
				.getPath();
		try {
			properties.load(new FileInputStream(base
					+ "properties/key.properties"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   
		
		int period=Integer.parseInt(properties.getProperty("period").trim());
		String retry=properties.getProperty("retry").trim();
   	
        
        event.getServletContext().log("定时器已启动"); 
        System.out.println("定时器已启动");
        timer.schedule(new MyTask(event.getServletContext(),retry), period,10000);  
        timer.schedule(new CodeTask(event.getServletContext(),retry), 5000,10000); 
        
       // event.getServletContext().log("已经添加任务调度表");  

    } 
    public void contextDestroyed(ServletContextEvent event) { 
        timer.cancel(); 
        event.getServletContext().log("定时器以销毁"); 
    } 
}
