package in.ac.ksrce.ksrce2;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by gokul on 09-04-2016.
 */
public class Regno_fragment extends Fragment implements View.OnClickListener {

    private EditText regno;
    private Button go;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.regno_fragment,container,false);
        MainActivity.back_operation = 1;
        regno = (EditText)v.findViewById(R.id.regno);
        go = (Button)v.findViewById(R.id.regno_go_button);
        go.setOnClickListener(this);
        return v;
    }

    @Override
    public void onClick(View v) {
        InputMethodManager imm = (InputMethodManager)getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(regno.getWindowToken(),0);
        String regno1 = regno.getText().toString().trim();
        if(regno1.equals("")||regno1.length()<7)
        {
            Toast.makeText(getContext(),"Please enter register number",Toast.LENGTH_SHORT);
        }
        else
        {
            MainActivity.back_operation = 1;
            Student_database fragment = new Student_database();
            fragment.regno = regno1;
            android.support.v4.app.FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.mainContent, fragment);
            fragmentTransaction.commit();
        }
    }
}
