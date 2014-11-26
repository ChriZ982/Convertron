/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.facharbeit.io;

import com.facharbeit.tools.SchoolClass;
import com.facharbeit.io.*;

/**
 *
 * @author Mirko
 */
public class HtmlReader
{

    public static SchoolClass[] readInToday()
    {
        return readInPath(Settings.load("sourcePath") + "/heute");
    }

    public static SchoolClass[] readInTomorrow()
    {
        return readInPath(Settings.load("sourcePath") + "/morgen");
    }

    private static SchoolClass[] readInPath(String path)
    {
        SchoolClass[] outcome = new SchoolClass[1];

        if(Settings.load("useSQL").equals("true"))
        {
            //krasse SQL Eskalation
        } else
        {
            //nicht so krasse String umwandel Eskalation
        }

        return outcome;
    }
}
