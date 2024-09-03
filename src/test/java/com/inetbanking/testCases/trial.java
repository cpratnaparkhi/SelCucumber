package com.inetbanking.testCases;

import java.security.SecureRandom;

import org.apache.commons.lang3.RandomStringUtils;

public class trial 
{
	public static void main(String[] args) 
	{
		System.out.println(data());
	}
	public static String data() 
	{
		SecureRandom random = new SecureRandom();
		String id = RandomStringUtils.random(5, 0, 0, true, true, null, random);
		return id;
	}
}