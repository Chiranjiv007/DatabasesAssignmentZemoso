/*
@author:- Chiranjiv Goyal

A java function that will ping any host ( given as input ) 
and computes the median of the time taken to ping.

Used the system ping utility, not any deprecated methods.
*/

package Assignment3;

import java.net.InetAddress;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.GregorianCalendar;
import java.lang.StringBuffer;

public class SendPingtoIP
{
    public long[] SendPingRequest(String IpAddress) throws Exception 
    {
        System.out.println("Sending Ping Request to " + IpAddress);

        long[] TimeList = new long[11];
        
        for (int i = 0; i < 11; i++) 
        {
            long finish = 0;
            long start = new GregorianCalendar().getTimeInMillis();
            
            if (isreachable(IpAddress)) 
            {
                finish = new GregorianCalendar().getTimeInMillis();
            } 
            else 
            {
                System.out.println("Can not reach the Address");
                break;
            }
            
            TimeList[i] = (finish - start);
        }

        return TimeList;
    }

    private boolean isreachable(String ip) throws Exception 
    {
        String url;
        StringBuffer echo = new StringBuffer();
        url = "ping " + ip;
        
        try 
        {
            Process p = Runtime.getRuntime().exec(url);
            BufferedReader inputStream = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String s = "";

            while ((s = inputStream.readLine()) != null) 
            {

                if (s.contains("Packets: Sent") || s.contains("bytes of data")) 
                {
                    return true;
                }
                
                echo.append(s + '\n');
            }

            return false;
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
            return false;
        }
    }

    
}
