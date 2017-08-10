package com.sgip.listener;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.Logger;

import com.sgip.server.SGIPServer;

public class SGIPServiceListener extends HttpServlet {

	private static final String VALUE_YES = "Y";
	
	private static final long	serialVersionUID	= 1L;

	private static Logger	logger	= Logger.getLogger(SGIPServiceListener.class);
	
	@Override
	public void init() throws ServletException
	{
		
		try
		{
			String start = getInitParameter("start");
			String nio = getInitParameter("nio");
			logger.debug("************* sgip service start param = " + start + ";nio=" + nio);
			if (VALUE_YES.equalsIgnoreCase(start))
			{
				if(VALUE_YES.equalsIgnoreCase(nio))
				{
					SGIPServer.getInstance().startNIOSGIPService();
				}else
				{
					SGIPServer.getInstance().startSGIPService();
				}
			}
		} catch (Exception e)
		{
			logger.error(e);
		}
	}
}
