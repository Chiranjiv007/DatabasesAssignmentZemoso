package app;

import java.util.Date;

public class LogEntry 
{
    private String ipAddress;
    private Date accessTime;
    private String request;
    private int statusCode;
    private int bytesReturned;

    public LogEntry(String ip, Date date, String req, int sc, int br)
    {
        ipAddress = ip;
        accessTime = date;
        request = req;
        statusCode = sc;
        bytesReturned = br;
    }

    public String getipAddress()
    {
        return ipAddress;
    }

    public Date getAccessTime()
    {
        return accessTime;
    }

    public String getRequest()
    {
        return request;
    }

    public int getStatusCode()
    {
        return statusCode;
    }

    public int getBytesReturned()
    {
        return bytesReturned;
    }

    @Override
    public String toString()
    {
        return ipAddress + " " +accessTime + " " + request + " " + statusCode+ " " + bytesReturned;
    } 
    
}