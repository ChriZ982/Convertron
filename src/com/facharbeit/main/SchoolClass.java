/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.facharbeit.main;

import java.util.ArrayList;

/**
 *
 * @author Mirko
 */
public class SchoolClass
{

    private ArrayList<Entry> entrys;
    private String name;

    public SchoolClass(String name)
    {
        entrys = new ArrayList<Entry>();
        this.name = name;
    }

    public SchoolClass(String name, ArrayList<Entry> entrys)
    {
        this.entrys = entrys;
        this.name = name;
    }

    public ArrayList<Entry> getEntrys()
    {
        return entrys;
    }

    public void setEntrys(ArrayList<Entry> entrys)
    {
        this.entrys = entrys;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public boolean isEmpty()
    {
        try
        {
            return entrys.isEmpty();
        } catch(NullPointerException ex)
        {
            return true;
        }
    }

}
