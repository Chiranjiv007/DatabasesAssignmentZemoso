package app;

import app.WebLogParser;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import edu.duke.*;

public class LogAnalyzer {
    private static ArrayList<LogEntry> records;

    public LogAnalyzer() {
        records = new ArrayList<LogEntry>();
    }

    public static void readFile(String filename) {
        FileResource file = new FileResource(filename);
        WebLogParser LogEntryParser = new WebLogParser();

        for (String line : file.lines()) {
            LogEntry le = LogEntryParser.parseEntry(line);
            records.add(le);
        }
    }

    public int countUniqueIPs() {
        ArrayList<String> uniqueIPs = new ArrayList<String>();

        for (LogEntry le : records) {
            String ipAddress = le.getipAddress();
            if (!uniqueIPs.contains(ipAddress)) {
                uniqueIPs.add(ipAddress);
            }
        }

        return uniqueIPs.size();
    }

    public void printAllhigherThanNum(int num) {
        for (LogEntry le : records) {
            int statusCode = le.getStatusCode();
            if (statusCode >= num) {
                System.out.println(le);
            }
        }
    }

    public int countUniqueIPsInRange(int low, int high) {
        int count = 0;
        for (LogEntry le : records) {
            int statusCode = le.getStatusCode();

            if (low <= statusCode && high >= statusCode) {
                count++;
            }
        }

        return count;
    }

    public ArrayList<String> uniqueIPVisitesOnDay(String someday) {
        ArrayList<String> IPVisitesOnDay = new ArrayList<String>();
        String[] day = someday.split(" ");

        for (LogEntry le : records) {
            Date d = le.getAccessTime();
            String[] accessDate = d.toString().split(" ");

            if (day[0].equals(accessDate[1]) && day[1].equals(accessDate[2])) {
                IPVisitesOnDay.add(le.getipAddress());
            }
        }

        return IPVisitesOnDay;
    }

    public HashMap<String, Integer> countVisitperIP() {
        HashMap<String, Integer> countEachIP = new HashMap<String, Integer>();

        for (LogEntry le : records) {
            String ipAddress = le.getipAddress();

            if (countEachIP.containsKey(ipAddress)) {
                countEachIP.put(ipAddress, countEachIP.get(ipAddress) + 1);
            } else {
                countEachIP.putIfAbsent(ipAddress, 1);
            }
        }

        return countEachIP;
    }

    public int mostNumberVisitsByIP(HashMap<String, Integer> map) {
        int maxValue = -1;
        for (String ipAddress : map.keySet()) {
            if (map.get(ipAddress) > maxValue) {
                maxValue = map.get(ipAddress);
            }
        }

        return maxValue;
    }

    public ArrayList<String> iPMostVisits(HashMap<String, Integer> map) {
        int mostVisits = mostNumberVisitsByIP(map);
        ArrayList<String> mostVisitedIPs = new ArrayList<String>();

        for (String ipAddress : map.keySet()) {
            if (map.get(ipAddress) == mostVisits) {
                mostVisitedIPs.add(ipAddress);
            }
        }

        return mostVisitedIPs;
    }

    public HashMap<String, ArrayList<String>> ipForDays() {
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();

        for (LogEntry le : records) {
            String[] accessTime = le.getAccessTime().toString().split(" ");
            String date = accessTime[1] + " " + accessTime[2];

            if (map.containsKey(date)) {
                map.get(date).add(le.getipAddress());
            } else {
                map.putIfAbsent(date, null);
                map.get(date).add(le.getipAddress());
            }
        }

        return map;
    }

    public String dayWithMostIPVisiteString(HashMap<String, ArrayList<String>> map) {
        int maxSizeSoFar = -1;
        String MostVisitedDay = "";

        for (String day : map.keySet()) {
            if (map.get(day).size() > maxSizeSoFar) {
                maxSizeSoFar = map.get(day).size();
                MostVisitedDay = day;
            }
        }

        return MostVisitedDay;
    }

    public ArrayList<String> ipWithMostVisitsOnDay(HashMap<String, ArrayList<String>> map, String day) {
        ArrayList<String> ipWithMostVisits = new ArrayList<String>();
        for (String accessDate : map.keySet()) {
            ArrayList<String> IPList = map.get(accessDate);
            HashMap<String, Integer> countEachIP = new HashMap<String, Integer>();

            for (String ipAddress : IPList) {
                if (countEachIP.containsKey(ipAddress)) {
                    countEachIP.put(ipAddress, countEachIP.get(ipAddress) + 1);
                } else {
                    countEachIP.putIfAbsent(ipAddress, 1);
                }
            }

            ipWithMostVisits = iPMostVisits(countEachIP);
        }

        return ipWithMostVisits;

    }

    public void printAll() {
        for (LogEntry le : records) {
            System.out.println(le);
        }
    }
}
