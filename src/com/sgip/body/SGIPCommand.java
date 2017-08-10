package com.sgip.body;

import com.sgip.interf.SGIPByteData;

public class SGIPCommand implements SGIPByteData {
	
	protected int commandLength;
	
	public int getCommandLength()
	{
		return commandLength;
	}
	
	public void setCommandLength(int commandLength)
	{
		this.commandLength = commandLength;
	}

	public byte[] getByteData()
	{
		return new byte[]{};
	}

	public void initPropertiesByBytes(byte[] source)
	{
		
	}

}
