package com.sgip.body.command;

import com.sgip.body.SGIPCommand;
import com.sgip.util.SGIPUtils;

public class ReportResp extends SGIPCommand {

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

	private void calcute()
	{
		this.resultByte =  SGIPUtils.convertInt2Bytes(this.result);
	}
	
	public ReportResp()
	{
		this(0);
	}
	
	public ReportResp(int result)
	{
		super();
		this.result = result;
		this.commandLength = COMMAND_LENGTH;
	}
	
	@Override
	public byte[] getByteData()
	{
		calcute();
		//不需要发送Delivery
		return SGIPUtils.mergeBytes(this.resultByte,this.reserve);
	}
	
	
}
