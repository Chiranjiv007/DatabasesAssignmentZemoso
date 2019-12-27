package Assignment3;

import java.util.Arrays;
import java.util.Scanner;
import Assignment3.SendPingtoIP;;



public class TestSendPingToIP
{
    public static void main(String[] args) throws Exception 
    {
        SendPingtoIP request = new SendPingtoIP();
        String IP = getString("Enter the IP Address: ");
        
        long[] TimeList = request.SendPingRequest(IP);
        
        double median = getMedian(TimeList);
        System.out.println("Median: " + median + " ms");

    }

    public static String getString(String CALL_FOR_VAR) throws Exception
    {
        System.out.println(CALL_FOR_VAR);
        
        String str = "";
        Scanner sc = new Scanner(System.in);
        str = sc.nextLine();
        sc.close();
        
        return str;
    }

    public static double getMedian(long[] array) throws Exception
    {
        Arrays.sort(array);
        double median;
        median = (double) array[array.length / 2];
        return median;
    }
}