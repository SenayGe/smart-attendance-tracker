package com.example.a100043391.attendance;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class Activity3 extends AppCompatActivity {
    StudList[] sheet;
    StringBuffer absentees= new StringBuffer();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);


        Intent i= getIntent();
        final Course Act3course=(Course) i.getSerializableExtra("co");
         sheet= Act3course.getListStudents();

     /*   String[] regStudents=new String[Act3course.getNumOfStudents()];
        for(int j=0;j<sheet.length;j++)
            regStudents[j]= sheet[j].getID()+" "+sheet[j].getName()+"       "+sheet[j].getAbsence();

        ListView ListView3 = (ListView) findViewById(R.id.ListView3);

        ArrayAdapter adapter = new
                ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,regStudents);
        ListView3.setAdapter(adapter);          */

        ListView ListView3 = (ListView) findViewById(R.id.ListView3);
        final studMembers[] registeredStudents= new studMembers[Act3course.getNumOfStudents()];
        for(int j=0; j<Act3course.getNumOfStudents(); j++)
        {
            registeredStudents[j]=new studMembers(sheet[j].getID(),sheet[j].getName(),sheet[j].getAbsence(),0);
        }
        StudArrayAdapter adapter= new StudArrayAdapter(this,registeredStudents);
        ListView3.setAdapter(adapter);
//  *************************************************************************   BUTTON
        Button btn1= (Button) findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              absentees.setLength(0); //absentees is a stringbuffer      //   MAKES THE STRINGBUFFER EMPTY;
                Context context = getApplicationContext();
                int duration = Toast.LENGTH_SHORT;

               for(int k=0; k<Act3course.getNumOfStudents(); k++) {

                   if (registeredStudents[k].getValue() == 1) {
                       absentees.append(sheet[k].getName() + "\n");//  *****  NOTE: ACT3COURSE, REGISTEREDSTUDENTS ARE SET AS FINAL
                       //
                   }
               }
                  if(absentees.length()!=0)
                  {
                      Toast.makeText(getApplicationContext(),
                             "ABSENTEES:\n"+ absentees, Toast.LENGTH_LONG).show();
                    }
                  else
                    {
                        CharSequence text2 = "All are presenet";
                        Toast toast = Toast.makeText(context, text2, duration);
                     toast.show();
                    }
         //   finish();
          }
        });

    }
}
