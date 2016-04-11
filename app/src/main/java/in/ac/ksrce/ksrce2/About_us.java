package in.ac.ksrce.ksrce2;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by gokul on 02-02-2016.
 */
public class About_us extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.contact_us_fragment,container,false);
        MainActivity.back_operation = 1;
        return v;
    }

}
