package com.example.a100043391.attendance;

import java.io.Serializable;

/**
 * Created by 100043391 on 4/2/2017.
 */

public class Course implements Serializable {

    private String name;
    private String code;
    private int numOfStudents;
    private StudList[] Std;
    private static int missedClasses;
    public Course( String c, String n, int num, StudList[] s)
    {
        name=n;
        code=c;
        numOfStudents=num;
        Std= new StudList[num];
        for ( int i=0;i<num;i++)
            Std[i]= new StudList(s[i].getID(),s[i].getName(),s[i].getAbsence());

    }
    public Course (String c,int x)
    {

        code=c;
        missedClasses=x;
    }

    public String getName()
    {return name;}
    public String getCode()
    {return code;}
    public int getNumOfStudents()
    {return numOfStudents;}
    public StudList[] getListStudents()
    {return Std;}
    public int getMissedClasses()
    {return missedClasses;}

    // *************************    METHODS/ FUNCTIONS



}
