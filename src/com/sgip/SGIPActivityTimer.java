package com.sgip;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.sgip.server.SGIPServer;

/**
 * 接口调用
 *
 */
public class SGIPActivityTimer extends QuartzJobBean{
	/**
	 * 短信接口长链接，定时进行链路检查
	 */
	protected void executeInternal(JobExecutionContext arg0)throws JobExecutionException {
			System.out.println("×××××××××××××SGIP开始链路检查××××××××××××××");
			SGIPServer.getInstance().startSGIPService();
			System.out.println("×××××××××××××SGIP链路检查结束××××××××××××××");
	}
}
