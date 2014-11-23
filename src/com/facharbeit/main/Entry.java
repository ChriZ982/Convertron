/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.facharbeit.main;

/**
 *
 * @author Mirko
 */
public class Entry
{

    private int hour;
    private boolean nextIsEqual;
    private String[] content;

    public int getHour()
    {
        return hour;
    }

    public void setHour(int hour)
    {
        this.hour = hour;
    }

    public boolean isNextEqual()
    {
        return nextIsEqual;
    }

    public void setNextIsEqual(boolean nextIsEqual)
    {
        this.nextIsEqual = nextIsEqual;
    }

    public String[] getContent()
    {
        return content;
    }

    public void setContent(String[] content)
    {
        this.content = content;
    }

    public Entry(int hour, boolean nextIsEqual, String... content)
    {
        this.hour = hour;
        this.nextIsEqual = nextIsEqual;
        this.content = content;
    }

    public Entry(int hour, String... content)
    {
        this.hour = hour;
        this.nextIsEqual = false;
        this.content = content;
    }

    public Entry(String... content)
    {
        try
        {
            this.hour = Integer.parseInt(content[0]);
        } catch(NumberFormatException n)
        {
            this.hour = -1;
        }

        this.nextIsEqual = false;

        for(int i = 1; i < content.length; i++)
            this.content[i - 1] = content[i];
    }

}
