package in.ac.ksrce.ksrce2;

import android.annotation.TargetApi;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.AbsListView.LayoutParams;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;


/**
 * Created by gokul on 03-01-2016.
 */
public class home_fragment extends Fragment {

    private ListView ug_list;
    private ListView pg_list;
    private WebView info;
    ImageView img_animation;

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.home_fragment,container,false);
        img_animation = (ImageView)v.findViewById(R.id.imageanimation);
        img_animation.setVisibility(View.INVISIBLE);
        info = (WebView) v.findViewById(R.id.text1);
        info.setBackgroundColor(Color.TRANSPARENT);
        String text = "<html><body style=\"text-align:justify\"> %s </body></Html>";
        String data = getResources().getString(R.string.info1);
        info.loadData(String.format(text, data), "text/html", "utf-8");
        ug_list = (ListView)v.findViewById(R.id.ug_course_list);
        Ug_course_adapter ug_course_adapter = new Ug_course_adapter(getContext());
        ug_list.setAdapter(ug_course_adapter);
        setListViewHeightBasedOnChildren(ug_list);
        ug_list.setClickable(true);
        ug_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                switch (position) {
                    case 0: {
                        show_course_details_fragment.title_text="Electronics & Communication Engineering";
                        show_course_details_fragment.coarse_img=R.drawable.ece;
                        show_course_details_fragment.coarse_text=R.string.ece_text;
                        break;
                    }
                    case 1: {
                        show_course_details_fragment.title_text="Electrical & Electronics Engineering";
                        show_course_details_fragment.coarse_img=R.drawable.eee;
                        show_course_details_fragment.coarse_text=R.string.eee_text;
                        break;
                    }
                    case 2: {
                        show_course_details_fragment.title_text="Computer Science Engineering";
                        show_course_details_fragment.coarse_img=R.drawable.cs;
                        show_course_details_fragment.coarse_text=R.string.cs_text;
                        break;
                    }
                    case 3: {
                        show_course_details_fragment.title_text="Mechanical Engineering";
                        show_course_details_fragment.coarse_img=R.drawable.mech;
                        show_course_details_fragment.coarse_text=R.string.mech_text;
                        break;
                    }
                    case 4: {

                        show_course_details_fragment.title_text="Civil Engineering";
                        show_course_details_fragment.coarse_img=R.drawable.civil;
                        show_course_details_fragment.coarse_text=R.string.civil_text;
                        break;
                    }
                    case 5: {

                        show_course_details_fragment.title_text="Automobile Engineering";
                        show_course_details_fragment.coarse_img=R.drawable.auto;
                        show_course_details_fragment.coarse_text=R.string.auto_text;
                        break;
                    }
                    case 6: {

                        show_course_details_fragment.title_text="Information Technology";
                        show_course_details_fragment.coarse_img=R.drawable.it;
                        show_course_details_fragment.coarse_text=R.string.it_text;
                        break;
                    }
                }
                android.support.v4.app.FragmentManager fragmentManager = getFragmentManager();
                android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                show_course_details_fragment fragment = new show_course_details_fragment();
                fragmentTransaction.replace(R.id.mainContent,fragment);
                fragmentTransaction.addToBackStack(home_fragment.class.getName());
                fragmentTransaction.commit();

            }
        });
        pg_list = (ListView)v.findViewById(R.id.pg_course_list);
        Pg_course_adapter pg_course_adapter = new Pg_course_adapter(getContext());
        pg_list.setAdapter(pg_course_adapter);
        setListViewHeightBasedOnChildren(pg_list);
        pg_list.setClickable(true);
        pg_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                switch (position) {
                    case 0: {

                        show_course_details_fragment.title_text = "Communication Systems";
                        show_course_details_fragment.coarse_img = R.drawable.communication;
                        show_course_details_fragment.coarse_text = R.string.communication_text;
                        break;
                    }
                    case 1: {

                        show_course_details_fragment.title_text = "Embedded Systems";
                        show_course_details_fragment.coarse_img = R.drawable.ece;
                        show_course_details_fragment.coarse_text = R.string.embedded_text;
                        break;
                    }
                    case 2: {

                        show_course_details_fragment.title_text = "VLSI";
                        show_course_details_fragment.coarse_img = R.drawable.vlsi;
                        show_course_details_fragment.coarse_text = R.string.vlsi_text;
                        break;
                    }
                    case 3: {

                        show_course_details_fragment.title_text = "Power Electronics and Drives";
                        show_course_details_fragment.coarse_img = R.drawable.power;
                        show_course_details_fragment.coarse_text = R.string.power_text;
                        break;
                    }
                    case 4: {

                        show_course_details_fragment.title_text = "Structural Engineering";
                        show_course_details_fragment.coarse_img = R.drawable.structural;
                        show_course_details_fragment.coarse_text = R.string.structural_text;
                        break;
                    }
                    case 5: {

                        show_course_details_fragment.title_text = "Computer Science and Engineering";
                        show_course_details_fragment.coarse_img = R.drawable.cs;
                        show_course_details_fragment.coarse_text = R.string.cs_text;
                        break;
                    }
                    case 6: {

                        show_course_details_fragment.title_text = "Computer Applications";
                        show_course_details_fragment.coarse_img = R.drawable.mca;
                        show_course_details_fragment.coarse_text = R.string.mca_text;
                        break;
                    }
                    case 7: {

                        show_course_details_fragment.title_text = "Business Administration";
                        show_course_details_fragment.coarse_img = R.drawable.mba;
                        show_course_details_fragment.coarse_text = R.string.mba_text;
                        break;
                    }
                }
                android.support.v4.app.FragmentManager fragmentManager = getFragmentManager();
                android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                show_course_details_fragment fragment = new show_course_details_fragment();
                fragmentTransaction.replace(R.id.mainContent, fragment);
                fragmentTransaction.addToBackStack(home_fragment.class.getName());
                fragmentTransaction.commit();

            }
        });
        return v;
    }

    private void setListViewHeightBasedOnChildren(ListView listView) {
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null)
            return;

        int desiredWidth = MeasureSpec.makeMeasureSpec(listView.getWidth(), MeasureSpec.UNSPECIFIED);
        int totalHeight=0;
        View view = null;

        for (int i = 0; i < listAdapter.getCount(); i++)
        {
            view = listAdapter.getView(i, view, listView);

            if (i == 0)
                view.setLayoutParams(new ViewGroup.LayoutParams(desiredWidth,
                        LayoutParams.MATCH_PARENT));

            view.measure(desiredWidth, MeasureSpec.UNSPECIFIED);
            totalHeight += view.getMeasuredHeight();

        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + ((listView.getDividerHeight()) * (listAdapter.getCount()));

        listView.setLayoutParams(params);
        listView.requestLayout();
    }


}
