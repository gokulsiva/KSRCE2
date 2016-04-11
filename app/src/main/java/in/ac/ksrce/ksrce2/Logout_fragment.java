package in.ac.ksrce.ksrce2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Button;
import java.util.HashMap;
import android.text.Html;
import android.widget.Toast;

/**
 * Created by gokul on 21-02-2016.
 */
public class Logout_fragment extends Fragment implements View.OnClickListener {
    TextView name;
    TextView department;
    TextView account;
    Button logout;
    SessionManagement session;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.logout_fragment, container, false);
        MainActivity.back_operation = 1;
        session = new SessionManagement(getContext());
        session.userDetails();
        name = (TextView) v.findViewById(R.id.logut_id);
        department = (TextView) v.findViewById(R.id.logout_department);
        account = (TextView) v.findViewById(R.id.logout_account);
        name.setText(session.username);
        department.setText(session.user_department);
        account.setText(session.user_account);
        logout = (Button)v.findViewById(R.id.button);
        logout.setOnClickListener(this);
        return v;
    }

    @Override
    public void onClick(View v) {
        session.logoutUser();
        android.support.v4.app.FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Login_fragment fragment = new Login_fragment();
        fragmentTransaction.replace(R.id.mainContent, fragment);
        fragmentTransaction.commit();
        Toast.makeText(getContext(), "Successfully Logged out", Toast.LENGTH_SHORT);
    }
}
