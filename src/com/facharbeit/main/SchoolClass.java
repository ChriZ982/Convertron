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

    public SchoolClass()
    {
        entrys = new ArrayList<Entry>();
    }

    public SchoolClass(ArrayList<Entry> entrys)
    {
        this.entrys = entrys;
    }

    public ArrayList<Entry> getEntrys()
    {
        return entrys;
    }

    public void setEntrys(ArrayList<Entry> entrys)
    {
        this.entrys = entrys;
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
