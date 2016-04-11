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
public class Ug_course_adapter extends BaseAdapter {

    private Context context;
    String[] ug_list;

    public Ug_course_adapter(Context context) {
        this.context = context;
        this.ug_list=context.getResources().getStringArray(R.array.ug_course);
    }

    @Override
    public int getCount() {
        return ug_list.length;
    }

    @Override
    public Object getItem(int position) {
        return ug_list[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row1;
        if(convertView==null){
            LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row1=inflater.inflate(R.layout.ug_course_listview,parent,false);
        }
        else
        {
            row1=convertView;
        }
        TextView titleText= (TextView) row1.findViewById(R.id.ug_list_text);
        titleText.setText(ug_list[position]);
        return row1;
    }
}
