package com.nacre.pms.test;


public class MailTest {

	


  

	public static void main(String[] args) {
		
		String [] mailSender= {"k.akhilakavya@gmail.com","sibajikhatai200@gmail.com"};
		
		for(int i=0;i<mailSender.length;i++)
		{
		
		EmailUtil.sendMail(mailSender[i],"Good Afternoon","<h1 style='color:red'>hi testing message</h1>");
		}
	}

}
