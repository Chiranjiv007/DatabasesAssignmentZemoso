package app;

import java.io.File;
import java.util.*;

import edu.duke.DirectoryResource;
import edu.duke.FileResource;

public class VigenereBreaker 
{

    public String sliceString(String message, int whichSlice, int totalSlices) 
    {        
        String slicedString = "";
        for(int i=whichSlice;i<message.length();i = i+totalSlices)
        {
            slicedString = slicedString + message.charAt(i);
        }
        return slicedString;
    }

    public int[] tryKeyLength(String encrypted, int klength, char mostCommon) 
    {
        int[] key = new int[klength];
        CaesarCracker cracker = new CaesarCracker();

        for(int i=0;i<klength;i++)
        {
            String slicedString = sliceString(encrypted, i, klength);
            int dkey = cracker.getKey(slicedString);
            key[i] = dkey;
        }
        return key;
    }

    public void breakVigenere () 
    {
        FileResource fr = new FileResource();
        String fileContent = fr.asString();

        HashMap <String,HashSet<String>> langDictionary = new HashMap<String, HashSet<String>>();
        DirectoryResource dr = new DirectoryResource();

        for(File f : dr.selectedFiles())
        {
            FileResource fr2 = new FileResource(f);
            HashSet<String> dictionary = readDictionary(fr2);
            String filename = f.getName();
            langDictionary.putIfAbsent(filename, dictionary);
        }

        breakForAllLangs(fileContent, langDictionary);
    }

    public HashSet<String> readDictionary(FileResource fr)
    {
        HashSet<String> dictionary = new HashSet<String>();
        
        for(String line: fr.lines())
        {
            line.toLowerCase();
            if(!dictionary.contains(line))
            {
                dictionary.add(line);
            }            
        }

        return dictionary;
    }

    public char mostCommonCharIn(HashSet<String> set)
    {
        int[] count = new int[26];

        for(String word : set)
        {
            for(int i=0;i<word.length();i++)
            {
                char testChar = word.charAt(i);
                count[testChar-'a']++;
            }
        }

        CaesarCracker c = new CaesarCracker();
        int maxChar = c.maxIndex(count);

        return (char)('a' + maxChar);
    }

    public int countWords(String message, HashSet<String> dictionary)
    {
        String[] words = message.split("\\W+");
        int count = 0;

        for(String word: words)
        {
            if(dictionary.contains(word))
            {
                count++;
            }
        }

        return count;
    }

    public String breakForLanguage(String encrypted, HashSet<String> dictionary)
    {
        int maxRealWords = -1;
        String bestDecryption = "";
        
        for(int klength = 1; klength <= 100; klength++)
        {
            int[] key = tryKeyLength(encrypted, klength, mostCommonCharIn(dictionary));
            VigenereCipher vigenereCipher = new VigenereCipher(key);
            String message = vigenereCipher.decrypt(encrypted);
            int wordCount = countWords(message, dictionary);

            if(wordCount > maxRealWords)
            {
                maxRealWords = wordCount;
                bestDecryption = message;
            }
        }

        return bestDecryption;
    }


    public void breakForAllLangs(String encrypted, HashMap<String, HashSet<String>> langDictionary)
    {
        int maxRealWords = -1;
        String bestLang = "";
        String bestDecryption = "";

        for(String lang : langDictionary.keySet())
        {
            String decrypted = breakForLanguage(encrypted, langDictionary.get(lang));
            int wordCount = countWords(decrypted, langDictionary.get(lang));
            
            if(wordCount > maxRealWords)
            {
                maxRealWords = wordCount;
                bestLang = lang;
                bestDecryption = decrypted;
            }
        }

        System.out.println("Decryption: " + bestDecryption);
        System.out.println("Language: " + bestLang);

        return;
    }




    
}
