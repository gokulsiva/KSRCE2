package in.ac.ksrce.ksrce2;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by gokul on 02-02-2016.
 */
public class Circular_Adapter extends ArrayAdapter<String> {

    private String[] ids;
    private String[] names;
    private String[] urls;
    private Activity context;

    public Circular_Adapter(Activity context, String[] ids, String[] names, String[] urls) {
        super(context,R.layout.circular_list_view, ids);
        this.context = context;
        this.ids = ids;
        this.names = names;
        this.urls = urls;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View listViewItem = inflater.inflate(R.layout.circular_list_view, null, true);
        TextView textViewName = (TextView) listViewItem.findViewById(R.id.list_in_circular);
        TextView textViewUrl = (TextView) listViewItem.findViewById(R.id.url_circular);
        textViewName.setText(names[position]);
        textViewUrl.setText(urls[position]);
        return listViewItem;
    }
}
