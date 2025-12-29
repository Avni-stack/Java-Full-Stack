package com.tcs;

public class Digitrootcalculator {
 public static void main(String[] args)
 {
	 int num=987;
	 int sum=0;
	 int sum1=0;
	 while(num>0)
	 {
		 int digit=num%10;
		 sum+=digit;
		 num=num/10;
	 }
	 while(sum>0)
	 {
		 int digit1=sum%10;
		 sum1+=digit1;
		 sum=sum/10;
	 }
	 System.out.println(sum1);
 }
}
