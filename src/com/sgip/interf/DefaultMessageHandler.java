package com.sgip.interf;

import org.apache.log4j.Logger;

import com.sgip.body.command.Deliver;
import com.sgip.body.command.Report;
import com.sgip.body.command.Submit;
import com.sgip.head.SGIPMsgHead;
import com.sgip.server.ConnectSocketHandler;

public class DefaultMessageHandler implements MessageHandler {

	private static Logger logger = Logger.getLogger(DefaultMessageHandler.class);
	
	public void handleDeliverMessage(SGIPMsgHead head ,Deliver deliver)
	{
		logger.debug("handle message recieve sgipMsgHead is " + head + " deliver detail:" + deliver);
		
		
	}

	public void handleReportMessage(SGIPMsgHead head ,Report report)
	{
		logger.debug("handle message recieve sgipMsgHead is " + head + " report detail:" + report);
		
		
	}
	
	public void handleSubmitMessage(SGIPMsgHead head, Submit submit)
	{
		logger.debug("handle message send sgipMsgHead is " + head + " submit detail:" + submit);
	}

}
