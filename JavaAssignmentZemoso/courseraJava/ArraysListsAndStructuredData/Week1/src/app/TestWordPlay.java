package app;

import app.WordPlay;
public class TestWordPlay
{
    public static void main(String[] args)
    {
        WordPlay chaloKhelteHai = new WordPlay();

        testIsVowel(chaloKhelteHai, 'a');
        testreplaceVowels(chaloKhelteHai, "Hello World", '*');
        testemphasize(chaloKhelteHai, "dna ctgaaactga", 'a');
        
    }

    public static void testIsVowel(WordPlay word,char ch)
    {
        if(word.isVowel(ch))
        {
            System.out.println("Yes!! the character is a Vowel");
        }
        else
        {
            System.out.println("Nope!! not a Vowel");
        }
    }

    public static void testreplaceVowels(WordPlay word, String str, char ch)
    {
        System.out.println(word.replaceVowels(str, ch));
    }

    public static void testemphasize(WordPlay word, String str, char ch)
    {
        String myString = word.emphasize("dna ctgaaactga", 'a');
        System.out.println(myString);
    }
}