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

        this.content = new String[content.length - 1];

        for(int i = 1; i < content.length; i++)
            this.content[i - 1] = content[i];
    }

    public Entry(boolean nextIsEqual, String... content)
    {
        try
        {
            this.hour = Integer.parseInt(content[0]);
        } catch(NumberFormatException n)
        {
            this.hour = -1;
        }

        this.nextIsEqual = nextIsEqual;

        this.content = new String[content.length - 1];

        for(int i = 1; i < content.length; i++)
            this.content[i - 1] = content[i];
    }

    public String toString(String cssClass)
    {
        String s = "";

        s += "'            <tr class=\"" + cssClass + "\">'+\n";

        if(nextIsEqual)
            s += "'                <td>" + hour + "-" + (hour + 1) + "</td>'+\n";
        else
            s += "'                <td>" + hour + "</td>'+\n";

        for(String c : content)
            s += "'                <td>" + c + "</td>'+\n";

        s += "'            </tr>'+\n";
        return s;
    }
}
