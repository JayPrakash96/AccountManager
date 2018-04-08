package myAccount.controller;

public class Reverse {


boolean checkPalindrome(String inputString) {
	 StringBuffer sb=new StringBuffer(inputString);
	 String s=sb.reverse().toString();
	 if(s==inputString)
	 return true;
	 else
	  return false; }

public static void main(String arg[]) { 
	String s="rar";
 Reverse obj = new Reverse();
 obj.checkPalindrome(s);

	}}

