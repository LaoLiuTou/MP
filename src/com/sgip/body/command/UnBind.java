package com.sgip.body.command;

import com.sgip.body.SGIPCommand;

public class UnBind extends SGIPCommand {

	private static final int COMMAND_LENGTH = 0;
	
	public UnBind()
	{
		super();
		this.commandLength = COMMAND_LENGTH;
	}
	
	@Override
	public byte[] getByteData()
	{
		return new byte[this.commandLength];
	}
	
}
