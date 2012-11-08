package com.neeta.validation;

public class Validation
{
	public static boolean isAlphabet(String test)
	{
		return (test.matches("[a-zA-Z]*"));
	}

	public static boolean isAlphabetWithSpace(String test)
	{
		return (test.matches("[a-z A-Z]*"));
	}

	public static boolean isNumber(String test)
	{
		return (test.matches("\\d*"));
	}

	public static boolean isRealNumber(String test)
	{
		return (test.matches("\\d*[.]\\d*"));
	}
	
	
	public static boolean isTime24(String test)
	{
		return (test.matches("^([0-9]|0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]$"));
	}
	public static boolean isJsp(String test)
	{
		return (test.matches(".*\\.jsp"));
	}
	
public static void main(String[] args)
{
System.out.println(Validation.isTime24("-1:22"));
}
}