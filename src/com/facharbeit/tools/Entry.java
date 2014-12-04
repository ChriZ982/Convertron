package com.facharbeit.tools;

public class Entry
{
    private int hour = -1;
    private String date = null;
    private String dayOfWeek = null;

    public String getDate()
    {
        return date;
    }

    public void setDate(String date)
    {
        this.date = date;
    }

    public String getDayOfWeek()
    {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek)
    {
        this.dayOfWeek = dayOfWeek;
    }
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

//    public Entry(int hour, boolean nextIsEqual, String... content)
//    {
//        this.hour = hour;
//        this.nextIsEqual = nextIsEqual;
//        this.content = content;
//    }
//    public Entry(int hour, String... content)
//    {
//        this.hour = hour;
//        this.nextIsEqual = false;
//        this.content = content;
//    }
//    public Entry(String... content)
//    {
//        try
//        {
//            this.hour = Integer.parseInt(content[0]);
//        } catch(NumberFormatException n)
//        {
//            this.hour = -1;
//        }
//
//        this.nextIsEqual = false;
//
//        this.content = new String[content.length - 1];
//
//        for(int i = 1; i < content.length; i++)
//            this.content[i - 1] = content[i];
//    }
    public Entry(String... content)
    {

        boolean nextIsEqual = false;
        try
        {
            this.hour = Integer.parseInt(content[0]);
        } catch(NumberFormatException ex)
        {

            if(content[0].indexOf("-") > 0)
            {
                nextIsEqual = true;
                try
                {
                    this.hour = Integer.parseInt(content[0].substring(0, content[0].indexOf("-") - 1));
                } catch(NumberFormatException e)
                {
                }

            } else
            {
                //Fehler
            }
        }

        this.nextIsEqual = nextIsEqual;

        this.date = content[1];
        this.dayOfWeek = content[2];

        this.content = new String[content.length - 3];

        for(int i = 3; i < content.length; i++)
            this.content[i - 3] = content[i];
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
