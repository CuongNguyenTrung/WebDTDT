package com.c2code.realproject.utils;

import java.math.BigInteger;

public class MoneyUtils {

	public static String money(BigInteger money) {
		StringBuilder stringBuilder = new StringBuilder(money.toString());
		int i = stringBuilder.length();
		while(i - 3 > 0) {
			stringBuilder.insert(i - 3, '.');
			i -= 3;
		}
		stringBuilder.append("đ");
		return stringBuilder.toString();
	}
	public static void main(String[] args) {
		System.out.println(MoneyUtils.money(new BigInteger("2000")));
	}
}
