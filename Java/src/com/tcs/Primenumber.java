package com.tcs;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Primenumber {
  public static void main(String [] args)
  {
	  Scanner sc=new Scanner(System.in);
	  System.out.println("Enter starting number");
	  int n=sc.nextInt();
	  System.out.println("Enter ending number");
	  int m=sc.nextInt();
	  List<Integer> arr=new ArrayList<>();
	  List<Integer> prime=new ArrayList<>();
	  for(int i=n;i<=m;i++)
	  {
		  arr.add(i); 
	  }
	  System.out.println(arr);
	  for(int j=0;j<arr.size()-1;j++)
	  {
		  int c=arr.get(j);
		  for(int p=c;p<=arr.get(j+1);p++)
		  {
		      if(c%p!=0)
		      {
			    prime.add(p);
		      }  
		  }
	  }
	  System.out.println(prime);
	  sc.close();
  }
}
