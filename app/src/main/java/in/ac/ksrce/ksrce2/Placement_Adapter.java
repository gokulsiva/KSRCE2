package in.ac.ksrce.ksrce2;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.app.Activity;
import android.view.LayoutInflater;
import android.widget.TextView;

/**
 * Created by gokul on 22-01-2016.
 */
public class Placement_Adapter extends ArrayAdapter<String > {

    private String[] ids;
    private String[] names;
    private String[] urls;
    private Activity context;

    public Placement_Adapter(Activity context, String[] ids, String[] names, String[] urls) {
        super(context,R.layout.placement_listview, ids);
        this.context = context;
        this.ids = ids;
        this.names = names;
        this.urls = urls;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View listViewItem = inflater.inflate(R.layout.placement_listview, null, true);
        TextView textViewName = (TextView) listViewItem.findViewById(R.id.list_in_placement);
        TextView textViewUrl = (TextView) listViewItem.findViewById(R.id.url);

        textViewName.setText(names[position]);
        textViewUrl.setText(urls[position]);



        return listViewItem;
    }


}
