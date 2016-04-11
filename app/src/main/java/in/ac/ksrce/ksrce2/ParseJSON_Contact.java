package in.ac.ksrce.ksrce2;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by gokul on 20-02-2016.
 */
public class ParseJSON_Contact {
    public static String[] departments;
    public static String[] names;
    public static String[] designations;
    public static String[] contacts;

    public static final String JSON_ARRAY = "Contacts";
    public static final String KEY_Department = "Department";
    public static final String KEY_Name = "Name";
    public static final String KEY_Designations = "Designation";
    public static final String KEY_Contacts= "Contact";


    private JSONArray users = null;

    private String json;

    public ParseJSON_Contact(String json){
        this.json = json;
    }

    protected void parseJSON(){
        JSONObject jsonObject;
        try {
            jsonObject = new JSONObject(json);
            users = jsonObject.getJSONArray(JSON_ARRAY);

            departments = new String[users.length()];
            names = new String[users.length()];
            designations = new String[users.length()];
            contacts = new String[users.length()];

            for(int i=0;i<users.length();i++){
                JSONObject jo = users.getJSONObject(i);
                departments[i] = jo.getString(KEY_Department);
                names[i] = jo.getString(KEY_Name);
                designations[i] = jo.getString(KEY_Designations);
                contacts[i] = jo.getString(KEY_Contacts);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}
