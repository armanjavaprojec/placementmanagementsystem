package com.nacre.pms.util;

public class NotAllowedSpecialChar {
	
	
	public static boolean checkForCharacter(String data)
	{
		boolean specialSymbolStatus=false;
		
		for(int i=0;i<data.length();i++)
		{
			
			if(data.charAt(i)>='a' && data.charAt(i)<='z')
			{
				
			}
			
			else if(data.charAt(i)>='A' && data.charAt(i)<='Z')
			{
				
			}
			else
			{
				specialSymbolStatus=true;
			}
			
			
		}
		
		return specialSymbolStatus;
	}
	

}
