package in.ac.ksrce.ksrce2;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by gokul on 10-02-2016.
 */
public class Login_fragment extends Fragment implements View.OnClickListener {

    private EditText user;
    private EditText pass;
    private Button buttonLogin;
    private boolean loggedIn = false;
    private Spinner account;
    private Spinner department;
    ProgressDialog loading;
    SessionManagement session;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.login_fragment,container,false);
        MainActivity.back_operation = 0;
        session = new SessionManagement(getContext());
        user = (EditText) v.findViewById(R.id.userid);
        pass = (EditText) v.findViewById(R.id.password);
        buttonLogin = (Button) v.findViewById(R.id.login);
        account = (Spinner) v.findViewById(R.id.accounttypeSpinner);
        department = (Spinner) v.findViewById(R.id.departmentSpinner);
        ArrayAdapter<String> accountAdapter= new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.Account));
        account.setAdapter(accountAdapter);
        ArrayAdapter<String> departmentAdapter= new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.Department));
        department.setAdapter(departmentAdapter);
        buttonLogin.setOnClickListener(this);
        return v;
    }

    private void login() {
        //Getting values from edit texts
        final String userid = user.getText().toString().trim();
        final String password = pass.getText().toString().trim();
        final String accountType = account.getSelectedItem().toString().trim();
        final String departmentType = department.getSelectedItem().toString().trim();

        if (!(userid.equals("") || password.equals("") || accountType.equals("Select Account type") || departmentType.equals("Select Department"))) {

            loading = ProgressDialog.show(getContext(), "Please wait.....", "Verifying user", false, false);

            if(accountType.equals("Student")){
                Config.LOGIN_URL="http://gokulonlinedatabase.net16.net/login/student_login/login.php?userid=";
            }
            else{
                Config.LOGIN_URL="http://gokulonlinedatabase.net16.net/login/staff_login/login.php?userid=";
            }
            String url =Config.LOGIN_URL+userid+"&password="+password;
            //Creating a string request
            JsonObjectRequest stringRequest = new JsonObjectRequest(Request.Method.GET,url,null,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            //If we are getting success from server
                            try {
                                JSONObject jsonObject = new JSONObject(String.valueOf(response));
                                JSONArray array = jsonObject.getJSONArray("success");

                                if (array!=null) {
                                    session.createLoginSession(userid,accountType,departmentType);
                                    loading.dismiss();
                                    pass.setText("");
                                    android.support.v4.app.FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                                    android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                                    home_fragment fragment = new home_fragment();
                                    fragmentTransaction.replace(R.id.mainContent, fragment);
                                    fragmentTransaction.commit();


                                } else {
                                    //If the server response is not success
                                    loading.dismiss();
                                    pass.setText("");
                                    //Displaying an error message on toast
                                    Toast.makeText(getContext(), "Invalid username or password", Toast.LENGTH_LONG).show();
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            // String res = String.valueOf(response);

                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            if (error instanceof TimeoutError || error instanceof NoConnectionError) {
                                Toast.makeText(getContext(), "Not connected to NETWORK", Toast.LENGTH_LONG).show();
                                loading.dismiss();

                            } else if (error instanceof AuthFailureError) {
                                Toast.makeText(getContext(), "AuthFailureError", Toast.LENGTH_LONG).show();
                                loading.dismiss();

                            } else if (error instanceof ServerError) {
                                Toast.makeText(getContext(), "ServerError", Toast.LENGTH_LONG).show();
                                loading.dismiss();

                            } else if (error instanceof NetworkError) {
                                Toast.makeText(getContext(), "NetworkError", Toast.LENGTH_LONG).show();
                                loading.dismiss();

                            } else if (error instanceof ParseError) {
                                Toast.makeText(getContext(), "Invalid UserID or Password", Toast.LENGTH_LONG).show();
                                loading.dismiss();


                            }
                        }
                    });

            //Adding the string request to the queue
            RequestQueue requestQueue = Volley.newRequestQueue(getContext(), new HurlStack());
            requestQueue.add(stringRequest);
            stringRequest.setRetryPolicy(new DefaultRetryPolicy(5000,
                    1,
                    DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        }
        else if(accountType.equals("Select Account")){
            Toast.makeText(getContext(),"Please select an account type",Toast.LENGTH_SHORT).show();
        }
        else if(departmentType.equals("Select Department")){
            Toast.makeText(getContext(),"Please select your department",Toast.LENGTH_SHORT).show();
        }
        else if(userid.equals("")){
            Toast.makeText(getContext(),"Please enter your userID",Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(getContext(),"Please enter your password",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onClick(View v) {
        InputMethodManager imm = (InputMethodManager)getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(user.getWindowToken(),0);
        login();


    }
}
