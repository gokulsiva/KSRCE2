package in.ac.ksrce.ksrce2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import org.w3c.dom.Text;

/**
 * Created by gokul on 20-02-2016.
 */
public class Staff_reference_contacts extends Fragment implements View.OnClickListener {

    private Spinner spinner;
    private Button button;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.staff_reference_layout,container,false);
        spinner = (Spinner) v.findViewById(R.id.department_contacts_spinner);
        button = (Button) v.findViewById(R.id.go);
        ArrayAdapter<String> departmentAdapter= new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.Department));
        spinner.setAdapter(departmentAdapter);
        button.setOnClickListener(this);
        return v;
    }

    @Override
    public void onClick(View v) {

        String selected_department_staff=spinner.getSelectedItem().toString().trim();
       if(!(selected_department_staff.equals("Select Department")))
       {
           switch (selected_department_staff)
           {
               case "AUTO": {
                   MainActivity.back_operation = 2;
                   Config.Contact_table = Config.Contact_url + "auto_staffs";
                   android.support.v4.app.FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                   android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                   Reference_Contacts fragment = new Reference_Contacts();
                   fragmentTransaction.replace(R.id.mainContent, fragment);
                   fragmentTransaction.commit();
                   break;
               }
               case "CIVIL":{
                   MainActivity.back_operation = 2;
                   Config.Contact_table=Config.Contact_url+"civil_staffs";
                   android.support.v4.app.FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                   android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                   Reference_Contacts fragment = new Reference_Contacts();
                   fragmentTransaction.replace(R.id.mainContent, fragment);
                   fragmentTransaction.commit();
                   break;}
               case "CS":{
                   MainActivity.back_operation = 2;
                   Config.Contact_table=Config.Contact_url+"cs_staffs";
                   android.support.v4.app.FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                   android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                   Reference_Contacts fragment = new Reference_Contacts();
                   fragmentTransaction.replace(R.id.mainContent, fragment);
                   fragmentTransaction.commit();
                   break;}
               case "ECE":{
                   MainActivity.back_operation = 2;
                   Config.Contact_table=Config.Contact_url+"ece_staffs";
                   android.support.v4.app.FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                   android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                   Reference_Contacts fragment = new Reference_Contacts();
                   fragmentTransaction.replace(R.id.mainContent, fragment);
                   fragmentTransaction.commit();
                   break;}
               case "EEE":{
                   MainActivity.back_operation = 2;
                   Config.Contact_table=Config.Contact_url+"eee_staffs";
                   android.support.v4.app.FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                   android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                   Reference_Contacts fragment = new Reference_Contacts();
                   fragmentTransaction.replace(R.id.mainContent, fragment);
                   fragmentTransaction.commit();
                   break;}
               case "IT":{
                   MainActivity.back_operation = 2;
                   Config.Contact_table=Config.Contact_url+"it_staffs";
                   android.support.v4.app.FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                   android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                   Reference_Contacts fragment = new Reference_Contacts();
                   fragmentTransaction.replace(R.id.mainContent, fragment);
                   fragmentTransaction.commit();
                   break;}
               case "MECH":{
                   MainActivity.back_operation = 2;
                   Config.Contact_table=Config.Contact_url+"mech_staffs";
                   android.support.v4.app.FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                   android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                   Reference_Contacts fragment = new Reference_Contacts();
                   fragmentTransaction.replace(R.id.mainContent, fragment);
                   fragmentTransaction.commit();
                   break;}

           }


       }
        else
       {
           Toast.makeText(getContext(),"Please select a department",Toast.LENGTH_SHORT).show();
       }

    }
}
