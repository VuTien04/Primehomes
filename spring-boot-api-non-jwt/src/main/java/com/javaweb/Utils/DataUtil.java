package com.javaweb.Utils;

public class DataUtil {
	public static boolean check(Object string) {
		if(string != null && !string.equals("")) return true;
		return false;
	}
}
