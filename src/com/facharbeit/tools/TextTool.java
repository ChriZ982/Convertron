/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.facharbeit.tools;

/**
 *
 * @author Mirko
 */
public class TextTool
{

    public String cutToIncl(String input, String toFind)
    {
        char[] inputAsArray = input.toCharArray();
        char[] toFindAsArray = toFind.toCharArray();
        char[] toReturn = toFindAsArray;
        if(input.contains(toFind))
        {
            boolean mistake = true;
            int foundIndex = 0;
            for(int i = 0; i < inputAsArray.length && mistake == true; i++)
            {
                mistake = false;
                for(int o = 0; o < toFindAsArray.length && mistake == false; o++)
                    if(inputAsArray[i + o] != toFindAsArray[o])
                        mistake = true;
                if(mistake == false)
                    foundIndex = i + toFindAsArray.length;
            }

            toReturn = new char[inputAsArray.length - foundIndex];
            for(int i = 0; i < toReturn.length; i++)
                toReturn[i] = inputAsArray[i + foundIndex];
        }
        return String.copyValueOf(toReturn);
    }

    public String cutToExcl(String input, String toFind)
    {
        if(input.contains(toFind))
            return toFind + cutToIncl(input, toFind);
        else
            return input;
    }

    public String cutFromIncl(String input, String toFind)
    {
        if(input.contains(toFind))
        {
            char[] toCut = cutFromExcl(input, toFind).toCharArray();
            char[] toReturn = new char[toCut.length - toFind.length()];
            System.arraycopy(toCut, 0, toReturn, 0, toReturn.length);
            return String.copyValueOf(toReturn);
        } else
            return input;
    }

    public String cutFromExcl(String input, String toFind)
    {
        char[] inputAsArray = input.toCharArray();
        char[] toFindAsArray = toFind.toCharArray();
        char[] toReturn = toFindAsArray;
        if(input.contains(toFind))
        {
            boolean mistake = true;
            int foundIndex = 0;
            for(int i = 0; i < inputAsArray.length && mistake == true; i++)
            {
                mistake = false;
                for(int o = 0; o < toFindAsArray.length && mistake == false; o++)
                    if(inputAsArray[i + o] != toFindAsArray[o])
                        mistake = true;
                if(mistake == false)
                    foundIndex = i + toFindAsArray.length;
            }

            toReturn = new char[foundIndex];
            System.arraycopy(inputAsArray, 0, toReturn, 0, toReturn.length);
        }
        return String.copyValueOf(toReturn);
    }

    public String getBetweenIncl(String input, String start, String end)
    {
        return cutToIncl(cutFromIncl(input, end), start);
    }

    public String getBetweenExcl(String input, String start, String end)
    {
        return cutToExcl(cutFromExcl(input, end), start);
    }
}
