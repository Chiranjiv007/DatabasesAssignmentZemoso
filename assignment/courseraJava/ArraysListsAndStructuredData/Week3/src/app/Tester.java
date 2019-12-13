package app;

import app.LogEntry;
import java.util.Date;

public class Tester {
    public static void main(String[] args) {
        // String filename = "short-test_log";

        testLogAnalyzer();
        testUniqueIPsInRange(200, 305);
    }

    public static void testHigherThanNum(String fileName) {
        LogAnalyzer la = new LogAnalyzer();
        la.readFile(fileName);
        la.printAllhigherThanNum(200);
    }

    public static void testUniqueIPVisitsOnDay(String fileName) {
        LogAnalyzer la = new LogAnalyzer();
        la.readFile(fileName);
        System.out.println(la.uniqueIPVisitesOnDay("Sep 30"));
    }

    public static void testUniqueIPsInRange(int low, int high) {
        String filename = "short-test_log";
        LogAnalyzer la = new LogAnalyzer();
        la.readFile(filename);
        System.out.println(la.countUniqueIPsInRange(low, high));
    }

    public static void testLogEntry() {
        LogEntry le = new LogEntry("1.2.3.4", new Date(), "example request", 200, 500);
        System.out.println(le);
    }

    public static void testUniqueIP() {
        String filename = "short-test_log";
        LogAnalyzer la = new LogAnalyzer();
        la.readFile(filename);
        System.out.println(la.countUniqueIPs());
    }

    public static void testLogAnalyzer() {
        String filename = "short-test_log";
        LogAnalyzer la = new LogAnalyzer();
        la.readFile(filename);
        la.printAll();
    }

}