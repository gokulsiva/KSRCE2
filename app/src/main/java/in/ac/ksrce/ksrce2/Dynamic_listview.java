package in.ac.ksrce.ksrce2;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.util.Log;

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



import java.util.ArrayList;
import java.util.LinkedHashMap;


/**
 * Created by gokul on 03-03-2016.
 */
public class Dynamic_listview {

    private String url = "";
    private int switcher;
    ProgressDialog loading;
    Context context;
    Activity activity;
    TextView here_your_results;
    ListView result_show;
    ListView database_listview;
    public String[] subjects;
    public String[] grades;
    LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();

    public Dynamic_listview(Context context,Activity activity, String url, int switcher) {
        this.context=context;
        this.activity = activity;
        this.url = url;
        this.switcher = switcher;
    }


    public void getData(){

        loading = ProgressDialog.show(context, "Please wait.....", "Fetching your Results", false, false);
        StringRequest stringRequest = new StringRequest(url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        loading.dismiss();
                        Log.e("JSON_String",response);
                        showJSON(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        if (error instanceof TimeoutError || error instanceof NoConnectionError) {
                            Toast.makeText(context, "Please connect to a NETWORK and try again", Toast.LENGTH_LONG).show();
                            loading.dismiss();

                        } else if (error instanceof AuthFailureError) {
                            Toast.makeText(context, "AuthFailureError", Toast.LENGTH_LONG).show();
                            loading.dismiss();

                        } else if (error instanceof ServerError) {
                            Toast.makeText(context, "ServerError", Toast.LENGTH_LONG).show();
                            loading.dismiss();

                        } else if (error instanceof NetworkError) {
                            Toast.makeText(context, "NetworkError", Toast.LENGTH_LONG).show();
                            loading.dismiss();

                        } else if (error instanceof ParseError) {
                            Toast.makeText(context, "Parsing error try after some time", Toast.LENGTH_LONG).show();
                            loading.dismiss();
                        }
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(context, new HurlStack());
        requestQueue.add(stringRequest);
        stringRequest.setRetryPolicy(new DefaultRetryPolicy(5000,
                1,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
    }
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    private void showJSON(String response){


            try {
                String string = response.trim();
                string = string.replace("{","");
                string = string.replace("}","");
                string = string.replace("\"","");
                string = string.replace(",",":");
                String separated[] = string.split(":");
                for(int i=0;i<separated.length-1;i=i+2)
                {
                    if (separated[i+1].contains(" ")) {
                        int spacePos = separated[i+1].indexOf(" ");
                        if (spacePos > 0) {
                            separated[i+1]= separated[i+1].substring(0, spacePos);
                        }
                    }
                    map.put(separated[i], separated[i + 1]);
                }

            ArrayList<String> keyList = new ArrayList<String>(map.keySet());
            ArrayList<String> valueList = new ArrayList<String>(map.values());
            subjects = keyList.toArray(new String[keyList.size()]);
            grades = valueList.toArray(new String[valueList.size()]);

            switch (switcher)
            {
                case 1 :
                {
                    result_show = (ListView) activity.findViewById(R.id.result_listview);
                    Result_Adapter adapter =new Result_Adapter(context,subjects,grades);
                    result_show.setAdapter(adapter);
                    setListViewHeightBasedOnChildren(result_show);
                    here_your_results = (TextView)activity.findViewById(R.id.here_your_results);
                    here_your_results.setVisibility(View.VISIBLE);
                    result_show.setVisibility(View.VISIBLE);
                    break;
                }
                case 2 :
                {
                    database_listview = (ListView) activity.findViewById(R.id.database_listview);
                    Result_Adapter adapter =new Result_Adapter(context,subjects,grades);
                    database_listview.setAdapter(adapter);
                    break;
                }
            }
         }catch (Exception e) {
            e.printStackTrace();
        }


    }
    private void setListViewHeightBasedOnChildren(ListView listView) {
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null)
            return;

        int desiredWidth = View.MeasureSpec.makeMeasureSpec(listView.getWidth(), View.MeasureSpec.UNSPECIFIED);
        int totalHeight=0;
        View view = null;

        for (int i = 0; i < listAdapter.getCount(); i++)
        {
            view = listAdapter.getView(i, view, listView);

            if (i == 0)
                view.setLayoutParams(new ViewGroup.LayoutParams(desiredWidth,
                        AbsListView.LayoutParams.MATCH_PARENT));

            view.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED);
            totalHeight += view.getMeasuredHeight();

        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + ((listView.getDividerHeight()) * (listAdapter.getCount()));

        listView.setLayoutParams(params);
        listView.requestLayout();
    }




}
