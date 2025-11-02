package com.javaweb.Utils;

public class NumberUtil {
	public static boolean isNumber(String string) {
		try {
			Long number=Long.parseLong(string);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
}
