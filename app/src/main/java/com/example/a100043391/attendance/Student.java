package com.example.a100043391.attendance;

import java.io.Serializable;

/**
 * Created by 100043391 on 4/2/2017.
 */

public class Student implements Serializable {
    private int ID;
    private String name;
    private int enrolledCourses;
    private Course[] crs;

    public Student(int id, String n, int enrolled, Course[] C)
    {
        ID=id;
        name=n;
        crs= new Course[enrolled];
        for (int i=0;i<enrolled;i++)
            crs[i]= new Course(C[i].getCode(),C[i].getMissedClasses());
    }
    public int getID()
    {return ID;}
    public String getName()
    {return name;}
    public int getNumOfEnrolled()
    {return enrolledCourses;}
    public Course[] getEnrolledCourses()
    {return crs;}
}
