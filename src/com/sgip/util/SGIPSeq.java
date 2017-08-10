package com.sgip.util;
/**
 * 命令循环序号 产生类
 * @author zzqiang
 *
 */
public class SGIPSeq {

	private static long MIN_SEQ = 0;
	
	private static long MAX_SEQ = Integer.MAX_VALUE;
	
	private static long CUR_SEQ = MIN_SEQ;
	
	public static synchronized long getSeq()
	{
		if(CUR_SEQ == MAX_SEQ)
		{
			CUR_SEQ = MIN_SEQ;
		}
		return CUR_SEQ++;
	}
	
}
