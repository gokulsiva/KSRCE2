package in.ac.ksrce.ksrce2;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Gokul on 13-02-2016.
 */
public class Result_Adapter extends BaseAdapter {

    private Context context;
    String[] subjects;
    String[] grades;


    public Result_Adapter(Context context,String[] subject,String[] grade) {
        this.context=context;
        this.subjects=subject;
        this.grades=grade;

    }

    @Override
    public int getCount() {
        return subjects.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View row;
        if(convertView==null){
            LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row=inflater.inflate(R.layout.result_listview,parent,false);
        }
        else
        {
            row=convertView;
        }
        TextView subject= (TextView) row.findViewById(R.id.result_subject);
        subject.setText(subjects[position]);
        TextView grade = (TextView) row.findViewById(R.id.result_grade);
        grade.setText(grades[position]);
        return row;
    }
}
