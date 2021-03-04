package com.example.a100043391.attendance;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class First extends AppCompatActivity {
 Instructor[] instructors;
   public Student[] students;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        AssetManager assetManager=getAssets();

        try {
            InputStream input1 = assetManager.open("inputStud.txt");
            InputStream input3 = assetManager.open("inputStud.txt");
            InputStream input2 = assetManager.open("input Inst.txt");
            Scanner scan1 = new Scanner(input1);
            Scanner scan2= new Scanner(input2);


            //***************************   DUPLICATE THE TEXT FILE  ************************************************
          Scanner scan3 =new Scanner(input3);
            PrintWriter outfile= new PrintWriter(Environment.getExternalStorageDirectory().getPath()+"/duplicateTxt.txt" );
            while(scan3.hasNext())
            {
                Scanner Line= new Scanner(scan3.nextLine());
                while(Line.hasNext())
                {   String str=Line.next();
                    outfile.print(str+" ");
                }
                outfile.println();
            }
            outfile.close();
         //   input1.close();
            // ******************************************************************************************************8
           Scanner infile=  new Scanner(new FileReader(Environment.getExternalStorageDirectory()+"/duplicateTxt.txt"));

            //  READING THE SSTUDENT FILE
            int numStud= infile.nextInt();
            students= new Student[numStud];
            for(int i=0;i<numStud;i++)
            {
                int id=infile.nextInt();
                String name=infile.next();
                name=name+" "+ infile.next();         //  MIGHT NOT WORKK , CHECK LATER
                int x=infile.nextInt();
                Course[] studCourse= new Course[x];
                for (int j=0;j<x;j++)
                    studCourse[j]=new Course(infile.next(),infile.nextInt());
               students[i]=new Student(id,name,x,studCourse);
            }



            // READING THE INSTRUCTORS FILE

            int numInst=scan2.nextInt();
            instructors= new Instructor[numInst];
            for (int i=0;i<numInst;i++)        //           INSTRUCTORS
            {
                String title= scan2.next();
                String name=scan2.next() + " "+ scan2.next();
                int y=scan2.nextInt();
                Course[] InstCourse= new Course[y];
                for(int j=0;j<y;j++)
                {
                    String instCode=scan2.next();
                    String courseName=scan2.next();
                    int stud=scan2.nextInt();
                    StudList[] sheet= new StudList[stud];

                    // ****************** SEARCHING THE STUDENTS ***************************
                    int countL=0;
                    boolean found;
                    for(int k=0;k<stud;k++)      //            2 students
                    {
                        found=false;
                        for(int l=countL; l<students.length;l++)
                        {
                            for (int m = 0; m < students[l].getEnrolledCourses().length; m++) {
                                if (students[l].getEnrolledCourses()[m].getCode().equals(instCode)) {

                                    sheet[k] = new StudList(students[l].getID(), students[l].getName(), students[l].getEnrolledCourses()[m].getMissedClasses());
                                    found=true;
                                }
                            }
                            if (found) {
                                countL = l+1;
                                break;
                            }


                        }
                    }
                    // ******************* EDN STUDENT SEARCH ********************************************
                    InstCourse[j]= new Course(instCode,courseName,stud,sheet);

                }

             instructors[i]= new Instructor(title,name,y,InstCourse);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        ListView ListView1= (ListView) findViewById(R.id.ListView1);
        String[] listOfInst= new String[instructors.length];
        for(int i=0;i<instructors.length;i++)
            listOfInst[i]= instructors[i].getTitle()+" "+instructors[i].getName();
        ArrayAdapter adapter = new
                ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,listOfInst);

        ListView1.setAdapter(adapter);
        ListView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i= new Intent (First.this,Activity2.class);
                i.putExtra("inst",instructors[position]);
                startActivity(i);
            }
        });

    }


}

