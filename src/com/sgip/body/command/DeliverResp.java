package com.sgip.body.command;

import com.sgip.body.SGIPCommand;
import com.sgip.util.SGIPUtils;

public class DeliverResp extends SGIPCommand {

	private static final int COMMAND_LENGTH = 9;
	
	private int result;
	
	private byte[] reserve = new byte[8];
	
	private byte[] resultByte = new byte[1];

	public int getResult()
	{
		return result;
	}

	public void setResult(int result)
	{
		this.result = result;
	}

	public DeliverResp(int result)
	{
		super();
		this.result = result;
		this.commandLength = COMMAND_LENGTH;
	}
	
	public DeliverResp()
	{
		this(0);
	}
	
	@Override
	public byte[] getByteData()
	{
		this.resultByte = SGIPUtils.convertInt2Bytes(this.result);
		return SGIPUtils.mergeBytes(this.resultByte,this.reserve);
	}
	
	
}
