package in.ac.ksrce.ksrce2;


import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ThemedSpinnerAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.view.inputmethod.InputMethodManager;


import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.TimeoutError;
import com.android.volley.ServerError;
import com.android.volley.DefaultRetryPolicy;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


/**
 * Created by gokul on 03-01-2016.
 */
public class result_fragment extends Fragment implements View.OnClickListener {

    Button result;
    EditText regno;
    TextView here_your_results;
    ListView result_show;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.result_fragment, container, false);
        MainActivity.back_operation = 1;
        result = (Button) v.findViewById(R.id.result_button);
        regno = (EditText) v.findViewById(R.id.textView);
        result_show = (ListView)v.findViewById(R.id.result_listview);
        here_your_results = (TextView)v.findViewById(R.id.here_your_results);
        here_your_results.setVisibility(View.INVISIBLE);
        result_show.setVisibility(View.INVISIBLE);
        result.setOnClickListener(this);
        return v;
    }



    @Override
    public void onClick(View v) {
        InputMethodManager imm = (InputMethodManager)getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(regno.getWindowToken(),0);
        here_your_results.setVisibility(View.INVISIBLE);
        result_show.setVisibility(View.INVISIBLE);
        String DATA_URL ="http://gokulonlinedatabase.net16.net/result/result.php?Regno=";
        String reg=regno.getText().toString().trim();
        String url=DATA_URL+reg;


        if((regno.equals("") || regno.length()<7))
        {
            Toast.makeText(getContext(), "Please enter valid Regno", Toast.LENGTH_SHORT).show();

        }
        else {
            Dynamic_listview dl = new Dynamic_listview(getContext(),getActivity(),url,1);
            dl.getData();
        }
    }

}

