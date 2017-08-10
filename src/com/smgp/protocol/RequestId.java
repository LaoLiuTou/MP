package com.smgp.protocol;

public class RequestId {
	public static int Login =          0x00000001; // �ͻ��˵�¼
	public static int Login_Resp =     0x80000001; // �ͻ��˵�¼Ӧ��
	public static int Submit =         0x00000002; // �ύ����Ϣ
	public static int Submit_Resp=     0x80000002;// �ύ����ϢӦ��
	public static int Deliver =        0x00000003;
	public static int Deliver_Resp =   0x80000003;
	public static int ActiveTest =     0x00000004;
	public static int ActiveTest_Resp= 0x80000004;
	public static int Exit =           0x00000006;
	public static int Exit_Resp =      0x80000006;
}
