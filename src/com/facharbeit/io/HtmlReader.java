/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.facharbeit.io;

import com.facharbeit.io.FileReader;
import com.facharbeit.tools.*;
import java.io.*;
import java.util.*;

/**
 *
 * @author Mirko
 */
public class HtmlReader
{

    public static SchoolClass[] readInToday()
    {
        if(Settings.load("useSQL").equals("true"))
            return readInSql();
        else
            return readInHtml(Settings.load("sourcePath") + "/heute");
    }

    public static SchoolClass[] readInTomorrow()
    {
        if(Settings.load("useSQL").equals("true"))
            return readInSql();
        else
            return readInHtml(Settings.load("sourcePath") + "/morgen");
    }

    private static SchoolClass[] readInHtml(String path)
    {

        String[] extraGrades =
        {
            "EF", "Q1", "Q2", "___"
        };

        ArrayList<File> files = new ArrayList<>();
        File f;
        for(int grade = 5; grade <= 9; grade++)
            for(int c = 97; c <= 122; c++)
            {
                f = new File(path + "Druck_Klasse_0" + grade + "" + (char)c + ".htm");
                if(f.exists())
                    files.add(f);
            }

        for(String s : extraGrades)
        {
            f = new File(path + "Druck_Klasse_" + s + ".htm");
            if(f.exists())
                files.add(f);
        }

        SchoolClass[] outcome = new SchoolClass[files.size()];

        for(int i = 0; i < outcome.length; i++)
        {
            outcome[i] = new SchoolClass(files.get(i).getName().substring(13, files.get(i).getName().lastIndexOf('.') - 1));

            if(outcome[i].isEmpty())
                outcome[i].setEntrys(new ArrayList<Entry>());

            String fileAsString = new FileReader(files.get(i)).toString();
            fileAsString = fileAsString.substring(fileAsString.indexOf("<TABLE border=\"3\" rules=\"all\" bgcolor=\"#E7E7E7\" cellpadding=\"1\" cellspacing=\"1\">"));
            fileAsString = fileAsString.substring(0, fileAsString.indexOf("<TABLE cellspacing=\"1\" cellpadding=\"1\">") - 1);
            boolean endOfFile = false;
            while(!endOfFile)
            {
                fileAsString = fileAsString.substring(fileAsString.indexOf("<TR>") + 4);

                //todo
                if(!fileAsString.contains("<TR>"))
                    endOfFile = true;
            }
        }

        return outcome;
    }

    private static SchoolClass[] readInSql()
    {
        SchoolClass[] outcome = new SchoolClass[1];

        return outcome;
    }
}
