package in.ac.ksrce.ksrce2;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by gokul on 23-01-2016.
 */
public class ParseJSON {
    public static String[] ids;
    public static String[] names;
    public static String[] urls;

    public static final String JSON_ARRAY = "Result_Array";
    public static final String KEY_ID = "Id";
    public static final String KEY_NAME = "Name";
    public static final String KEY_URL = "Url";

    private JSONArray users = null;

    private String json;

    public ParseJSON(String json){
        this.json = json;
    }

    protected void parseJSON(){
        JSONObject jsonObject;
        try {
            jsonObject = new JSONObject(json);
            users = jsonObject.getJSONArray(JSON_ARRAY);

            ids = new String[users.length()];
            names = new String[users.length()];
            urls = new String[users.length()];

            for(int i=0;i<users.length();i++){
                JSONObject jo = users.getJSONObject(i);
                ids[i] = jo.getString(KEY_ID);
                names[i] = jo.getString(KEY_NAME);
                urls[i] = jo.getString(KEY_URL);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}