package com.example.a100043391.attendance;

import java.io.Serializable;

/**
 * Created by 100043391 on 4/2/2017.
 */

public class Instructor implements Serializable {
    private String title;
    private String name;
    private int numOfCourses;
    private int ID;
    private Course[] courses;
    static private int numOfInst=0;
    public Instructor( String t, String n, int numCourses, Course[] c )
    {
        numOfInst++;
        ID=numOfInst;
        numOfCourses=numCourses;
        title=t;
        name=n;
        courses= new Course [numCourses];
        for(int i=0; i<numCourses;i++)
            courses[i]= new Course(c[i].getCode(),c[i].getName(),c[i].getNumOfStudents(),c[i].getListStudents());

    }
    public String getName()
    { return name ;}
    public String getTitle()
    { return title ;}
    public int getId()
    { return ID ;}
    public Course[] getCourses()
    {return courses;}
    public int getNumCourses()
    { return numOfCourses;}
    public Instructor makeCopy(Instructor i)
    {
        Instructor temp=new Instructor(i.getTitle(),i.getName(),i.getNumCourses(),i.getCourses());
        return temp;
    }
}

