package com.example.a100043391.attendance;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

/**
 * Created by 100043391 on 4/12/2017.
 */

public class StudArrayAdapter extends ArrayAdapter {
    studMembers [] registeredStudents=null;
    Context context;
    public StudArrayAdapter(Context context,studMembers[] resource)
    {
        super(context,R.layout.row_view,resource);
        this.context=context;
        this.registeredStudents=resource;
    }
    public View getView(final int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = ((Activity3)context).getLayoutInflater();
        convertView = inflater.inflate(R.layout.row_view, parent, false);
        TextView name = (TextView) convertView.findViewById(R.id.textView3);
        TextView percent = (TextView) convertView.findViewById(R.id.textView4);
        CheckBox cb = (CheckBox) convertView.findViewById(R.id.checkBox);
        name.setText(""+registeredStudents[position].getId()+" "+registeredStudents[position].getName());
        percent.setText(""+registeredStudents[position].getPercent()+"%");
        if(registeredStudents[position].getValue() == 1)
            cb.setChecked(true);
        else
            cb.setChecked(false);
        // Adding a listener for the checkboxes.
        cb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                boolean isChecked = ((CheckBox)arg0).isChecked();
                if (isChecked){
                    registeredStudents[position].setValue(1);
                }else{
                    registeredStudents[position].setValue(0);
                }



            }
        });
        return convertView;

    }

}


