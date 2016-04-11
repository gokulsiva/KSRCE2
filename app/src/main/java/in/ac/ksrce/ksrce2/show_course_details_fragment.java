package in.ac.ksrce.ksrce2;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * Created by vignesh on 31-01-2016.
 */
public class show_course_details_fragment extends Fragment {

   public static TextView Title;
   public static ImageView Coarse_Image;
   public static TextView Coarse_Text;
    public static int coarse_img;
    public static String title_text;
    public static int coarse_text;

   @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.show_course_details_fragment,container,false);
       MainActivity.back_operation = 1;
       Title = (TextView)v.findViewById(R.id.Title);
        Coarse_Image = (ImageView)v.findViewById(R.id.Coarse_Image);
        Coarse_Text = (TextView)v.findViewById(R.id.Coarse_Text);
       Title.setText(title_text);
       Coarse_Image.setImageResource(coarse_img);
       Coarse_Text.setText(coarse_text);
        return v;
    }

}
