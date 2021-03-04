package com.example.a100043391.attendance;

import java.io.Serializable;

/**
 * Created by 100043391 on 4/9/2017.
 */

public class StudList implements Serializable {
    private String name;
    private int ID;
    private static int absence ;
    public StudList(int id, String n, int absen)
    {
        ID=id;
        name=n;
        absence=absen;
    }
    public String getName()
    {return name;}
    public int getAbsence()
    {return absence;}
    public int getID()
    {return ID;}
}
