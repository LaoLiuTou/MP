package com.smgp;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.sgip.server.ConnectSocketHandler;
import com.sgip.server.SGIPServer;

/**
 * 接口调用
 *
 */
public class SGMPActivityTimer extends QuartzJobBean{
	/**
	 * 短信接口长链接，定时进行链路检查
	 */
	protected void executeInternal(JobExecutionContext arg0)throws JobExecutionException {
			System.out.println("×××××××××××××SGMP开始链路检查××××××××××××××");
			//SGIPServer.getInstance().startSGIPService();
			
			new Thread( ).start();
			System.out.println("×××××××××××××SGMP链路检查结束××××××××××××××");
	}
}
