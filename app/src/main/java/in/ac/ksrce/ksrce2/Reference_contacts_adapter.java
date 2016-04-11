package in.ac.ksrce.ksrce2;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by gokul on 20-02-2016.
 */
public class Reference_contacts_adapter extends ArrayAdapter{
    private String[] departments;
    private String[] names;
    private String[] designations;
    private String[] contacts;
    private Activity context;

    public Reference_contacts_adapter(Activity context, String[] departments, String[] names, String[] designations,String[] contacts) {
        super(context,R.layout.reference_contacts_listview,departments);
        this.context = context;
        this.departments = departments;
        this.names = names;
        this.designations = designations;
        this.contacts=contacts;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View listViewItem = inflater.inflate(R.layout.reference_contacts_listview, null, true);
        TextView textViewDepartment = (TextView) listViewItem.findViewById(R.id.department_details);
        TextView textViewName = (TextView) listViewItem.findViewById(R.id.name_details);
        TextView textViewDesignation = (TextView) listViewItem.findViewById(R.id.designation_details);
        EditText editTextContact = (EditText) listViewItem.findViewById(R.id.contact_details);
        textViewDepartment.setText(departments[position]);
        textViewName.setText(names[position]);
        textViewDesignation.setText(designations[position]);
        editTextContact.setText(contacts[position]);
        return listViewItem;
    }
}

