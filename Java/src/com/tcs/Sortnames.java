package com.tcs;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Sortnames {
   public static void main(String[] args)
   {
	   Scanner sc=new Scanner(System.in);
	   System.out.println("Enter the words in list:");
	   List<String> word=new ArrayList<>();
	   String s=sc.nextLine().trim();
	   if (!s.isEmpty()) 
	   {
           String[] parts = s.split("\\s+");
           word.addAll(Arrays.asList(parts));
       }
	   Collections.sort(word);
	   for(String words:word)
	   System.out.println(words);
	   sc.close();
   }
}
