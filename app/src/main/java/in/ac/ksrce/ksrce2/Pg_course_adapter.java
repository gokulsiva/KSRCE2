package in.ac.ksrce.ksrce2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by gokul on 31-01-2016.
 */
public class Pg_course_adapter extends BaseAdapter {

    private Context context;
    String[] pg_list;

    public Pg_course_adapter(Context context) {
        this.context = context;
        pg_list=context.getResources().getStringArray(R.array.pg_course);
    }

    @Override
    public int getCount() {
        return pg_list.length;
    }

    @Override
    public Object getItem(int position) {
        return pg_list[position];
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
            row=inflater.inflate(R.layout.pg_course_listview,parent,false);
        }
        else
        {
            row=convertView;
        }
        TextView titleText= (TextView) row.findViewById(R.id.pg_list_text);
        titleText.setText(pg_list[position]);
        return row;
    }
}
