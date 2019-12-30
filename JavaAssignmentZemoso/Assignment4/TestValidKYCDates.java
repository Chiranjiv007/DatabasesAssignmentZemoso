/*
@author:- Chiranjiv Goyal

The KYC form can be filled only for the closest anniversary in the past or within 30 days range in future.

Input - First line is an integer n as the number of inputs to be passed. 
        Next, n lines are n input for the program in the format dd-mm-yyyy dd-mm-yyyy    
        Each line has two dates separated by space where the first date in signup date 
        and the second date is the current date.  

Output - Range of dates for KYC form in format   dd-mm-yyyy dd-mm-yyyy
*/

package Assignment4;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import Assignment4.ValidKYCDates;

public class TestValidKYCDates
{
    public static void main(String[] args) throws IOException 
    {
        int N;
        try
        {
            ValidKYCDates dates = new ValidKYCDates();
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            N = Integer.parseInt(br.readLine());
        
            for (int i = 0; i < N; i++) 
            {
                String data;
                data = br.readLine();
                dates.GetKYCDate(data);
            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}