/*
@author:- Chiranjiv Goyal

A vampire number v is a number with an even number of digits n, that can be factored 
into two numbers x and y each with n/2 digits and not both with trailing zeroes, 
where v contains precisely all the digits from x and from y, in any order. 
Write a java program to print first 100 vampire numbers.

*/


package Assignment6;

import java.util.*;

public class VampireNumber
{
	
	private static int numDigits(long num)
	{
		return Long.toString(Math.abs(num)).length();
	}

	private static boolean fangCheck(long num,long fang1, long fang2) throws Exception
	{
		try
		{	
			if(Long.toString(fang1).endsWith("0") && Long.toString(fang2).endsWith("0"))
			{
				return false;
			}

			int numLength = numDigits(num);

			if(numDigits(fang1) != numLength/2 || numDigits(fang2) != numLength/2)
			{
				return false;
			}

			byte[] origBytes = Long.toString(num).getBytes();
			byte[] fangBytes = (Long.toString(fang1) + Long.toString(fang2)).getBytes();
			Arrays.sort(origBytes);
			Arrays.sort(fangBytes);
			return Arrays.equals(origBytes,fangBytes);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			System.exit(1);
		}
	}


	public static void main(String[] args)
	{
		int count = 0;
		for(long i = 10; count < 100; i++)
		{
			if(numDigits(i)%2 != 0)
			{
				i = 10*i - 1;
				continue;
			}

			for (long fang1 = 2; fang1 < Math.sqrt(i) + 1; fang1++) 
			{
				if(i%fang1 == 0)
				{
					long fang2 = i/fang1;
					
					if(fangCheck(i,fang1,fang2) && fang1<=fang2)
					{
						count++;
						System.out.println("Vampire Number " + count + " : " + i);
					}
				}
			}
		}

	}
}
