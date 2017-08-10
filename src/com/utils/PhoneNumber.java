package com.utils;

public class PhoneNumber {

	public static int matchesPhoneNumber(String phone_number) {

		/**
		 * 手机号码: 13[0-9], 14[5,7], 15[0, 1, 2, 3, 5, 6, 7, 8, 9], 17[6, 7, 8],
		 * 18[0-9], 170[0-9] 移动号段:
		 * 134,135,136,137,138,139,150,151,152,157,158,159
		 * ,182,183,184,187,188,147,178,1705 联通号段:
		 * 130,131,132,155,156,185,186,145,176,1709 电信号段:
		 * 133,153,180,181,189,177,1700
		 */
		String MOBILE = "^1(3[0-9]|4[57]|5[0-35-9]|8[0-9]|70)\\d{8}$";
		/**
		 * 中国移动：China Mobile
		 * 134,135,136,137,138,139,150,151,152,157,158,159,182,
		 * 183,184,187,188,147,178,1705
		 */
		String CM = "(^1(3[4-9]|4[7]|5[0-27-9]|7[8]|8[2-478])\\d{8}$)|(^1705\\d{7}$)";
		/**
		 * 中国联通：China Unicom 130,131,132,155,156,185,186,145,176,1709
		 */
		String CU = "(^1(3[0-2]|4[5]|5[56]|7[6]|8[56])\\d{8}$)|(^1709\\d{7}$)";
		/**
		 * 中国电信：China Telecom 133,153,180,181,189,177,1700
		 */
		String CT = "(^1(33|53|70|73|77|8[019])\\d{8}$)";

		int flag = 0;
		if (phone_number.matches(CM)) {
			flag = 1;
		} else if (phone_number.matches(CU)) {
			flag = 2;
		} else if (phone_number.matches(CT)) {
			flag = 3;
		} else {
			flag = 4;
		}
		return flag;

	}
	
	public static void main(String[] args){
		String number="15143003268";
		
		
		System.out.println(matchesPhoneNumber(number));
		
	}
}
