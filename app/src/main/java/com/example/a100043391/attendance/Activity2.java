package com.example.a100043391.attendance;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

      Intent i=getIntent();


        Instructor INST=(Instructor) i.getSerializableExtra("inst");
           Course [] c= INST.getCourses();
        //*************************************************************************
        final Course [] temp= new Course[c.length];

        for(int j=0; j<c.length;j++ )
            temp[j]= new Course(c[j].getCode(),c[j].getName(),c[j].getNumOfStudents(),c[j].getListStudents());


        String [] nameOfCourses= new String[INST.getNumCourses()];
        for (int j=0; j<INST.getNumCourses(); j++)
            nameOfCourses[j]= c[j].getCode();
        ListView ListView2 = (ListView) findViewById(R.id.ListView2);
        ArrayAdapter adapter = new
                ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,nameOfCourses);
        ListView2.setAdapter(adapter);

        ListView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent j= new Intent (Activity2.this,Activity3.class);
                j.putExtra("co",temp[position]);
                startActivity(j);

            }
        });

    }
}