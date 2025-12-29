package com.tcs;

public class Palindrome 
{
    public static void main(String[] args) 
    {
        String m = "madam";
        String rev ="";

        for (int i = m.length() - 1; i >= 0; i--) 
        {
            rev+=m.charAt(i);
        }

        if (m.equals(rev)) 
        {
            System.out.println("Palindrome");
        } else 
        {
            System.out.println("Not a Palindrome");
        }
    }
}
