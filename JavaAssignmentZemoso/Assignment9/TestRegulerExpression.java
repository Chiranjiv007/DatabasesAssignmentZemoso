package Assignment9;

import java.util.regex.Pattern;


import Assignment9.RegulerExpression;
import java.util.regex.Matcher;

public class TestRegulerExpression
{
    
    public static void main(String[] args) throws Exception
    {
        RegulerExpression regulerExpression = new RegulerExpression();
        String sentence = "Chisdgsdnfgksdiguhsdfb.vsd34r9.";
        
        if (regulerExpression.testSentence(sentence)) 
        {
            System.out.println("Valid Sentence");
        } 
        else 
        {
            System.out.println("Invalid Sentence");
        }
    }
}