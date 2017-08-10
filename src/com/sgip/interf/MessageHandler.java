package com.sgip.interf;

import com.sgip.body.command.Deliver;
import com.sgip.body.command.Report;
import com.sgip.body.command.Submit;
import com.sgip.head.SGIPMsgHead;

public interface MessageHandler {

	/**
	 * 处理联通发过来的消息
	 * @param deliver
	 */
	public void handleDeliverMessage(SGIPMsgHead head ,Deliver deliver);
	
	/**
	 * 处理联通发过来的消息报告
	 * @param report
	 */
	public void handleReportMessage(SGIPMsgHead head ,Report report);
	
	/**
	 * 发送给联通的
	 * @param head
	 * @param submit
	 */
	public void handleSubmitMessage(SGIPMsgHead head,Submit submit);
	
	
}
