package com.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Key {
	public static byte[] GenerateAuthenticatorClient(String clientid,
			String key, String timestamp) throws NoSuchAlgorithmException {
		int sharekeylen = 0;
		if (key != null) {
			sharekeylen = clientid.length() + key.length() + 17;
		} else {
			sharekeylen = clientid.length() + 17;
		}
		byte tmpbuf[] = new byte[sharekeylen];
		int tmploc = 0;
		System.arraycopy(clientid.getBytes(), 0, tmpbuf, 0, clientid.length());
		tmploc = clientid.length() + 7;
		if (key != null) {
			System.arraycopy(key.getBytes(), 0, tmpbuf, tmploc, key.length());
			tmploc += key.length();
		}

		System.arraycopy((FormatTimeStamp(timestamp)).getBytes(), 0, tmpbuf, tmploc, 10);
		return MD5(tmpbuf);
	}

	private static String FormatTimeStamp(String timestampstr){
		String tmpstr=timestampstr;
		if (timestampstr.length()<10){
			for(int i=0;i<10-timestampstr.length();i++){
				tmpstr = "0" + tmpstr;
			}
		}
		return tmpstr;
	}
	public static byte[] GenerateAuthenticatorServer(int status,
			byte[] authenticatorClient, String sharekey)
			throws NoSuchAlgorithmException {
		byte[] keybyte = sharekey.getBytes();
		byte[] buf = new byte[authenticatorClient.length + 4 + keybyte.length];
		TypeConvert.int2byte(status, buf, 0);
		System.arraycopy(authenticatorClient, 0, buf, 4,
				authenticatorClient.length);
		System.arraycopy(keybyte, 0, buf, 4 + authenticatorClient.length,
				keybyte.length);
		return MD5(buf);
	}
	
	public static boolean checkAuth(byte [] authenticatorclient,String account,String password,String timestamp) {

		try {
			String clientstr =Hex.rhex(authenticatorclient);
			String serverstr = Hex.rhex(GenerateAuthenticatorClient(account, password,timestamp));
			  if (clientstr.equals(serverstr)){
					return true;
				} else {
					return false;
				}
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			return false;
		}


	}

	private static byte[] MD5(byte[] sourecebuf)
			throws NoSuchAlgorithmException {
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		md5.reset();
		md5.update(sourecebuf);
		return md5.digest();

	}
	
	
	//字符串 md5
	public static String Md5Str(String string){
		char hexDigits[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};       
        try {
        	
        	byte[] btInput = string.getBytes("utf-8");
            //byte[] btInput = string.getBytes();
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
		
		
	}
public static void main(String[] args){
    	
    	System.out.println(Md5Str("000000"));
    	
    }
	
}
