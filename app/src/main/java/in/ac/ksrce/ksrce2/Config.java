package in.ac.ksrce.ksrce2;

/**
 * Created by gokul on 15-01-2016.
 */
public class Config {

    public static final String Regno = "Regno";
    public static final String Name = "Name";
    public static final String Total = "Total";
    public static final String Result = "Result";
    public static final String Result_Array = "Result_Array";

    public static  String LOGIN_URL = "";
    public static  String Contact_url = "http://gokulonlinedatabase.net16.net/contacts/contacts.php?table=";
    public static  String Contact_table = "";

    //Keys for email and password as defined in our $_POST['key'] in login.php
    public static final String KEY_USERID = "userid";
    public static final String KEY_PASSWORD = "password";

    //If server response is equal to this that means login is successful
    public static final String LOGIN_SUCCESS = "success";

    //Keys for Sharedpreferences
    //This would be the name of our shared preferences
    public static final String SHARED_PREF_NAME = "ksrce";

    //This would be used to store the email of current logged in user
    public static final String USERID_SHARED_PREF = "userid";

    //We will use this to store the boolean in sharedpreference to track user is loggedin or not
    public static final String LOGGEDIN_SHARED_PREF = "false";

    public static final String PASSWORD_SHARED_PREF = "";

    public static final String ACCOUNT_SHARED_PREF = "account";

    public static final String DEPARTMENT_SHARED_PREF = "department";
}