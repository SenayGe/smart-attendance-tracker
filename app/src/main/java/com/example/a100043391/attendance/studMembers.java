package com.example.a100043391.attendance;

/**
 * Created by 100043391 on 4/12/2017.
 */

//     CLASS FOR CREATING AN ARRAY OF CHECKBOX AND TEXTVIEW.

public class studMembers {
  private  int id;
    private  String name;
    private float percent;
    private int value;  //     FOR THE CHECKBOX.
    public studMembers(int id,String name,float percent,int value)
    {
        this.id=id;
        this.name=name;
        this.percent=percent;
        this.value=value;
    }

    public int getId()
    {return id;}
    public String getName()
    {return name;}
    public float getPercent()
    {return percent;}
    public int getValue()
    {return value;}
    public void setValue(int x)
    {value=x;}

}
