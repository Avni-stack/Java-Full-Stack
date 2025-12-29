package com.tcs;

public class Armstrong {
	public static void main(String[] args)
	{
		int num1=153;
		int num=num1;
		int digit=0;
		int sum=0;
		while(num>0)
		{
			digit=num%10;
			sum+=digit*digit*digit;
			num=num/10;
		}
		if(num1==sum)
			System.out.println("Armstrong number");
		else
			System.out.println("not");
	}

}
