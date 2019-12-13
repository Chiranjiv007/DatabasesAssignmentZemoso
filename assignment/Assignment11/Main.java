/*
@author:- Chiranjiv Goyal

Using TextFile and a Map<Character,Integer>, create a program that takes 
the file name as a command line argument and counts the occurrence of all 
the different characters. Save the results in a text file.
*/

package Assignment11;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.BufferedWriter;

public class Main 
{
    public static String ReadFileAsString(String filename) throws Exception 
    {
        String data;
        data = new String(Files.readAllBytes(Paths.get(filename)));
        return data;
    }

    public static void main(String[] args) throws Exception 
    {
        String filename = args[0];
        String data = ReadFileAsString(filename);
        // System.out.println(data);

        Map<Character, Integer> hm = new HashMap<Character, Integer>();
        
        for (int i = 0; i < data.length(); i++) 
        {
            int temp;
            
            if (hm.containsKey(data.charAt(i))) 
            {
                temp = hm.get(data.charAt(i));
                temp++;
                hm.put(data.charAt(i), temp);
            } 
            else 
            {
                hm.put(data.charAt(i), 1);
            }
        }

        WriteInFile("Assignment11/output.txt", hm);
    }


    public static void WriteInFile(String OutFilename, Map<Character, Integer> mp) throws Exception 
    {
        Set<Map.Entry<Character, Integer>> st = mp.entrySet();

        BufferedWriter bw = new BufferedWriter(new FileWriter(OutFilename));
        
        for (Map.Entry<Character, Integer> me : st) 
        {
            bw.write(me.getKey() + ":" + me.getValue());
            bw.newLine();
        }
        bw.close();
    }

}
