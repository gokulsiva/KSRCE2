package in.ac.ksrce.ksrce2;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private DrawerLayout drawerLayout;
    private ListView listView;
    private ActionBarDrawerToggle drawerListener;
    public static int back_operation;
    SessionManagement session;
    public static int drawerAnimator = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawerLayout=(DrawerLayout)findViewById(R.id.drawerLayout);
        drawerLayout.setScrimColor(Color.TRANSPARENT);
        listView=(ListView)findViewById(R.id.drawerList);
        MyAdapter myAdapter = new MyAdapter(this);
        listView.setAdapter(myAdapter);
        //listView.setAdapter(new ArrayAdapter<>(this,android.R.layout.simple_expandable_list_item_1,menu));
        listView.setOnItemClickListener(this);
        session = new SessionManagement(getApplicationContext());
        session.userDetails();
        if(!(session.isLoggedIn()))
        {
            Login_fragment fragment=new Login_fragment();
            android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.mainContent, fragment);
            fragmentTransaction.commit();
        }
        else
        {
            home_fragment fragment=new home_fragment();
            android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.mainContent, fragment);
            fragmentTransaction.commit();

        }

        drawerListener=new ActionBarDrawerToggle(this,drawerLayout,R.string.drawer_open,R.string.drawer_close){
            @Override
            public void onDrawerOpened(View drawerView) {
               // Toast.makeText(MainActivity.this,"Drawer Opened",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
              //  Toast.makeText(MainActivity.this, "Drawer Closed", Toast.LENGTH_SHORT).show();
            }
        };
        drawerLayout.setDrawerListener(drawerListener);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerListener.syncState();
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return drawerListener.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerListener.onConfigurationChanged(newConfig);
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        selectItem(position);
        switch (position)
        {

            case 0:
            {
                if(!(session.isLoggedIn()))
                {
                    Login_fragment fragment=new Login_fragment();
                    android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.mainContent, fragment);
                    fragmentTransaction.commit();
                    drawerLayout.closeDrawer(Gravity.LEFT);
                    Toast.makeText(this,"Please Login first",Toast.LENGTH_SHORT).show();
                }
                else {
                home_fragment fragment=new home_fragment();
                android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.mainContent, fragment);
                fragmentTransaction.commit();
                drawerLayout.closeDrawer(Gravity.LEFT);}
                break;
            }
            case 1:
            {
                if(!(session.isLoggedIn()))
                {
                    Login_fragment fragment=new Login_fragment();
                    android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.mainContent, fragment);
                    fragmentTransaction.commit();
                    drawerLayout.closeDrawer(Gravity.LEFT);
                    Toast.makeText(this,"Please Login first",Toast.LENGTH_SHORT).show();
                }
                else {
                    result_fragment fragment = new result_fragment();
                    android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.mainContent, fragment);
                    fragmentTransaction.commit();
                    drawerLayout.closeDrawer(Gravity.LEFT);
                }
                break;
            }
            case 2:
            {
                if(!(session.isLoggedIn()))
                {
                    Login_fragment fragment=new Login_fragment();
                    android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.mainContent, fragment);
                    fragmentTransaction.commit();
                    drawerLayout.closeDrawer(Gravity.LEFT);
                    Toast.makeText(this,"Please Login first",Toast.LENGTH_SHORT).show();
                }
                else {
                    Placement_fragment fragment = new Placement_fragment();
                    android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.mainContent, fragment);
                    fragmentTransaction.commit();
                    drawerLayout.closeDrawer(Gravity.LEFT);
                }
                break;
            }
            case 3:
            {
                if(!(session.isLoggedIn()))
                {
                    Login_fragment fragment=new Login_fragment();
                    android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.mainContent, fragment);
                    fragmentTransaction.commit();
                    drawerLayout.closeDrawer(Gravity.LEFT);
                    Toast.makeText(this,"Please Login first",Toast.LENGTH_SHORT).show();
                }
                else {
                    Circular_fragment fragment = new Circular_fragment();
                    android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.mainContent, fragment);
                    fragmentTransaction.commit();
                    drawerLayout.closeDrawer(Gravity.LEFT);
                }
                break;
            }
            case 4:
            {
                if(!(session.isLoggedIn()))
                {
                    Login_fragment fragment=new Login_fragment();
                    android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.mainContent, fragment);
                    fragmentTransaction.commit();
                    drawerLayout.closeDrawer(Gravity.LEFT);
                    Toast.makeText(this,"Please Login first",Toast.LENGTH_SHORT).show();
                }
                else {
                    File directory = new File(Environment.getExternalStorageDirectory() +"/ksrce/"+session.username);
                    if (!directory.exists()) {
                        directory.mkdir();
                    }
                    Uri uri = Uri.parse(Environment.getExternalStorageDirectory() +"/ksrce/");
                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_VIEW);
                    intent.setDataAndType(uri, "resource/folder");
                    if (intent.resolveActivityInfo(getPackageManager(), 0) != null) {
                        startActivity(intent);
                    } else {

                        try {
                            intent.setDataAndType(uri, "*/*");
                            startActivity(Intent.createChooser(intent, "Choose a FILE browser"));
                            Toast.makeText(getApplicationContext(), "If no File Manager found please install one", Toast.LENGTH_LONG).show();
                        } catch (Exception ex) {
                            Toast.makeText(getApplicationContext(), "Please Install a File manager and try again", Toast.LENGTH_LONG).show();
                        }
                    }
                    drawerLayout.closeDrawer(Gravity.LEFT);
                }
                break;
            }

            case 5:
            {
                if(!(session.isLoggedIn()))
                {
                    Login_fragment fragment=new Login_fragment();
                    android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.mainContent, fragment);
                    fragmentTransaction.commit();
                    drawerLayout.closeDrawer(Gravity.LEFT);
                    Toast.makeText(this,"Please Login first",Toast.LENGTH_SHORT).show();
                }
                else {
                    session.userDetails();
                    String accountType = session.user_account;
                    String userDepartment = session.user_department.toLowerCase();
                    String user = session.username;
                    switch (accountType)
                    {
                        case "Student":
                        {
                            MainActivity.back_operation = 1;
                            Student_database fragment = new Student_database();
                            fragment.regno = user;
                            android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                            fragmentTransaction.replace(R.id.mainContent, fragment);
                            fragmentTransaction.commit();
                            drawerLayout.closeDrawer(Gravity.LEFT);
                            break;
                        }
                        case "Staff":
                        {
                            MainActivity.back_operation = 1;
                            Regno_fragment fragment = new Regno_fragment();
                            android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                            fragmentTransaction.replace(R.id.mainContent, fragment);
                            fragmentTransaction.commit();
                            drawerLayout.closeDrawer(Gravity.LEFT);
                            break;
                        }
                    }

                }
                break;

            }

            case 6:
            {
                if(!(session.isLoggedIn()))
                {
                    Login_fragment fragment=new Login_fragment();
                    android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.mainContent, fragment);
                    fragmentTransaction.commit();
                    drawerLayout.closeDrawer(Gravity.LEFT);
                    Toast.makeText(this,"Please Login first",Toast.LENGTH_SHORT).show();
                }
                else {
                    session.userDetails();
                    String accountType = session.user_account;
                    String userDepartment = session.user_department.toLowerCase();
                    switch (accountType)
                    {
                        case "Student":
                        {
                            MainActivity.back_operation = 1;
                            Config.Contact_table = Config.Contact_url + userDepartment+"_staffs";
                            Reference_Contacts fragment = new Reference_Contacts();
                            android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                            fragmentTransaction.replace(R.id.mainContent, fragment);
                            fragmentTransaction.commit();
                            drawerLayout.closeDrawer(Gravity.LEFT);
                            break;
                        }
                        case "Staff":
                        {
                            MainActivity.back_operation = 1;
                            Staff_reference_contacts fragment = new Staff_reference_contacts();
                            android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                            fragmentTransaction.replace(R.id.mainContent, fragment);
                            fragmentTransaction.commit();
                            drawerLayout.closeDrawer(Gravity.LEFT);
                            break;
                        }
                    }

                }
                break;

            }

            case 7:
            {
                if(!(session.isLoggedIn()))
                {
                    Login_fragment fragment=new Login_fragment();
                    android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.mainContent, fragment);
                    fragmentTransaction.commit();
                    drawerLayout.closeDrawer(Gravity.LEFT);
                    Toast.makeText(this,"Please Login first",Toast.LENGTH_SHORT).show();
                }
                else {
                    About_us fragment = new About_us();
                    android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.mainContent, fragment);
                    fragmentTransaction.commit();
                    drawerLayout.closeDrawer(Gravity.LEFT);
                }
                break;

            }
            case 8:
            {
                if(!(session.isLoggedIn()))
                {
                    Login_fragment fragment=new Login_fragment();
                    android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.mainContent, fragment);
                    fragmentTransaction.commit();
                    drawerLayout.closeDrawer(Gravity.LEFT);
                    Toast.makeText(this,"Please Login first",Toast.LENGTH_SHORT).show();
                }
                else {
                    Logout_fragment fragment = new Logout_fragment();
                    android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.mainContent, fragment);
                    fragmentTransaction.commit();
                    drawerLayout.closeDrawer(Gravity.LEFT);
                }
                break;
            }

            case 9:
            {
                if(!(session.isLoggedIn()))
                {
                    Login_fragment fragment=new Login_fragment();
                    android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.mainContent, fragment);
                    fragmentTransaction.commit();
                    drawerLayout.closeDrawer(Gravity.LEFT);
                    Toast.makeText(this,"Please Login first",Toast.LENGTH_SHORT).show();
                }
                else {
                    Author_Credits fragment = new Author_Credits();
                    android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.mainContent, fragment);
                    fragmentTransaction.commit();
                    drawerLayout.closeDrawer(Gravity.LEFT);
                }
                break;


            }
        }


    }

    public void selectItem(int position) {
        listView.setItemChecked(position, true);
    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(Gravity.LEFT)){
            drawerLayout.closeDrawer(Gravity.LEFT);
        }
        if(!(drawerLayout.isDrawerOpen(Gravity.LEFT))&&(back_operation == 0))
        {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Exit");
            builder.setIcon(R.mipmap.ic_exit);
            builder.setMessage("Are you sure want to exit ?").setCancelable(false).setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();

        }
        if(back_operation != 0)
        {
            if(back_operation == 2)
            {
                back_operation = 1;
                Staff_reference_contacts fragment = new Staff_reference_contacts();
                android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.mainContent, fragment);
                fragmentTransaction.commit();
            }
            else {
                back_operation = 0;
                home_fragment fragment = new home_fragment();
                android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.mainContent, fragment);
                fragmentTransaction.commit();
            }

        }

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_MENU)
        {
            drawerLayout.openDrawer(Gravity.LEFT);
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onPause() {
        if(drawerLayout.isDrawerOpen(Gravity.LEFT)){
            drawerLayout.closeDrawer(Gravity.LEFT);
        }
        super.onPause();
    }
}
class MyAdapter extends BaseAdapter
{
    private Context context;
String[] menu;
    int[] image={R.drawable.ic_home,R.mipmap.ic_result,R.drawable.ic_placement,R.mipmap.circular,R.mipmap.ic_downloads,R.mipmap.ic_student_record,R.mipmap.ic_staffs,R.mipmap.contact_us,R.mipmap.ic_logout,R.mipmap.about_author};

    public MyAdapter(Context context) {
        this.context=context;
        menu=context.getResources().getStringArray(R.array.menu);
    }

    @Override
    public int getCount() {
        return menu.length;
    }

    @Override
    public Object getItem(int position) {
        return menu[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row;
        if(convertView==null){
           LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
             row=inflater.inflate(R.layout.custom_row,parent,false);
        }
        else
        {
          row=convertView;
        }
        TextView titleText= (TextView) row.findViewById(R.id.text);
        ImageView titleImage=(ImageView)row.findViewById(R.id.image);
        titleText.setText(menu[position]);
        titleImage.setImageResource(image[position]);

        return row;
    }
}