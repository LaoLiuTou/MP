package com.sgip.body.command;

import com.sgip.body.SGIPCommand;

public class UnBindResp extends SGIPCommand {

	private static final int COMMAND_LENGTH = 0;
	
	public UnBindResp()
	{
		super();
		this.commandLength = COMMAND_LENGTH;
	}
	
	@Override
	public byte[] getByteData()
	{
		return new byte[this.commandLength];
	}
	
	@Override
	public void initPropertiesByBytes(byte[] source)
	{
		
	}
}
