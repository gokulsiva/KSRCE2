package in.ac.ksrce.ksrce2;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.Collections;
import java.util.List;


/**
 * Created by gokul on 03-01-2016.
 */
public class Placement_fragment extends Fragment{

    public static final String JSON_URL = "http://gokulonlinedatabase.net16.net/placement/placement.php";
    private ListView listView;
    ProgressDialog loading;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.placement_fragment,container,false);
        listView = (ListView) v.findViewById(R.id.placement_listView);
        return v;
    }

    private void sendRequest(){
        StringRequest stringRequest = new StringRequest(JSON_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        showJSON(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        if (error instanceof TimeoutError || error instanceof NoConnectionError) {
                            Toast.makeText(getContext(), "Please connect to a NETWORK and try again", Toast.LENGTH_LONG).show();
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
                            Toast.makeText(getContext(), "Parsing error try after some time", Toast.LENGTH_LONG).show();
                            loading.dismiss();
                        }
                        android.support.v4.app.FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                        android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                        home_fragment fragment=new home_fragment();
                        fragmentTransaction.replace(R.id.mainContent, fragment);
                        fragmentTransaction.commit();

                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(getContext(),new HurlStack());
        requestQueue.add(stringRequest);
        stringRequest.setRetryPolicy(new DefaultRetryPolicy(5000,
                1,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

    }

    private void showJSON(String json){
        ParseJSON pj = new ParseJSON(json);
        pj.parseJSON();
        loading.dismiss();
        Placement_Adapter adapter = new Placement_Adapter(getActivity(), ParseJSON.ids,ParseJSON.names,ParseJSON.urls);
        listView.setAdapter(adapter);
       // Collections.reverse((List<?>) listView);
        adapter.notifyDataSetChanged();
        listView.setClickable(true);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView textView = (TextView) view.findViewById(R.id.url);
                String filename = textView.getText().toString();
                String file2download = "http://gokulonlinedatabase.net16.net/placement/docs/"+filename;
                Download_Content download_content = new Download_Content(getContext(),file2download,filename);

            }
        });

    }



    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        MainActivity.back_operation = 1;
        sendRequest();
        loading = ProgressDialog.show(getContext(),"Please wait.....","Fetching Data",false,false);
    }

}
