package com.facharbeit.tools;

public class HtmlFoot
{
    private int period, startWeek, endWeek;
    private String startDate, endDate, asString;
    private char startWeekType, endWeekType;

    public HtmlFoot(String foot)
    {
        asString = foot;

        foot = foot.substring(foot.indexOf("Periode") + "Periode".length());

        try
        {
            period = Integer.parseInt(foot.substring(0, foot.indexOf(" ")));
        } catch(NumberFormatException ex)
        {
            period = -1;
        }

        foot = foot.substring(foot.indexOf(" ") + 1);
        while(foot.startsWith(" "))
            foot = foot.substring(1);

        startDate = foot.substring(0, foot.indexOf(" "));
        foot = foot.substring(foot.indexOf(" ") + 1);
        while(foot.startsWith(" "))
            foot = foot.substring(1);
        startWeekType = foot.charAt(0);

        foot = foot.substring(foot.indexOf("(") + 1);

        try
        {
            startWeek = Integer.parseInt(foot.substring(0, foot.indexOf(")")));
        } catch(NumberFormatException ex)
        {
            startWeek = -1;
        }

        foot = foot.substring(foot.indexOf("-") + 1);

        while(foot.startsWith(" "))
            foot = foot.substring(1);

        endDate = foot.substring(0, foot.indexOf(" "));
        foot = foot.substring(foot.indexOf(" ") + 1);
        while(foot.startsWith(" "))
            foot = foot.substring(1);
        endWeekType = foot.charAt(0);

        foot = foot.substring(foot.indexOf("(") + 1);

        try
        {
            endWeek = Integer.parseInt(foot.substring(0, foot.indexOf(")")));
        } catch(NumberFormatException ex)
        {
            endWeek = -1;
        }

    }

    public int getPeriod()
    {
        return period;
    }

    public int getStartWeek()
    {
        return startWeek;
    }

    public int getEndWeek()
    {
        return endWeek;
    }

    public String getStartDate()
    {
        return startDate;
    }

    public String getEndDate()
    {
        return endDate;
    }

    public char getStartWeekType()
    {
        return startWeekType;
    }

    public char getEndWeekType()
    {
        return endWeekType;
    }

    @Override
    public String toString()
    {
        return asString;
    }
}
