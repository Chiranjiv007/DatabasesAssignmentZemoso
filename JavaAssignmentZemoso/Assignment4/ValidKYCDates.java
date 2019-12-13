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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;

public class ValidKYCDates 
{

    static int[] Days_in_month = {31,31,28,31,30,31,30,31,31,30,31,30,31};

    /**
     * Prints the valid KYC Deadline dates
     * @param data
     */
    public void GetKYCDate(String data) 
    {
        String[] arr = data.trim().split(" ");
        String[] Anniversary = arr[0].split("-");

        int Ann_date = Integer.parseInt(Anniversary[0]);
        int Ann_month = Integer.parseInt(Anniversary[1]);
        int Ann_year = Integer.parseInt(Anniversary[2]);

        String[] Current = arr[1].split("-");
        int curr_date = Integer.parseInt(Current[0]);
        int curr_month = Integer.parseInt(Current[1]);
        int curr_year = Integer.parseInt(Current[2]);

        if(curr_year == Ann_year)
        {
            System.out.println("No range");
            return;
        }

        getRange(Ann_date,Ann_month,curr_year,curr_date,curr_month);
    }


    
    public  static  void getRange(int date, int month, int year,int curr_date,int curr_month)
    {
        if(year%4==0)
        {
            Days_in_month[2] = 29;
        }

        int date_before = (date>30)? 1 : (date-30)+Days_in_month[month-1];
        int month_before = (date>30)?month:month-1;
        int year_before = year;
        
        if(month_before == 0)
        {
        	month_before = 12;
        	year_before = year-1;
        }

        int date_after = (date==1 && Days_in_month[month]>30)? date = 31: (date+30)-Days_in_month[month];
        int month_after = (date==1 && Days_in_month[month]>30)? month: month+1;
        int year_after = year;

        if(month_after == 13)
        {
        	month_after = 1;
        	year_after = year+1;
        }


        Calendar thirty_day_before = Calendar.getInstance();
        thirty_day_before.set(year_before,month_before,date_before);
        
        Calendar current_day = Calendar.getInstance();
        current_day.set(year,curr_month,curr_date);
        
        Calendar thirty_day_after = Calendar.getInstance();
        thirty_day_after.set(year_after,month_after,date_after);


        if(current_day.after(thirty_day_before) && current_day.before(thirty_day_after))
        {
        	System.out.println(date_before+"-"+month_before+"-"+year_before+" "+curr_date+"-"+curr_month+"-"+year);
        	return;
        }
        else
        {
        	System.out.println(date_before+"-"+month_before+"-"+year_before+" "+date_after+"-"+month_after+"-"+year_after);
        	return;
        }        
    }
}
