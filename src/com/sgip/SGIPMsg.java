package com.sgip;

import java.util.List;

import com.sgip.body.SGIPCommand;
import com.sgip.body.command.Submit;
import com.sgip.constant.SGIPConstant;
import com.sgip.factory.SGIPFactory;
import com.sgip.head.SGIPMsgHead;
import com.sgip.interf.SGIPByteData;
import com.sgip.util.SGIPUtils;

public class SGIPMsg implements SGIPByteData{

	private SGIPMsgHead head;
	
	private SGIPCommand command;
	
	public SGIPMsgHead getHead()
	{
		return head;
	}

	public void setHead(SGIPMsgHead head)
	{
		this.head = head;
	}

	public SGIPCommand getCommand()
	{
		return command;
	}

	public void setCommand(SGIPCommand command)
	{
		this.command = command;
	}

	private void calcute()
	{
		long messageLength = this.command.getCommandLength() + SGIPMsgHead.HEAD_LENGTH;
		this.head.setMessageLength(messageLength);
	}

	public byte[] getByteData()
	{
		byte[] commandBytes = command.getByteData();
		calcute();
		return SGIPUtils.mergeBytes(head.getByteData(),commandBytes);
	}
	
	public void setUserNumbers(List<String> listUserNumber,String messageContent)
	{
		if(head == null || command == null || head.getCommandId() !=  SGIPConstant.SGIP_SUBMIT)
		{
			return;
		}
		Submit sub = (Submit)command; 
		sub.setListUserNumber(listUserNumber);
		sub.setMessageContent(messageContent);
	}
	public void setLongUserNumbers(List<String> listUserNumber,byte [] messageContentByte)
	{
		if(head == null || command == null || head.getCommandId() !=  SGIPConstant.SGIP_SUBMIT)
		{
			return;
		}
		Submit sub = (Submit)command; 
		sub.setListUserNumber(listUserNumber);
		//sub.setMessageContent(messageContent);
		//sub.setTpPid(0x01);
		sub.setTpUdhi(0x01);
		sub.setMessageCoding((byte)8);
		sub.setMessageContentByte(messageContentByte);
		command =sub;
		
	}

	private void initHead(byte[] source)
	{
		head = new SGIPMsgHead();
		byte[] headByte = new byte[SGIPMsgHead.HEAD_LENGTH];
		SGIPUtils.copyBytes(source, headByte, 1, SGIPMsgHead.HEAD_LENGTH, 1);
		head.initPropertiesByBytes(headByte);
	}
	
	private void initCommand(byte[] source) throws Exception
	{
		if(head == null || head.getCommandId() == null)
		{
			return;
		}
		long commandId = head.getCommandId();
		command = SGIPFactory.getCommandByCommandId(commandId);

		byte[] commandByte = new byte[source.length - SGIPMsgHead.HEAD_LENGTH];
		SGIPUtils.copyBytes(source, commandByte, SGIPMsgHead.HEAD_LENGTH+1, commandByte.length, 1);
		command.initPropertiesByBytes(commandByte);
	}
	
	public void initPropertiesByBytes(byte[] source)
	{
		initHead(source);
		try
		{
			initCommand(source);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public String toString()
	{
		return "SGIPMsg [head=" + head + ", command=" + command + "]";
	}
}
