package in.ac.ksrce.ksrce2;

import java.util.HashMap;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

/**
 * Created by gokul on 21-02-2016.
 */
public class SessionManagement {// Shared Preferences

    public String username="";
    public String user_department="";
    public String user_account="";

    SharedPreferences pref;

    // Editor for Shared preferences
    Editor editor;

    // Context
    Context _context;

    // Shared pref mode
    int PRIVATE_MODE = 0;

    // Sharedpref file name
    private static final String PREF_NAME = "USER";

    // All Shared Preferences Keys
    private static final String IS_LOGIN = "IsLoggedIn";

    // User name (make variable public to access from outside)
    public static final String KEY_NAME = "name";

    // Email address (make variable public to access from outside)
    public static final String KEY_ACCOUNT_TYPE = "account";
    public static final String KEY_DEPARTMENT = "department";

    // Constructor
    public SessionManagement(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }
    public void createLoginSession(String name, String account,String department){
        // Storing login value as TRUE
        editor.putBoolean(IS_LOGIN, true);

        // Storing name in pref
        editor.putString(KEY_NAME, name);

        // Storing email in pref
        editor.putString(KEY_ACCOUNT_TYPE, account);
        editor.putString(KEY_DEPARTMENT, department);
        // commit changes
        editor.commit();
        userDetails();
    }

    public void userDetails()
    {
        username=pref.getString(KEY_NAME,"");
        user_department=pref.getString(KEY_DEPARTMENT,"");
        user_account = pref.getString(KEY_ACCOUNT_TYPE,"");
    }

    /**
     * Clear session details
     * */
    public void logoutUser(){
        // Clearing all data from Shared Preferences
        editor.clear();
        editor.putBoolean(IS_LOGIN, false);
        editor.commit();
        username="";
        user_department="";


    }

    /**
     * Quick check for login
     * **/
    // Get Login State
    public boolean isLoggedIn(){
        return pref.getBoolean(IS_LOGIN,false);
    }

    }

