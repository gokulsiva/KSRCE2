package in.ac.ksrce.ksrce2;

import android.content.Context;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.RequestQueue;
import android.widget.Toast;

/**
 * Created by gokul on 24-02-2016.
 */
public class Update_circularviewed {

 Context context;

    public Update_circularviewed(Context context) {
        this.context = context;
    }

    public void updateStaff(String filename)
    {
        final SessionManagement session;
        session = new SessionManagement(context);
        session.userDetails();
        String url = "http://gokulonlinedatabase.net16.net/views/viewedStaffs.php?userid="+session.username+"&department="+session.user_department+"&circular="+filename;
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(context,error.toString(),Toast.LENGTH_LONG).show();
                    }
                })
        {

        };

        RequestQueue requestQueue = Volley.newRequestQueue(context, new HurlStack());
        requestQueue.add(stringRequest);
        stringRequest.setRetryPolicy(new DefaultRetryPolicy(5000,
                1,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
    }
}
